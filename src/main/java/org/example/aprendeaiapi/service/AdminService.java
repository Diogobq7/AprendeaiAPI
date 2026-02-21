package org.example.aprendeaiapi.service;

import jakarta.persistence.JoinColumn;
import jakarta.transaction.Transactional;
import org.example.aprendeaiapi.dto.Usuario.UsuarioRequestDTO;
import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.dto.disciplina.DisciplinaResposeDTO;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.dto.turma.TurmaRequestDTO;
import org.example.aprendeaiapi.dto.turma.TurmaResposeDTO;
import org.example.aprendeaiapi.model.*;
import org.example.aprendeaiapi.repository.DisciplinaRepository;
import org.example.aprendeaiapi.repository.TurmaRepository;
import org.example.aprendeaiapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    final UsuarioRepository usuarioRepository;
    final TurmaRepository turmaRepository;
    final DisciplinaRepository disciplinaRepository;

    public AdminService(UsuarioRepository usuarioRepository, TurmaRepository turmaRepository, DisciplinaRepository disciplinaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.turmaRepository = turmaRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    @Transactional
    public MessageResponseDTO adicionarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario(
                usuarioRequestDTO.getCpf(),
                usuarioRequestDTO.getEmail(),
                usuarioRequestDTO.getMatricula(),
                usuarioRequestDTO.getNomeCompleto(),
                "123",
                usuarioRequestDTO.getTipoUsuario(),
                usuarioRequestDTO.getResponsavel(),
                usuarioRequestDTO.getTelefoneResponsavel()
        );
        usuarioRepository.save(usuario);
        return new MessageResponseDTO(usuarioRequestDTO.getTipoUsuario() + " inserido com sucesso!");
    }

    public List<UsuarioResposeDTO> getUsuarios(TipoUsuario tipoUsuario) {
        List<UsuarioResposeDTO> usuarios = usuarioRepository.findByTipoUsuario(tipoUsuario);
        return usuarios;
    }

    public List<TurmaResposeDTO> getTurmas(){

        List<Turma> turmas = turmaRepository.findAll();

        return turmas.stream()
                .map(turma -> new TurmaResposeDTO(
                        turma.getAnoEscolar(),
                        turma.getDisciplina()
                ))
                .toList();
    }

    public MessageResponseDTO adicionarTurma(TurmaRequestDTO turmaRequestDTO) {
        Turma turma = new Turma(
                turmaRequestDTO.getAnoEscolar(),
                turmaRequestDTO.getDisciplina()
        );
        turmaRepository.save(turma);
        return new MessageResponseDTO("Turma inserida com sucesso!");
    }

    public  List<TurmaResposeDTO> getTurmas(String palavra){
        List<Turma> turmas = turmaRepository.buscarPorPalavra(palavra);

        return turmas.stream()
                .map(turma -> new TurmaResposeDTO(
                        turma.getAnoEscolar(),
                        turma.getDisciplina()
                ))
                .toList();
    }

    public MessageResponseDTO adicionarDisciplina(String diciplina){
        Disciplina disciplina = new Disciplina(diciplina);
        disciplinaRepository.save(disciplina);
        return new MessageResponseDTO("Disciplina inserida com sucesso!");
    }

    public List<DisciplinaResposeDTO> getDisciplinas(){
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        return disciplinas.stream()
                .map(disciplina -> new DisciplinaResposeDTO(
                        disciplina.getId(),
                        disciplina.getNomeDisciplina()
                ))
                .toList();
    }
}
