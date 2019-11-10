package com.theask.theaskapi.service.impl;

import com.theask.theaskapi.model.Question;
import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.model.dto.QuestionSimpleDTO;
import com.theask.theaskapi.repository.QuestionRepository;
import com.theask.theaskapi.repository.TagRepository;
import com.theask.theaskapi.service.QuestionService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;

    @Override
    public List<Question> findAllSortByRating() {
        return questionRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Question::getRating))
                .collect(Collectors.toList());

    }


    @Override
    public List<Question> findAllByTag(String tag) {
        return questionRepository.findAll()
                .stream()
                .filter(it -> it.getTag().getText().equals(tag))
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> findTopQuestionsByTag(String tag, Integer quantity) {
        return questionRepository.findAll()
                .stream()
                .filter(it -> it.getTag().getText().equals(tag))
                .sorted(Comparator.comparing(Question::getRating).reversed())
                .limit(quantity)
                .collect(Collectors.toList());

    }

    @Override
    public Map<Tag, Long> groupQuestionsByTag() {
        return questionRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Question::getTag, Collectors.counting()));
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question save(QuestionSimpleDTO questionSimpleDTO) {
        Tag tag = tagRepository.findTagByText(questionSimpleDTO.getTag());
        if (tag == null) {
            tag = tagRepository.save(new Tag().setText(questionSimpleDTO.getTag()));
        }
        Question question = new Question();
        question.setRating(questionSimpleDTO.getRating());
        question.setText(questionSimpleDTO.getText());
        question.setTag(tag);
        return questionRepository.save(question);

    }


}
