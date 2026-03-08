package org.example.aprendeaiapi.dto.turma;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.AnoEscolar;
import org.example.aprendeaiapi.model.Disciplina;

public class TurmaRequestDTO {
    private Character turma;
    @JoinColumn(name = "ano_escolar_enum")
    private AnoEscolar anoEscolar;

   //getter and setter

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
