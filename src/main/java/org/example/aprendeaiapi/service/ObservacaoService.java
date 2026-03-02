package org.example.aprendeaiapi.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
import org.example.aprendeaiapi.dto.observacao.ObservacaoResposeDTO;
import org.example.aprendeaiapi.dto.observacao.ObservacaoResquestDTO;
import org.example.aprendeaiapi.model.Observacao;
import org.example.aprendeaiapi.model.Usuario;
import org.example.aprendeaiapi.repository.ObservacaoRepository;
import org.example.aprendeaiapi.repository.TurmaRepository;
import org.example.aprendeaiapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ObservacaoService {
    private final TurmaRepository turmaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ObservacaoRepository observacaoRepository;

    public ObservacaoService( TurmaRepository turmaRepository, UsuarioRepository usuarioRepository, ObservacaoRepository observacaoRepository) {
        this.turmaRepository = turmaRepository;
        this.usuarioRepository = usuarioRepository;
        this.observacaoRepository = observacaoRepository;
    }

    public MessageResponseDTO addObservacao(ObservacaoResquestDTO observacaoResquestDTO){

        Optional<Usuario> aluno = usuarioRepository.findById(observacaoResquestDTO.getIdAluno());
        if (aluno.isEmpty()){
            throw new EntityNotFoundException("Aluno não encontrado");
        }

        Optional<Usuario> professor = usuarioRepository.findById(observacaoResquestDTO.getIdProfessor());
        if (professor.isEmpty()){
            throw new EntityNotFoundException("Professor não encontrado");
        }

        Observacao observacao = new Observacao(
                LocalDate.now(),
                aluno.get(),
                professor.get(),
                observacaoResquestDTO.getObservacao()
        );

        observacaoRepository.save(observacao);

        return new MessageResponseDTO("Observação cadastrada com sucesso");
    }

    public List<ObservacaoResposeDTO> getObservacaoByProfessor(Long idProfessor){

        List<Observacao> observacoes =
                observacaoRepository.findByIdProfessorId(idProfessor);

        return observacoes.stream()
                .map(ObservacaoResposeDTO::new)
                .toList();
    }

    public List<ObservacaoResposeDTO> getObservacaoByAluno(Long idAluno){

        List<Observacao> observacoes =
                observacaoRepository.findByIdAluno(idAluno);

        return observacoes.stream()
                .map(ObservacaoResposeDTO::new)
                .toList();
    }
}
