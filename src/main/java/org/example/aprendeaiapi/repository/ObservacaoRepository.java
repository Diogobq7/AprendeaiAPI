package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.model.Observacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservacaoRepository extends JpaRepository<Observacao, Long> {

    List<Observacao> findByIdProfessorId(Long idProfessor);

    List<Observacao> findByIdAluno(Long idAluno);

}
