package org.example.aprendeaiapi.controller;

import jakarta.validation.groups.Default;
import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
import org.example.aprendeaiapi.dto.observacao.ObservacaoResposeDTO;
import org.example.aprendeaiapi.dto.observacao.ObservacaoResquestDTO;
import org.example.aprendeaiapi.model.Nota;
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

    public ProfessorController(TurmaService turmaService, ObservacaoService observacaoService) {
        this.turmaService = turmaService;
        this.observacaoService = observacaoService;
    }

    @GetMapping("/getAlunosTurma")
    public ResponseEntity<List<UsuarioResposeDTO>> getTurmaByProfessor(@RequestParam(name = "professorId")Long professorId) {
        List<UsuarioResposeDTO> res = turmaService.geAlunosByProfessor(professorId);
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
}
