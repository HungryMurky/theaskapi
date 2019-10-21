package com.theask.theaskapi.service.impl;

import com.theask.theaskapi.model.Question;
import com.theask.theaskapi.model.Tag;
import com.theask.theaskapi.repository.QuestionRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl testSubject;

    private final Tag tagJava = new Tag().setId(1L).setText("java");
    private final Tag tagSql = new Tag().setId(2L).setText("sql");
    private final Tag tagSpring = new Tag().setId(3L).setText("spring");

    private final List<Question> questions = List.of(
            new Question().setId(1L).setText("What is a stream?").setRating(300L).setTag(tagJava),
            new Question().setId(2L).setText("What is the difference between intermediate and terminal operations?")
                    .setRating(150L).setTag(tagJava),
            new Question().setId(3L).setText("What is a primary key?").setRating(400L).setTag(tagSql),
            new Question().setId(4L).setText("What is a foreign key?").setRating(250L).setTag(tagSql),
            new Question().setId(5L).setText("What are beans in spring?").setRating(100L).setTag(tagSpring)
    );

    @BeforeEach
    void setUp() {
        when(questionRepository.findAll()).thenReturn(questions);
    }

    @Test
    void findAllSortByRating() {
        //given

        //when
        var result = testSubject.findAllSortByRating();

        //then
        assertEquals(result.size(), questions.size());
        assertEquals(
                result.stream().map(Question::getRating).collect(toList()),
                questions.stream().map(Question::getRating).sorted().collect(toList())
        );
    }

    @Test
    void findAllByTag() {
        //given
        var tag = tagJava.getText();

        //when
        var result = testSubject.findAllByTag(tag);

        //then
        assertTrue(
                result.stream()
                        .map(Question::getTag)
                        .allMatch(it -> it.equals(tagJava))
        );
    }
}