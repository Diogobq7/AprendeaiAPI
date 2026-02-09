package org.example.aprendeaiapi.dto.Usuario;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.aprendeaiapi.validation.OnCreate;

public class UsuarioRequestDTO {
    @NotNull(message = "A matricula não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "A matricula  deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "A matricula  não pode ser em branco", groups = OnCreate.class)
    private String matricula;

    @NotNull(message = "O email não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "O email deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "O email não pode ser em branco", groups = OnCreate.class)
    private String email;

    @NotNull(message = "A senha não pode ser nulo", groups = OnCreate.class)
    @Size(min = 5, message = "O email deve ter no mínimo 5 caracteres", groups = OnCreate.class)
    @NotBlank(message = "A senha não pode ser em branco", groups = OnCreate.class)
    private String senha;

    //set e get
    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
