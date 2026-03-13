package org.example.aprendeaiapi.dto.turma;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.AnoEscolar;

public class UpdateTurmaResquestDTO {
    private Long turmaId;
    @JoinColumn(name = "ano_escolar_enum")
    private AnoEscolar anoEscolar;
    private Character turma;

    public UpdateTurmaResquestDTO(AnoEscolar anoEscolar, Long turmaId, Character turma) {
        this.anoEscolar = anoEscolar;
        this.turmaId = turmaId;
        this.turma = turma;
    }

    public Long getTurmaId() {
        return turmaId;
    }
    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
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
