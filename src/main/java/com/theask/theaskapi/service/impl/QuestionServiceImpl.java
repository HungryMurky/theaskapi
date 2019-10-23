package com.theask.theaskapi.service.impl;

import com.theask.theaskapi.model.Question;
import com.theask.theaskapi.repository.QuestionRepository;
import com.theask.theaskapi.repository.QuestionRepositoryImpl;
import com.theask.theaskapi.service.QuestionService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findAllSortByRating() {
       return questionRepository.findAll()
               .stream()
               .sorted(Comparator.comparing(Question::getRating))
               .collect(Collectors.toList())
               ;

    }
    @Override
    public List<Question> findAllByTag(String tag) {
        return questionRepository.findAll()
                .stream()
                .filter(it->it.getTag().getText().equals(tag))
                .collect(Collectors.toList())
                ;
    }
}
