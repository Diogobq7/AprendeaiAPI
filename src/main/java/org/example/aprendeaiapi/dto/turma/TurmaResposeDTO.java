package org.example.aprendeaiapi.dto.turma;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.AnoEscolar;
import org.example.aprendeaiapi.model.Disciplina;


public class TurmaResposeDTO {
    private Long id;
    private Character turma;
    private AnoEscolar anoEscolar;

    public TurmaResposeDTO(Long id, AnoEscolar anoEscolar, Character turma) {
        this.id = id;
        this.anoEscolar = anoEscolar;
        this.turma = turma;
    }


    //get and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnoEscolar getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(AnoEscolar anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public Character getTurma() {
        return turma;
    }

    public void setTurma(Character turma) {
        this.turma = turma;
    }
}
