package org.example.aprendeaiapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Character turma;
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "ano_escolar")
    private AnoEscolar anoEscolar;

    public Turma(AnoEscolar anoEscolar, Character turma) {
        this.anoEscolar = anoEscolar;
        this.turma = turma;
    }
    public Turma() {}

    //get and setter

    public AnoEscolar getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(AnoEscolar anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Character getTurma() {
        return turma;
    }

    public void setTurma(Character turma) {
        this.turma = turma;
    }

    public long getId() {
        return id;
    }

}
