package com.theask.theaskapi.service.impl;

import com.theask.theaskapi.model.Question;
import com.theask.theaskapi.repository.QuestionRepository;
import com.theask.theaskapi.service.QuestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    /**
     * @return list of all questions from {@link QuestionRepository#findAll()} sorted by rating.
     */
    @Override
    public List<Question> findAllSortByRating() {
        //TODO: implement
        return null;
    }

    /**
     * @param tag text tag
     * @return list of all questions from {@link QuestionRepository#findAll()}
     * with {@link Question#getTag()} equals to tag param.
     */
    @Override
    public List<Question> findAllByTag(String tag) {
        //TODO: implement
        return null;
    }
}
