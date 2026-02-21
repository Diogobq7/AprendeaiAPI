package org.example.aprendeaiapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplinas")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome_disciplina")
    private String nomeDisciplina;

    public Disciplina( String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Disciplina() {
    }
    // set and get
    public long getId() {
        return id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}
