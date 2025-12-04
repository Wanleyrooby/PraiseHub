package com.rooban.praisehub.controller;

import com.rooban.praisehub.dto.LouvorRequest;
import com.rooban.praisehub.dto.LouvorResponse;
import com.rooban.praisehub.dto.LouvorUpdateRequest;
import com.rooban.praisehub.model.Louvor;
import com.rooban.praisehub.service.LouvorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/louvores")
public class LouvorController {

    @Autowired
    private LouvorService service;

    @PostMapping
    public ResponseEntity<LouvorResponse> criar(@RequestBody @Valid LouvorRequest request) {
        Louvor l = service.criar(request);

        URI location = URI.create("/louvores/" + l.getId());

        return ResponseEntity.created(location).body(new LouvorResponse(l));
    }

    @GetMapping
    public List<LouvorResponse> listarTodos() {
        return service.listarTodos().stream()
                .map(LouvorResponse::new)
                .toList();
    }

    @GetMapping("/{id}")
    public LouvorResponse buscarPorId(@PathVariable Long id) {
        return new LouvorResponse(service.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public List<LouvorResponse> buscarPorTitulo(@RequestParam String titulo) {
        return service.buscarPorTitulo(titulo).stream()
                .map(LouvorResponse::new)
                .toList();
    }

    @GetMapping("/tag/{tag}")
    public List<LouvorResponse> buscarPorTag(@PathVariable String tag) {
        return service.buscarPorTag(tag).stream()
                .map(LouvorResponse::new)
                .toList();
    }

    @PutMapping("/{id}")
    public LouvorResponse atualizar(@PathVariable Long id, @RequestBody LouvorUpdateRequest dto) {
        return new LouvorResponse(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}