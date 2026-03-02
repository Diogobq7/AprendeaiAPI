package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
import org.example.aprendeaiapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
