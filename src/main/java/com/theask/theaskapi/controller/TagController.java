package com.theask.theaskapi.controller;

import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.service.TagService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("api/tags")
    public List<Tag> findAllByAlphabet() {
        return tagService.findAllSortByAlphabet();
    }

    @PostMapping("api/tags")
    public Tag save(@RequestBody Tag tag) {
        return tagService.save(tag);
    }
}
