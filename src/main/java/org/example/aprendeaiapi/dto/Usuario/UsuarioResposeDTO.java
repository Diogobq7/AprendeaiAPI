package org.example.aprendeaiapi.dto.Usuario;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.TipoUsuario;

public class UsuarioResposeDTO {
    private String matricula;
    private String nomeCompleto;
    private String email;
    private String senha;
    @JoinColumn(name = "tipo_usuario_enum")
    private TipoUsuario tipoUsuario;

    public UsuarioResposeDTO(String cpf, String email, String matricula, String nomeCompleto, String senha, TipoUsuario tipoUsuario) {
        this.email = email;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
