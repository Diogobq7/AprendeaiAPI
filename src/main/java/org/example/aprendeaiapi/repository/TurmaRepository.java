package org.example.aprendeaiapi.repository;


import org.example.aprendeaiapi.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query("""
       SELECT t FROM Turma t
       JOIN t.disciplina d
       WHERE 
           CAST(t.anoEscolar AS string) LIKE %:busca%
           OR LOWER(d.nomeDisciplina) LIKE LOWER(CONCAT('%', :busca, '%'))
       """)
    List<Turma> buscarPorPalavra(@Param("busca") String busca);
}
