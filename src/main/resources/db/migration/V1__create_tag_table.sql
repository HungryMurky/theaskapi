create table tag
(
    id   bigint(64)   not null
        primary key auto_increment,
    text varchar(255) null
);
create table question
(
    id     bigint(64)   not null auto_increment
        primary key,
    text   varchar(255) null,
    rating bigint       null,
    tag_id bigint(64)   null
);
alter table question
    add foreign key question_tag_fkey (tag_id) references tag (id);


