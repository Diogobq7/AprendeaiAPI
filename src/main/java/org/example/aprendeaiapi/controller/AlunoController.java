package org.example.aprendeaiapi.controller;

import org.example.aprendeaiapi.dto.Usuario.AlunoResposeDTO;
import org.example.aprendeaiapi.dto.nota.NotaResposeDTO;
import org.example.aprendeaiapi.dto.observacao.ObservacaoResposeDTO;
import org.example.aprendeaiapi.model.Observacao;
import org.example.aprendeaiapi.service.NotaService;
import org.example.aprendeaiapi.service.ObservacaoService;
import org.example.aprendeaiapi.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    final private ObservacaoService observacaoService;
    final private NotaService notaService;

    public AlunoController(ObservacaoService observacaoService, NotaService notaService) {
        this.observacaoService = observacaoService;
        this.notaService = notaService;

    }

    @GetMapping("/getObservacao")
    public ResponseEntity<List<ObservacaoResposeDTO>> getObservacao(@RequestParam(name = "idAluno")Long idAluno) {
        List<ObservacaoResposeDTO> res = observacaoService.getObservacaoByAluno(idAluno);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getNotas")
    public ResponseEntity<List<NotaResposeDTO>> getNotas(@RequestParam(name = "idAluno")Long idAluno) {
        List<NotaResposeDTO> res = notaService.getAlunoNota(idAluno);
        return ResponseEntity.ok(res);
    }


}
