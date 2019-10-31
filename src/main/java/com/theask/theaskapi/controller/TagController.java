package com.theask.theaskapi.controller;

import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.service.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("api/tags")
    public List<Tag> findAllByAlphabet() {
        return tagService.findAllSortByAlphabet();
    }

}
