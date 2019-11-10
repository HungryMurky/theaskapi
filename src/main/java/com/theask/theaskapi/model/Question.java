package com.theask.theaskapi.model;

import com.theask.theaskapi.model.dto.QuestionDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "rating")
    private Long rating;

    public Question(QuestionDTO questionDTO) {
        this.text = questionDTO.getText();
        this.rating = questionDTO.getRating();
        this.tag = new Tag().setId(questionDTO.getTagId());
    }

    public Question() {
    }
}
