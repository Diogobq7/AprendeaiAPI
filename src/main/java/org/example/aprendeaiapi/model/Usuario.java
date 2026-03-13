package org.example.aprendeaiapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String matricula;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private TipoUsuario tipoUsuario;
    private String responsavel;
    @Column(name = "telefone_responsavel")
    private String  telefoneResponsavel;
    private Character status;

    public Usuario(String cpf, String email, String matricula, String nomeCompleto, String senha, TipoUsuario tipoUsuario, String responsavel, String telefoneResponsavel, Character status) {
        this.cpf = cpf;
        this.email = email;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.responsavel = responsavel;
        this.telefoneResponsavel = telefoneResponsavel;
        this.status = status;
    }

    public Usuario() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
