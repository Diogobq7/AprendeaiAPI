package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
