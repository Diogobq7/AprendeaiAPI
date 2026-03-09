package org.example.aprendeaiapi.dto.turma;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.AnoEscolar;
import org.example.aprendeaiapi.model.Disciplina;


public class TurmaResposeDTO {
    private long id;
    private Character turma;
    @JoinColumn(name = "ano_escolar_enum")
    private AnoEscolar anoEscolar;

    public TurmaResposeDTO(long id,AnoEscolar anoEscolar, Character turma) {
        this.id = id;
        this.anoEscolar = anoEscolar;
        this.turma = turma;
    }

    //get and setter

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
