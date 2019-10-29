package com.theask.theaskapi.repository;


import com.theask.theaskapi.model.Tag;
import java.util.List;

//TODO: change Fake implementation to JPA repository
public interface TagRepository {
    default List<Tag> findAll() {
        return List.of(
                new Tag().setId(1L).setText("java"),
                new Tag().setId(2L).setText("sql"),
                new Tag().setId(3L).setText("spring"),
                new Tag().setId(4L).setText("hibernate"),
                new Tag().setId(1L).setText("docker")
        );
    }
}
