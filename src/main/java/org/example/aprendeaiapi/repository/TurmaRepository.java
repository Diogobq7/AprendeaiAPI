package org.example.aprendeaiapi.repository;


import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
import org.example.aprendeaiapi.dto.turma.AlunoTurmaNotaDTO;
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
    @Query("""
       SELECT new org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO(
            u.cpf,
            u.email,
            u.matricula,
            u.nomeCompleto,
            u.senha,
            u.tipoUsuario
       )
       FROM Usuario u
       JOIN UsuarioTurma ut
            ON ut.usuario.id = u.id
       WHERE ut.turma.id = :idTurma
       AND u.tipoUsuario = 'ALUNO'
       ORDER BY u.nomeCompleto
       """)
    List<UsuarioResposeDTO> buscarAluno(@Param("idTurma") Long idTurma);

    @Query(value = """
    SELECT 
        u.id::bigint,
        u.nome_completo,
        u.matricula,
        t.id::bigint,
        n.n1,
        n.n2,
        n.media
    FROM professor_disciplina pd
    JOIN turma t ON t.id_disciplina = pd.id_disciplina
    JOIN usuario_turma ut ON ut.id_turma = t.id
    JOIN usuario u ON u.id = ut.id_usuario
    LEFT JOIN notas n 
        ON n.id_aluno = u.id
        AND n.id_disciplina = pd.id_disciplina
    WHERE pd.id_professor = :idProfessor
""", nativeQuery = true)
    List<AlunoTurmaNotaDTO> buscarAlunosPorProfessor(
            @Param("idProfessor") Long idProfessor);
}
