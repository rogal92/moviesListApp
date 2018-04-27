package com.app.movies.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieDto {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private int production;
}
