package com.rooban.praisehub.exception;

public class LouvorNotFoundException extends RuntimeException {

    public LouvorNotFoundException(Long id) {
        super("Louvor com ID " + id + " não encontrado.");
    }

    public LouvorNotFoundException(String message) {
        super(message);
    }
}
