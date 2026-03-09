package org.example.aprendeaiapi.dto.Usuario;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.aprendeaiapi.model.TipoUsuario;
import org.example.aprendeaiapi.validation.OnCreate;

public class InsertUsuarioRequestDTO {
    @NotNull(message = "O matricula não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "O matricula deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O matricula não pode ser em branco", groups = OnCreate.class)
    private String matricula;
    @NotNull(message = "O nome não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "O nome deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O nome não pode ser em branco", groups = OnCreate.class)
    private String nomeCompleto;
    @NotNull(message = "O cpf não pode ser nulo", groups = OnCreate.class)
    @Size(min =11,max = 14, message = "O cpf deve ter no mínimo 11 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O cpf não pode ser em branco", groups = OnCreate.class)
    private String cpf;
    @NotNull(message = "O email não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "O email deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O email não pode ser em branco", groups = OnCreate.class)
    private String email;
    private TipoUsuario tipoUsuario;
    private String responsavel;
    private String  telefoneResponsavel;
    private Long idTurma;

    //set e get
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public Long getIdTurma() {
        return idTurma;
    }
    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }
}
