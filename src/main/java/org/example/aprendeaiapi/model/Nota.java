package org.example.aprendeaiapi.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

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
    private Double nota;
    private Timestamp data_registro;

    //contrustor
    public Nota(Timestamp data_registro, Disciplina disciplina, Usuario idAluno, Usuario idProfessor, Double nota) {
        this.data_registro = data_registro;
        this.disciplina = disciplina;
        this.idAluno = idAluno;
        this.idProfessor = idProfessor;
        this.nota = nota;
    }

    public Nota() {}

    //getter and setter

    public Timestamp getData_registro() {
        return data_registro;
    }

    public void setData_registro(Timestamp data_registro) {
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
