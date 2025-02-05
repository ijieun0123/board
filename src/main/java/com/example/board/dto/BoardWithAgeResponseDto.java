package com.example.board.dto;

import lombok.Getter;

@Getter
public class BoardWithAgeResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    private final Integer age;

    public BoardWithAgeResponseDto(Long id, String title, String contents, Integer age) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.age = age;
    }
}
