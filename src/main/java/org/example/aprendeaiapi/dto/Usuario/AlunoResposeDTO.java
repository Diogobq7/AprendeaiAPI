package org.example.aprendeaiapi.dto.Usuario;

import org.example.aprendeaiapi.model.TipoUsuario;

public class AlunoResposeDTO {
    private String matricula;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String anoEscolar;

    public AlunoResposeDTO(String matricula, String nomeCompleto, String cpf, String email, String anoEscolar) {
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.anoEscolar = anoEscolar;
    }

    //get setter

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
