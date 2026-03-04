package org.example.aprendeaiapi.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_disciplina")
    @ManyToOne
    private Disciplina disciplina;
    @JoinColumn(name = "id_aluno")
    @ManyToOne
    private Usuario idAluno;
    @JoinColumn(name = "id_professor")
    @ManyToOne
    private Usuario idProfessor;
    private Double n1;
    private Double n2;
    private Double media;
    private LocalDate data_registro;

    //contrustor
    public Nota(LocalDate data_registro, Disciplina disciplina, Usuario idAluno, Usuario idProfessor, Double n1, Double n2, Double media) {
        this.data_registro = data_registro;
        this.disciplina = disciplina;
        this.idAluno = idAluno;
        this.idProfessor = idProfessor;
        this.n1 = n1;
        this.n2 = n2;
        this.media = media;
    }

    public Nota() {}

    //getter and setter

    public LocalDate getData_registro() {
        return data_registro;
    }

    public void setData_registro(LocalDate data_registro) {
        this.data_registro = data_registro;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }
}
