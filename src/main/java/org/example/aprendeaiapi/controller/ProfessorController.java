package org.example.aprendeaiapi.controller;

import jakarta.validation.groups.Default;
import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.dto.nota.NotaRequestDTO;
import org.example.aprendeaiapi.dto.observacao.ObservacaoResposeDTO;
import org.example.aprendeaiapi.dto.observacao.ObservacaoResquestDTO;
import org.example.aprendeaiapi.dto.turma.AlunoTurmaNotaDTO;
import org.example.aprendeaiapi.service.NotaService;
import org.example.aprendeaiapi.service.ObservacaoService;
import org.example.aprendeaiapi.service.TurmaService;
import org.example.aprendeaiapi.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
@CrossOrigin("*")
public class ProfessorController {

    private final TurmaService turmaService;
    private final ObservacaoService observacaoService;
    private final NotaService notaService;

    public ProfessorController(TurmaService turmaService, ObservacaoService observacaoService, NotaService notaService) {
        this.turmaService = turmaService;
        this.observacaoService = observacaoService;
        this.notaService = notaService;
    }

    @GetMapping("/getAlunosByProfessor")
    public ResponseEntity<List<AlunoTurmaNotaDTO>> getTurmaByProfessor(@RequestParam(name = "professorId")Long professorId) {
        List<AlunoTurmaNotaDTO> res = turmaService.geAlunosByProfessor(professorId);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getObservacao")
    public ResponseEntity<List<ObservacaoResposeDTO>> getObservacaoByProfessor(@RequestParam(name = "professorId")Long professorId) {
        List<ObservacaoResposeDTO> res = observacaoService.getObservacaoByProfessor(professorId);
        return ResponseEntity.ok(res);
    }
    
    @GetMapping("/getAlunoByTurma")
    public ResponseEntity<List<UsuarioResposeDTO>> getAlunoByTurma(@RequestParam(name = "idTurma")Long idTurma){
        List<UsuarioResposeDTO> res = turmaService.getAlunoByTurma(idTurma);
        return ResponseEntity.ok(res);
    }
    @PostMapping("/addObservacao")
    public ResponseEntity<MessageResponseDTO> addObservacao(@RequestBody @Validated({OnCreate.class, Default.class}) ObservacaoResquestDTO observacaoResquestDTO) {
        MessageResponseDTO res = observacaoService.addObservacao(observacaoResquestDTO);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/addNota")
    public ResponseEntity<MessageResponseDTO> addNota(@RequestBody @Validated({OnCreate.class, Default.class})NotaRequestDTO notaRequestDTO){
        MessageResponseDTO res = notaService.addNota(notaRequestDTO);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/updateNota")
    public ResponseEntity<MessageResponseDTO> updateNota(@RequestBody @Validated({OnCreate.class, Default.class})NotaRequestDTO notaRequestDTO, @RequestParam Long idNota){
        MessageResponseDTO res = notaService.updateNota(notaRequestDTO, idNota);
        return ResponseEntity.ok(res);
    }
}
