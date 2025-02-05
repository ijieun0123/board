package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateBoardRequestDto {

    @NotBlank
    private final String title;

    @NotBlank
    private final String contents;

    @NotBlank
    private final String username;

    public CreateBoardRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
