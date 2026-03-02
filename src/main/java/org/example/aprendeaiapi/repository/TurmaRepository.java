package org.example.aprendeaiapi.repository;


import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
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
    @Query(value = """
            SELECT DISTINCT t.anoEscolar from Turma t where CAST(t.anoEscolar AS string) LIKE %:serie%
    """)
    List<String> buscarSerie(@Param("serie") String serie);
    @Query(value = """
        SELECT\s
            u.id,
            u.nomeCompleto,
            u.matricula,
            u.email
        FROM Usuario u
        JOIN UsuarioTurma ut\s
            ON ut.id = u.id
        WHERE ut.turma = :idTurma
        AND u.tipoUsuario = 'ALUNO'
        ORDER BY u.nomeCompleto
       """)
    List<UsuarioResposeDTO> buscarAluno(@Param("idTurma") Long idTurma);

    @Query(value = """
        SELECT
           pd.id_professor,
           pd.id_disciplina,
           t.id AS turma_id,
           ut.id_usuario
        FROM professor_disciplina pd
        JOIN turma t ON t.id_disciplina = pd.id_disciplina
        JOIN usuario_turma ut ON ut.id_turma = t.id
        WHERE pd.id_professor = :idProfessor;
    """, nativeQuery = true)
    List<UsuarioResposeDTO> buscarAlunosPorProfessor(
            @Param("idProfessor") Long idProfessor);
}
