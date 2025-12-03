package com.rooban.praisehub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record LouvorRequest(

        @NotBlank(message = "O título é obrigatório.")
        String titulo,

        @NotBlank
        String autor,

        @Size(max = 50, message = "O tom deve ter no máximo 50 caracteres.")
        String tom,

        @NotBlank
        String letra,

        List<String> tags,

        Integer duracao

) {

}
