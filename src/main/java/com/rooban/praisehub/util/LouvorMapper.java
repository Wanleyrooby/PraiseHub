package com.rooban.praisehub.util;

import com.rooban.praisehub.dto.LouvorRequest;
import com.rooban.praisehub.dto.LouvorResponse;
import com.rooban.praisehub.dto.LouvorUpdateRequest;
import com.rooban.praisehub.model.Louvor;
import org.springframework.stereotype.Component;

@Component
public class LouvorMapper {

    public Louvor toEntity(LouvorRequest dto) {
        Louvor l = new Louvor();

        l.setTitulo(dto.titulo());
        l.setAutor(dto.autor());
        l.setTom(dto.tom());
        l.setLetra(dto.letra());
        l.setTags(dto.tags());
        l.setDuracao(dto.duracao());

        return l;
    }

    public void updateEntity(LouvorUpdateRequest dto, Louvor l) {
        if (dto.titulo() != null) l.setTitulo(dto.titulo());
        if (dto.autor() != null) l.setAutor(dto.autor());
        if (dto.tom() != null) l.setTom(dto.tom());
        if (dto.letra() != null) l.setLetra(dto.letra());

        if (dto.tags() != null) {
            l.getTags().clear();
            l.getTags().addAll(dto.tags());
        }

        if (dto.duracao() != null) l.setDuracao(dto.duracao());
    }

    public LouvorResponse toResponse(Louvor l) {
        return new LouvorResponse(l);
    }
}
