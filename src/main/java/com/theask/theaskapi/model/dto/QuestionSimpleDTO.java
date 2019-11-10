package com.theask.theaskapi.model.dto;

import lombok.Data;

@Data
public class QuestionSimpleDTO {
    private String text;

    private String tag;

    private Long rating;
}
