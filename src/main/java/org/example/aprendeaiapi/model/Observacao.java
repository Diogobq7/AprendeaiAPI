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
    private Usuario aluno;
    @JoinColumn(name = "id_professor")
    @ManyToOne
    private Usuario professor;
    private String observacao;
    private LocalDate data_registro;

    //construtor

    public Observacao(LocalDate data_registro,  Usuario aluno, Usuario professor, String observacao) {
        this.data_registro = data_registro;
        this.aluno = aluno;
        this.professor = professor;
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

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
