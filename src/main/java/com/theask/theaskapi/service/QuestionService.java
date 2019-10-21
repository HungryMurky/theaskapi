package com.theask.theaskapi.service;

import com.theask.theaskapi.model.Question;
import java.util.List;

public interface QuestionService {

    List<Question> findAllSortByRating();

    List<Question> findAllByTag(String tag);

}
