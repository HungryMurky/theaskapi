FROM bellsoft/liberica-openjdk-alpine-musl:11 as build

WORKDIR /app

COPY --chown=0:0 . .
RUN ./gradlew --quiet --no-daemon clean build -x test

#===============================================================

FROM bellsoft/liberica-openjdk-alpine-musl:11 as production

ARG DB_URL="jdbc:mysql://localhost/theask"
ARG DB_USER="root"
ARG DB_PASSWORD="root"
ARG APP_BASE_URL="http://localhost:8080"
ARG APP_NAME="Theask API"
ARG APP_PROFILE="default"

ENV WORKDIR="/app" \
    DB_URL=${DB_URL} \
    DB_USER=${DB_USER} \
    DB_PASSWORD=${DB_PASSWORD} \
    APP_NAME=${APP_NAME} \
    APP_PROFILE=${APP_PROFILE}

WORKDIR ${WORKDIR}

COPY --chown=0:0 --from=build ${WORKDIR}/build/libs/*.jar ${WORKDIR}/theask-api.jar

EXPOSE 8080

CMD ["java", \
     "-Xms512m", \
     "-Xmx1g", \
     "-Xss512k", \
     "-Djava.security.egd=file:/dev/./urandom", \
     "-Dspring.datasource.url=${DB_URL}", \
     "-Dspring.datasource.username=${DB_USER}", \
     "-Dspring.datasource.password=${DB_PASSWORD}", \
     "-Dspring.application.name=${APP_NAME}", \
     "-Dspring.profiles.active=${APP_PROFILE}", \
     "-jar", \
     "theask-api.jar"]