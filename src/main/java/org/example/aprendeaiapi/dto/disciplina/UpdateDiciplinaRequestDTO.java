package org.example.aprendeaiapi.dto.disciplina;

public class UpdateDiciplinaRequestDTO {

    private long id;
    private String nomeDisciplina;

    public UpdateDiciplinaRequestDTO(long id, String nomeDisciplina) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
    }

    //get and setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}
