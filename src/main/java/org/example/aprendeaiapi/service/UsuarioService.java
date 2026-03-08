package org.example.aprendeaiapi.service;

import jakarta.transaction.Transactional;
import org.example.aprendeaiapi.dto.Usuario.*;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.exception.NotAuthorizeUsuario;
import org.example.aprendeaiapi.model.Usuario;
import org.example.aprendeaiapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public LoginUsuarioResposeDTO login(LoginUsuarioRequestDTO loginUsuarioRequestDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginUsuarioRequestDTO.getEmail().toLowerCase())
                .orElseThrow(() -> new NotAuthorizeUsuario(
                                "Verifique suas credenciais e tente novamente."));

        boolean comparePassword = usuario.getSenha().equals(loginUsuarioRequestDTO.getSenha());

        if (!comparePassword) {
            throw new NotAuthorizeUsuario(
                    "Verifique suas credenciais e tente novamente.");
        }

        return new LoginUsuarioResposeDTO(
                usuario.getId(),
                usuario.getMatricula(),
                usuario.getEmail(),
                usuario.getTipoUsuario(),
                usuario.getSenha().equals("123")
        );

    }

    @Transactional
    public MessageResponseDTO trocaSenha(SenhaUpadateRequestDTO senhaUpadateRequestDTO) {
        Usuario usuario = usuarioRepository.findByEmail(senhaUpadateRequestDTO.getEmail().toLowerCase())
                .orElseThrow(() -> new NotAuthorizeUsuario(
                        "Verifique suas credenciais e tente novamente."));

        boolean comparePassword = usuario.getSenha().equals(senhaUpadateRequestDTO.getSenha());

        if (!comparePassword) {
            throw new NotAuthorizeUsuario(
                    "Verifique suas credenciais e tente novamente.");
        }

        usuarioRepository.updateSenha(senhaUpadateRequestDTO.getEmail(), senhaUpadateRequestDTO.getSenhaNova());

        return new MessageResponseDTO("Senha atualizada com sucesso!");
    }

    public List<AlunoResposeDTO> listarAlunos() {
        List<AlunoResposeDTO> alunos = usuarioRepository.findAllAluno();
        return alunos;
    }

    public List<ProfessorResposeDTO> listarProfessores() {
        List<ProfessorResposeDTO> professores = usuarioRepository.findAllProfessor();
        return professores;
    }
}
