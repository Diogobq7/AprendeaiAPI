package org.example.aprendeaiapi.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "observacoes")
public class Observacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_aluno")
    @ManyToOne
    private Usuario idAluno;
    @JoinColumn(name = "id_professor")
    @ManyToOne
    private Usuario idProfessor;
    private String observacao;
    private LocalDate data_registro;

    //construtor

    public Observacao(LocalDate data_registro,  Usuario idAluno, Usuario idProfessor, String observacao) {
        this.data_registro = data_registro;
        this.idAluno = idAluno;
        this.idProfessor = idProfessor;
        this.observacao = observacao;
    }

    public Observacao() {

    }

    //get and setter

    public LocalDate getData_registro() {
        return data_registro;
    }

    public void setData_registro(LocalDate data_registro) {
        this.data_registro = data_registro;
    }

    public Long getId() {
        return id;
    }

    public Usuario getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Usuario idAluno) {
        this.idAluno = idAluno;
    }

    public Usuario getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Usuario idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
