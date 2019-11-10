package com.theask.theaskapi.controller;

import com.theask.theaskapi.model.Question;
import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.model.dto.QuestionDTO;
import com.theask.theaskapi.model.dto.QuestionSimpleDTO;
import com.theask.theaskapi.service.QuestionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/api/questions")
    public List<Question> findAllByRating() {
        return questionService.findAllSortByRating();
    }

    @GetMapping("/api/questions-by-tag")
    public List<Question> returnQuestionsByTag(@RequestParam String tag) {
        return questionService.findAllByTag(tag);
    }

    @GetMapping("/api/top-questions-by-tag")
    public List<Question> returnTopQuestionsByTag(@RequestParam String tag, @RequestParam Integer quantity) {
        return questionService.findTopQuestionsByTag(tag, quantity);
    }

    @GetMapping("/api/questions-grouped-by-tag")
    public Map<Tag, Long> returnQuestionsGroupedByTag() {
        return questionService.groupQuestionsByTag();
    }

    @PostMapping("/api/questions")
    public Question save(@RequestBody QuestionDTO questionDTO) {
        return questionService.save(new Question(questionDTO));
    }

    @PostMapping("/api/questions-with-tag")
    public Question saver(@RequestBody QuestionSimpleDTO questionSimpleDTO) {
        return questionService.save(questionSimpleDTO);
    }

}
