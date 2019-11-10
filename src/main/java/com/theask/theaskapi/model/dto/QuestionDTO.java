package com.theask.theaskapi.model.dto;

import com.theask.theaskapi.model.Tag;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class QuestionDTO {

    private String text;

    private Long tagId;

    private Long rating;
}
