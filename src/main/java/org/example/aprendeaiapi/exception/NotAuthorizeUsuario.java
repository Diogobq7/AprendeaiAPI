package org.example.aprendeaiapi.exception;

public class NotAuthorizeUsuario extends RuntimeException {
    public NotAuthorizeUsuario(String message) {
        super(message);
    }
}