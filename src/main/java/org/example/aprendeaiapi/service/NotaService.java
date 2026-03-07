package org.example.aprendeaiapi.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.dto.nota.NotaRequestDTO;
import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
import org.example.aprendeaiapi.model.Disciplina;
import org.example.aprendeaiapi.model.Nota;
import org.example.aprendeaiapi.model.Usuario;
import org.example.aprendeaiapi.repository.DisciplinaRepository;
import org.example.aprendeaiapi.repository.NotaRepository;
import org.example.aprendeaiapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    private NotaRepository notaRepository;
    private UsuarioRepository usuarioRepository;
    private DisciplinaRepository disciplinaRepository;
    public NotaService(NotaRepository notaRepository, UsuarioRepository usuarioRepository, DisciplinaRepository disciplinaRepository) {
        this.notaRepository = notaRepository;
        this.usuarioRepository = usuarioRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public MessageResponseDTO addNota(NotaRequestDTO notaRequestDTO) {
        Usuario aluno = usuarioRepository.findById(notaRequestDTO.getIdAluno()).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        Usuario professor = usuarioRepository.findById(notaRequestDTO.getIdProfessor()).orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(notaRequestDTO.getIdDisciplina())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada"));

        double media = (notaRequestDTO.getN1()+notaRequestDTO.getN2())/2;

        Nota nota = new Nota(
                LocalDate.now(),
                disciplina,
                aluno,
                professor,
                notaRequestDTO.getN1(),
                notaRequestDTO.getN2(),
                media
        );

        notaRepository.save(nota);

        return new MessageResponseDTO("Nota cadastrada com sucesso");
    }

    public MessageResponseDTO updateNota(NotaRequestDTO notaRequestDTO, Long notaId) {
        Nota notaExistente = notaRepository.findById(notaId).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        notaExistente.setN1(notaRequestDTO.getN1());
        notaExistente.setN2(notaRequestDTO.getN2());
        double media = (notaRequestDTO.getN1()+notaRequestDTO.getN2())/2;
        notaExistente.setMedia(media);
        notaRepository.save(notaExistente);
        return new MessageResponseDTO("Nota atualizada com sucesso");
    }

    public List<NotaResposeDTO> getAlunoNota(Long idAluno) {
        List<NotaResposeDTO> notas = notaRepository.getNotaByIdAluno(idAluno);
        return notas;
    }

}
