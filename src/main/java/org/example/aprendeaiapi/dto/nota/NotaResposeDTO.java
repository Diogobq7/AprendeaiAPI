package org.example.aprendeaiapi.dto.nota;

import java.time.LocalDate;

public class NotaResposeDTO {
    private String nomeAluno;
    private String nomeDisciplina;
    private Double n1;
    private Double n2;
    private Double media;
    private String nomeDiciplina;
    private LocalDate dataRegistro;

   //construtor
    public NotaResposeDTO(String nomeAluno, String nomeDisciplina, Double n1, Double n2, Double media, LocalDate dataRegistro, String nomeDiciplina1, LocalDate dataRegistro1) {
        this.nomeAluno = nomeAluno;
        this.nomeDisciplina = nomeDisciplina;
        this.n1 = n1;
        this.n2 = n2;
        this.media = media;
        this.nomeDiciplina = nomeDiciplina1;
        this.dataRegistro = dataRegistro1;
    }

    //get and setter

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getNomeDiciplina() {
        return nomeDiciplina;
    }

    public void setNomeDiciplina(String nomeDiciplina) {
        this.nomeDiciplina = nomeDiciplina;
    }
}
