package org.example.aprendeaiapi.dto.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.aprendeaiapi.validation.OnCreate;

public class UpdateUsuarioRequestDTO {
    @NotNull(message = "O nome não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "O nome deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O nome não pode ser em branco", groups = OnCreate.class)
    private String nomeCompleto;
    @NotNull(message = "O email não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "O email deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O email não pode ser em branco", groups = OnCreate.class)
    private String email;
    @NotNull(message = "O nome do responsavel não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "O nome do responsavel deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O nome do responsavel não pode ser em branco", groups = OnCreate.class)
    private String responsavel;
    @NotNull(message = "O telefone do responsavel não pode ser nulo", groups = OnCreate.class)
    @Size(min =8,max = 13, message = "O telefone do responsavel deve ter no mínimo 8 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O telefone do responsavel não pode ser em branco", groups = OnCreate.class)
    private String  telefoneResponsavel;

    public UpdateUsuarioRequestDTO(String email, String nomeCompleto, String responsavel, String telefoneResponsavel) {
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.responsavel = responsavel;
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto( String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel( String responsavel) {
        this.responsavel = responsavel;
    }

    public  String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel( String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }
}
