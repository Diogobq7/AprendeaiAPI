package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.model.TipoUsuario;
import org.example.aprendeaiapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    @Modifying
    @Query("UPDATE Usuario u SET u.senha = :senha WHERE u.email = :email")
    void updateSenha(@Param("email") String email,
                     @Param("senha") String senha);
    List<UsuarioResposeDTO> findByTipoUsuario(TipoUsuario tipoUsuario);


}
