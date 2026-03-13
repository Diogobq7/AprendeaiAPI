package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.model.UsuarioTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioTurmaRespository extends JpaRepository<UsuarioTurma, Long> {
    @Modifying
    @Query("""
    DELETE FROM UsuarioTurma ut 
    WHERE ut.turma.id = :idTurma
""")
    void deleteByIdTurma(@Param("idTurma") Long idTurma);
}
