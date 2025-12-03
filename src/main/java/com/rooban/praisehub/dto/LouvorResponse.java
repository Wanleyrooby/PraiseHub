package com.rooban.praisehub.dto;

import com.rooban.praisehub.model.Louvor;

import java.time.LocalDateTime;
import java.util.List;

public record LouvorResponse(
        Long id,
        String titulo,
        String autor,
        String tom,
        String letra,
        List<String> tags,
        Integer duracao,
        LocalDateTime horarioCriacao,
        LocalDateTime horarioAtualizacao
) {

    // Construtor facilitador para criar o DTO diretamente a partir da entidade
    public LouvorResponse(Louvor louvor) {
        this(
                louvor.getId(),
                louvor.getTitulo(),
                louvor.getAutor(),
                louvor.getTom(),
                louvor.getLetra(),
                louvor.getTags(),
                louvor.getDuracao(),
                louvor.getHorarioCriacao(),
                louvor.getHorarioAtualizacao()
        );
    }
}
