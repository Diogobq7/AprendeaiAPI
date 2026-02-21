package org.example.aprendeaiapi.dto.Usuario;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.TipoUsuario;

public class LoginUsuarioResposeDTO {
    private long id;
    private String matricula;
    private String email;
    @JoinColumn(name = "tipo_usuario_enum")
    private TipoUsuario tipoUsuario;
    private Boolean primeiroLogin;

    public LoginUsuarioResposeDTO( long id, String matricula,String email, TipoUsuario tipoUsuario,Boolean primeiroLogin) {
        this.id = id;
        this.matricula = matricula;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.primeiroLogin = primeiroLogin;
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

    public Boolean getPrimeiroLogin() {
        return primeiroLogin;
    }

    public void setPrimeiroLogin(Boolean primeiroLogin) {
        this.primeiroLogin = primeiroLogin;
    }
}
