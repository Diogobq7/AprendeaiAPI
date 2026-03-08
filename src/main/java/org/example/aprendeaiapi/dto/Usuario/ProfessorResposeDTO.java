package org.example.aprendeaiapi.dto.Usuario;

public class ProfessorResposeDTO {
    private String matricula;
    private String nomeCompleto;
    private String nomeDisciplina;
    private String email;
    private String anoEscolar;

    public ProfessorResposeDTO(String anoEscolar, String email, String matricula, String nomeCompleto, String nomeDisciplina) {
        this.anoEscolar = anoEscolar;
        this.email = email;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.nomeDisciplina = nomeDisciplina;
    }

    //get and Setter

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}
