package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
import org.example.aprendeaiapi.model.Disciplina;
import org.example.aprendeaiapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    @Query(value = """
        SELECT pd.id_disciplina
        FROM professor_disciplina pd
        WHERE pd.id_professor = :idProfessor
    """, nativeQuery = true)
    Long getIdDisciplina(@Param("idProfessor") Long idProfessor);

    @Query("""
        SELECT d.nomeDisciplina FROM Disciplina d
""")
    Optional<Disciplina> getDisciplina(Long idDiciplina);

    @Query("SELECT n FROM Nota n WHERE n.aluno.id = :idAluno")
    List<Nota> getNotaByIdAluno(@Param("idAluno") Long idAluno);
}
