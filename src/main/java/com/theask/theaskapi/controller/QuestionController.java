package com.theask.theaskapi.controller;

import com.theask.theaskapi.model.Question;
import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.service.QuestionService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;


    @GetMapping("/api/questions")
    public List<Question> findAllByRating() {
        return questionService.findAllSortByRating();
    }
    @GetMapping("/api/questions-by-tag")
    public List<Question> returnQuestionsByTag(@RequestParam String tag)
    {
        return questionService.findAllByTag(tag);
    }
}
