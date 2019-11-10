package com.theask.theaskapi.repository;


import com.theask.theaskapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findTagByText(String text);
}
