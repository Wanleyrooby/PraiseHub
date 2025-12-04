package com.rooban.praisehub.dto;

import java.util.List;

public record LouvorUpdateRequest(
        String titulo,
        String autor,
        String tom,
        String letra,
        List<String> tags,
        Integer duracao
) {
}
