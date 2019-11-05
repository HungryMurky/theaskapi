package com.theask.theaskapi.repository;

import com.theask.theaskapi.model.Question;
import com.theask.theaskapi.model.Tag;

import java.util.List;

//TODO: change Fake implementation to JPA repository
public interface QuestionRepository {
    default List<Question> findAll() {
        var tagJava = new Tag().setId(1L).setText("java");
        var tagSql = new Tag().setId(2L).setText("sql");
        var tagSpring = new Tag().setId(3L).setText("spring");
        return List.of(
                new Question().setId(1L).setText("What is a stream?").setRating(300L).setTag(tagJava),
                new Question().setId(2L).setText("What is the difference between intermediate and terminal operations?")
                        .setRating(150L).setTag(tagJava),
                new Question().setId(3L).setText("What is a primary key?").setRating(400L).setTag(tagSql),
                new Question().setId(4L).setText("What is a foreign key?").setRating(250L).setTag(tagSql),
                new Question().setId(5L).setText("What are beans in spring?").setRating(100L).setTag(tagSpring)
        );
    }
}
