package com.theask.theaskapi.model;

import lombok.Data;

@Data
public class Question {

    private Long id;

    private String text;

    private Tag tag;

    private Long rating;

}
