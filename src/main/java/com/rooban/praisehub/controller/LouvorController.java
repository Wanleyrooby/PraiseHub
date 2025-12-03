package com.rooban.praisehub.controller;

import com.rooban.praisehub.dto.LouvorRequest;
import com.rooban.praisehub.dto.LouvorResponse;
import com.rooban.praisehub.model.Louvor;
import com.rooban.praisehub.service.LouvorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/louvores")
public class LouvorController {

    @Autowired
    private LouvorService service;

    @PostMapping
    public ResponseEntity<LouvorResponse> criar(@RequestBody @Valid LouvorRequest request) {
        Louvor l = service.criar(request);
        return ResponseEntity.ok(new LouvorResponse(l));
    }
}