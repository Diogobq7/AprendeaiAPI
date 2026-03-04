package org.example.aprendeaiapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_turma")
public class UsuarioTurma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "id_turma")
    @ManyToOne
    private Turma turma;

    public UsuarioTurma( Turma turma, Usuario usuario) {
        this.turma = turma;
        this.usuario = usuario;
    }

    public UsuarioTurma() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
