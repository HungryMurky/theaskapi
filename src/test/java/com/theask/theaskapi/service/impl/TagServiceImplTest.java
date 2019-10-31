package com.theask.theaskapi.service.impl;

import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.repository.TagRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TagServiceImpl testSubject;

    private final List<Tag> tags = List.of(
            new Tag().setText("bbb"),
            new Tag().setText("aaa"),
            new Tag().setText("ccc")
    );

    @BeforeEach
    void setUp() {
        when(tagRepository.findAll()).thenReturn(tags);
    }

    @Test
    void findAllSortByAlphabet() {
        //given

        //when
        var result = testSubject.findAllSortByAlphabet();

        //then
        assertEquals(result.size(), 3);
        assertAll(
                () -> assertEquals(result.get(0).getText(), "aaa"),
                () -> assertEquals(result.get(1).getText(), "bbb"),
                () -> assertEquals(result.get(2).getText(), "ccc")
        );
    }
}