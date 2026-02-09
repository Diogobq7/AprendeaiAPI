package org.example.aprendeaiapi.dto.Usuario;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.TipoUsuario;

public class LoginUsuarioRespose {
    private long id;
    private String matricula;
    private String email;
    @JoinColumn(name = "tipo_usuario_enum")
    private TipoUsuario tipoUsuario;

    public LoginUsuarioRespose(String email, long id, String matricula, TipoUsuario tipoUsuario) {
        this.email = email;
        this.id = id;
        this.matricula = matricula;
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
