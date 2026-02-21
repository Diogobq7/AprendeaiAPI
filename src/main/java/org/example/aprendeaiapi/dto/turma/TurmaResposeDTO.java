package org.example.aprendeaiapi.dto.turma;

import jakarta.persistence.JoinColumn;
import org.example.aprendeaiapi.model.AnoEscolar;
import org.example.aprendeaiapi.model.Disciplina;


public class TurmaResposeDTO {
    private Disciplina disciplina;
    @JoinColumn(name = "ano_escolar_enum")
    private AnoEscolar anoEscolar;

    public TurmaResposeDTO(AnoEscolar anoEscolar, Disciplina disciplina) {
        this.anoEscolar = anoEscolar;
        this.disciplina = disciplina;
    }

    //get and setter

    public AnoEscolar getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(AnoEscolar anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
