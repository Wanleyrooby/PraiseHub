package com.rooban.praisehub.service;


import com.rooban.praisehub.dto.LouvorRequest;
import com.rooban.praisehub.dto.LouvorResponse;
import com.rooban.praisehub.model.Louvor;
import com.rooban.praisehub.repository.LouvorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LouvorService {

    @Autowired
    private LouvorRepository repository;

    public Louvor criar(LouvorRequest dto) {
        Louvor l = new Louvor();

        l.setTitulo(dto.titulo());
        l.setAutor(dto.autor());
        l.setTom(dto.tom());
        l.setLetra(dto.autor());
        l.setTags(dto.tags());
        l.setDuracao(dto.duracao());

        return repository.save(l);
    }

    public List<Louvor> listarTodos() {
        return repository.findAll();
    }

    public Louvor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Louvor não encontrado."));
    }
}
