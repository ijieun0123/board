package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @NotBlank
    private final String username;

    @NotBlank
    private final String password;

    @NotNull
    private final Integer age;

    public SignUpRequestDto(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
