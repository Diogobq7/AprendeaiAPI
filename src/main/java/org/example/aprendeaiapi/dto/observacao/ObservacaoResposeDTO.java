package org.example.aprendeaiapi.dto.observacao;

import org.example.aprendeaiapi.model.Observacao;

import java.time.LocalDate;

public class ObservacaoResposeDTO {
    private Long id;
    private LocalDate dataRegistro;
    private String nomeAluno;
    private String nomeProfessor;
    private String observacao;

    public ObservacaoResposeDTO(Observacao observacao) {
        this.id = observacao.getId();
        this.observacao = observacao.getObservacao();
        this.dataRegistro = observacao.getData_registro();
        this.nomeProfessor = observacao.getIdProfessor().getNomeCompleto();
        this.nomeAluno = observacao.getIdAluno().getNomeCompleto();
    }

    public ObservacaoResposeDTO(Long nomeAluno, Long nomeProfessor, String observacao) {
        this.nomeAluno = nomeAluno;
        this.nomeProfessor = nomeProfessor;
        this.observacao = observacao;
    }

    //get and setter


    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
