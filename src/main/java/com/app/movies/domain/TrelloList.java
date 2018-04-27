package com.app.movies.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TrelloList {

    private String id;
    private String name;
    private boolean isClosed;
}
