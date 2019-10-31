package com.theask.theaskapi.service;

import com.theask.theaskapi.model.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAllSortByAlphabet();
}
