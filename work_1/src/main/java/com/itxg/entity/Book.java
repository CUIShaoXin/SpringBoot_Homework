package com.itxg.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private Integer id;
    private String name;
    private String author;
    private Double price;
}