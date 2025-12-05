package com.rooban.praisehub.service;


import com.rooban.praisehub.dto.LouvorRequest;
import com.rooban.praisehub.dto.LouvorResponse;
import com.rooban.praisehub.dto.LouvorUpdateRequest;
import com.rooban.praisehub.exception.LouvorNotFoundException;
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
        l.setLetra(dto.letra());
        l.setTags(dto.tags());
        l.setDuracao(dto.duracao());

        return repository.save(l);
    }

    public List<Louvor> listarTodos() {
        return repository.findAll();
    }

    public Louvor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new LouvorNotFoundException(id));
    }

    public List<Louvor> buscarPorTitulo(String titulo) {
        List<Louvor> lista = repository.findByTituloContainingIgnoreCase(titulo);

        if (lista.isEmpty()) {
            throw new LouvorNotFoundException("Nenhum louvor encontrado com o título: " + titulo);
        }

        return lista;
    }

    public List<Louvor> buscarPorTag(String tag) {
        List<Louvor> lista = repository.findbyTag(tag);

        if (lista.isEmpty()) {
            throw new LouvorNotFoundException("Nenhum louvor encontrado com o tag: " + tag);
        }

        return lista;
    }

    public Louvor atualizar(Long id, LouvorUpdateRequest dto) {
        Louvor l = buscarPorId(id);

        if (dto.titulo() != null) l.setTitulo(dto.titulo());
        if (dto.autor() != null) l.setAutor(dto.autor());
        if (dto.tom() != null) l.setTom(dto.tom());
        if (dto.letra() != null) l.setLetra(dto.letra());
        if (dto.tags() != null) {
            l.getTags().clear();
            l.getTags().addAll(dto.tags());
        }
        if (dto.duracao() != null) l.setDuracao(dto.duracao());

        return repository.save(l);
    }

    public void deletar(Long id) {
        Louvor l = buscarPorId(id);
        repository.delete(l);
    }
}
