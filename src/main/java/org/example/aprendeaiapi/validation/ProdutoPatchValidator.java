package org.example.aprendeaiapi.validation;

import org.example.aprendeaiapi.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProdutoPatchValidator {
    public void validate(Map<String, Object> json) {
        Map<String, String> errors = new HashMap<>();

        if (json.containsKey("nome")) {
            if (json.get("nome").toString().trim().isEmpty()) {
                errors.put("nome", "O nome não pode ser vazio.");
            }
            else if (json.get("nome").toString().trim().length() < 2) {
                errors.put("nome", "O nome deve ter dois ou mais caracteres.");
            }
        }

        if (json.containsKey("descricao")) {
            if (json.get("descricao").toString().trim().isEmpty())
                errors.put("descricao", "A descrição não pode ser vazia.");
        }


        if (json.containsKey("preco")) {
            if (json.get("preco").toString().trim().isEmpty())
                errors.put("preco", "O preço não pode ser vazio.");

            if (Double.parseDouble(json.get("preco").toString()) <= 0) {
                errors.put("preco", "O preço deve deve ser maior que zero.");
            }
        }

        if (json.containsKey("quantidadeEstoque")) {
            if (json.get("quantidadeEstoque").toString().trim().isEmpty())
                errors.put("quantidadeEstoque", "A quantidade em estoque não pode ser vazia.");

            if (Double.parseDouble(json.get("quantidadeEstoque").toString()) <= 0) {
                errors.put("preco", "A quatidade em estoque deve deve ser maior ou igual a zero.");
            }
        }

        if (!errors.isEmpty())
            throw new ValidationException(errors);
    }
}
