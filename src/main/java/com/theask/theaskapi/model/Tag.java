package com.theask.theaskapi.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text")
    private String text;

}
