package org.example.aprendeaiapi.exception;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class BeanValidationException extends RuntimeException {
    private final Set<ConstraintViolation<?>> violations;

    public BeanValidationException(Set<ConstraintViolation<?>> violations) {
        super("Erro de validação");
        this.violations = violations;
    }

    public Set<ConstraintViolation<?>> getViolations() {
      return violations;
    }
}
