package org.example.aprendeaiapi.dto.nota;

public class NotaResposeDTO {
    private String nomeAluno;
    private String nomeDisciplina;
    private Double nota;

   //construtor

    public NotaResposeDTO(String nomeAluno, String nomeDisciplina, Double nota) {
        this.nomeAluno = nomeAluno;
        this.nomeDisciplina = nomeDisciplina;
        this.nota = nota;
    }

    public NotaResposeDTO() {
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
