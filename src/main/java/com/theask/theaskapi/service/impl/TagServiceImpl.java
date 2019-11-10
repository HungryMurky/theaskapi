package com.theask.theaskapi.service.impl;

import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.repository.TagRepository;
import com.theask.theaskapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> findAllSortByAlphabet() {
        return tagRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Tag::getText))
                .collect(Collectors.toList());
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }
}
