package org.example.aprendeaiapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "id_disciplina")
    @ManyToOne
    private Disciplina disciplina;
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "ano_escolar")
    private AnoEscolar anoEscolar;

    public Turma(AnoEscolar anoEscolar, Disciplina disciplina) {
        this.anoEscolar = anoEscolar;
        this.disciplina = disciplina;
    }
    public Turma() {}

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

    public long getId() {
        return id;
    }

}
