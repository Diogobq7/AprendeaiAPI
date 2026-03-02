package org.example.aprendeaiapi.service;

import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
import org.example.aprendeaiapi.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<String> getTurmas(String serie){
        List<String> turmas = turmaRepository.buscarSerie(serie);
        return turmas;
    }

    public List<UsuarioResposeDTO> getAlunoByTurma(Long serie){
        List<UsuarioResposeDTO> turmas = turmaRepository.buscarAluno(serie);
        return turmas;
    }

    public List<UsuarioResposeDTO> geAlunosByProfessor(Long professorId) {
        List<UsuarioResposeDTO> turma = turmaRepository.buscarAlunosPorProfessor(professorId);
        return turma;
    }
}
