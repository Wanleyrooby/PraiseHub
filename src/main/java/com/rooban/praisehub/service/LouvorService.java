package com.rooban.praisehub.service;


import com.rooban.praisehub.dto.LouvorRequest;
import com.rooban.praisehub.dto.LouvorUpdateRequest;
import com.rooban.praisehub.exception.LouvorNotFoundException;
import com.rooban.praisehub.model.Louvor;
import com.rooban.praisehub.repository.LouvorRepository;
import com.rooban.praisehub.util.LouvorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LouvorService {

    private final LouvorRepository repository;
    private final LouvorMapper mapper;

    public LouvorService(LouvorRepository repository, LouvorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public Louvor criar(LouvorRequest dto) {
        Louvor l = mapper.toEntity(dto);
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

    @Transactional
    public Louvor atualizar(Long id, LouvorUpdateRequest dto) {
        Louvor l = buscarPorId(id);
        mapper.updateEntity(dto, l);
        return repository.save(l);
    }

    @Transactional
    public void deletar(Long id) {
        Louvor l = buscarPorId(id);
        repository.delete(l);
    }
}
