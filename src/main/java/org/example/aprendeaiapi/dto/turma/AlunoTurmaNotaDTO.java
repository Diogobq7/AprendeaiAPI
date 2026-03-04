package org.example.aprendeaiapi.dto.turma;

import java.math.BigDecimal;

public class AlunoTurmaNotaDTO {

    private Long idAluno;
    private String nomeCompleto;
    private String matricula;
    private Long idTurma;
    private BigDecimal n1;
    private BigDecimal n2;
    private BigDecimal media;

    public AlunoTurmaNotaDTO(Long idAluno,
                             String nomeCompleto,
                             String matricula,
                             Long idTurma,
                             BigDecimal n1,
                             BigDecimal n2,
                             BigDecimal media) {
        this.idAluno = idAluno;
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.idTurma = idTurma;
        this.n1 = n1;
        this.n2 = n2;
        this.media = media;
    }

    //get and  setter

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public BigDecimal getMedia() {
        return media;
    }

    public void setMedia(BigDecimal media) {
        this.media = media;
    }

    public BigDecimal getN1() {
        return n1;
    }

    public void setN1(BigDecimal n1) {
        this.n1 = n1;
    }

    public BigDecimal getN2() {
        return n2;
    }

    public void setN2(BigDecimal n2) {
        this.n2 = n2;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}
