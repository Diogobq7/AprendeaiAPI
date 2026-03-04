package org.example.aprendeaiapi.dto.nota;

import jakarta.validation.constraints.*;
import org.example.aprendeaiapi.validation.OnCreate;

public class NotaRequestDTO {
    private Long idDisciplina;
    private Long idAluno;
    private Long idProfessor;
    @NotNull(message = "A n1 não pode ser nulo", groups = OnCreate.class)
    @Max(value = 10,message = "A nota so pode ir ate 10")
    @Min(value = 0, message = "O mínimo da nota é 0")
    private double n1;
    @NotNull(message = "A n2 não pode ser nulo", groups = OnCreate.class)
    @Max(value = 10,message = "A nota so pode ir ate 10")
    @Min(value = 0, message = "O mínimo da nota é 0")
    private double n2;

    //construtor
    public NotaRequestDTO(Long idAluno, Long idDisciplina, Long idProfessor, double n1, double n2) {
        this.idAluno = idAluno;
        this.idDisciplina = idDisciplina;
        this.idProfessor = idProfessor;
        this.n1 = n1;
        this.n2 = n2;
    }

    //get and setter
    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public double getN1() {
        return n1;
    }

    public void setNota(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }
}
