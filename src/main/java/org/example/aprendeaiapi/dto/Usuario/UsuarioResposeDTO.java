package org.example.aprendeaiapi.dto.Usuario;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.TipoUsuario;

public class UsuarioResposeDTO {
    private String matricula;
    private String nomeCompleto;
    private String cpf;
    private String email;

    public UsuarioResposeDTO(String cpf, String email, String matricula, String nomeCompleto) {
        this.email = email;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
