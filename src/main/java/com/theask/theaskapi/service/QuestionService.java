package com.theask.theaskapi.service;

import com.theask.theaskapi.model.Question;
import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.model.dto.QuestionSimpleDTO;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    List<Question> findAllSortByRating();

    List<Question> findAllByTag(String tag);

    List<Question> findTopQuestionsByTag(String tag, Integer quantity);

    Map<Tag, Long> groupQuestionsByTag();

    Question save(Question question);

    Question save(QuestionSimpleDTO questionSimpleDTO);

}
