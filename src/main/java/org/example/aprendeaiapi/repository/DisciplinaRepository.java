package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.model.Disciplina;
import org.example.aprendeaiapi.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
