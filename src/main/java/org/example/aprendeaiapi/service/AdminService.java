package org.example.aprendeaiapi.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.aprendeaiapi.dto.Usuario.UpdateUsuarioRequestDTO;
import jakarta.persistence.JoinColumn;
import jakarta.transaction.Transactional;
import org.example.aprendeaiapi.dto.Usuario.InsertUsuarioRequestDTO;
import org.example.aprendeaiapi.dto.Usuario.UsuarioRequestDTO;
import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.dto.disciplina.DisciplinaResposeDTO;
import org.example.aprendeaiapi.dto.disciplina.UpdateDiciplinaRequestDTO;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.dto.turma.TurmaRequestDTO;
import org.example.aprendeaiapi.dto.turma.TurmaResposeDTO;
import org.example.aprendeaiapi.dto.turma.UpdateTurmaResquestDTO;
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
    public MessageResponseDTO adicionarUsuario(InsertUsuarioRequestDTO usuarioRequestDTO) {
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
        turmaRepository.findById(usuarioRequestDTO.getIdTurma()).orElseThrow(() -> new EntityNotFoundException("Turma não encontrada"));
        usuarioRepository.insertUsuarioTurma(usuario.getId(), usuarioRequestDTO.getIdTurma());

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
                        turma.getId(),
                        turma.getAnoEscolar(),
                        turma.getTurma()
                ))
                .toList();
    }

    public MessageResponseDTO adicionarTurma(TurmaRequestDTO turmaRequestDTO) {
        Turma turma = new Turma(
                turmaRequestDTO.getAnoEscolar(),
                turmaRequestDTO.getTurma()
        );
        turmaRepository.save(turma);
        return new MessageResponseDTO("Turma inserida com sucesso!");
    }

    public MessageResponseDTO updateTurma(UpdateTurmaResquestDTO updateTurmaResquestDTO) {
        Turma turma = turmaRepository.findById(updateTurmaResquestDTO.getTurmaId()).orElseThrow(() -> new EntityNotFoundException("Turma não encontrado"));
        turma.setAnoEscolar(updateTurmaResquestDTO.getAnoEscolar());
        turma.setTurma(updateTurmaResquestDTO.getTurma());
        turmaRepository.save(turma);
        return new MessageResponseDTO("Turma atualizada com sucesso!");
    }

    public MessageResponseDTO updateUsuario(UpdateUsuarioRequestDTO updateUsuarioRequestDTO, String emailAtual) {
        Usuario usuario = usuarioRepository.findByEmail(emailAtual).orElseThrow(() -> new EntityNotFoundException("Nota não encontrado"));
        usuario.setEmail(updateUsuarioRequestDTO.getEmail());
        usuario.setNomeCompleto(updateUsuarioRequestDTO.getNomeCompleto());
        usuario.setResponsavel(updateUsuarioRequestDTO.getResponsavel());
        usuario.setTelefoneResponsavel(updateUsuarioRequestDTO.getTelefoneResponsavel());
        usuarioRepository.save(usuario);
        return new MessageResponseDTO("Usuario atualizado com sucesso!");
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

    public MessageResponseDTO updateDiciplina(UpdateDiciplinaRequestDTO diciplinaRequestDTO) {
        Disciplina disciplina = disciplinaRepository.findById(diciplinaRequestDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Nota não encontrado"));
        disciplina.setNomeDisciplina(diciplinaRequestDTO.getNomeDisciplina());
        disciplinaRepository.save(disciplina);
        return new MessageResponseDTO("Disciplina atulizada com sucesso!");
    }
}
