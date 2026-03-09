package org.example.aprendeaiapi.controller;

import jakarta.validation.groups.Default;
import org.example.aprendeaiapi.dto.Usuario.*;
import org.example.aprendeaiapi.dto.disciplina.DisciplinaResposeDTO;
import org.example.aprendeaiapi.dto.disciplina.UpdateDiciplinaRequestDTO;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.dto.turma.TurmaRequestDTO;
import org.example.aprendeaiapi.dto.turma.TurmaResposeDTO;
import org.example.aprendeaiapi.dto.turma.UpdateTurmaResquestDTO;
import org.example.aprendeaiapi.model.Disciplina;
import org.example.aprendeaiapi.model.TipoUsuario;
import org.example.aprendeaiapi.service.AdminService;
import org.example.aprendeaiapi.service.UsuarioService;
import org.example.aprendeaiapi.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {
    private final AdminService adminService;
    private final UsuarioService usuarioService;

    public AdminController(AdminService adminService, UsuarioService usuarioService) {
        this.adminService = adminService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/addUsuario")
    public ResponseEntity<MessageResponseDTO> addUsuario(@RequestBody @Validated({OnCreate.class, Default.class}) UsuarioRequestDTO usuarioRequestDTO) {
        MessageResponseDTO res = adminService.adicionarUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/findTipoUsuario")
    public ResponseEntity<List<UsuarioResposeDTO>> findTipoUsuario(@RequestParam(name = "tipoUsuario")TipoUsuario tipoUsuario ) {
        List<UsuarioResposeDTO> buscarUsuarios = adminService.getUsuarios(tipoUsuario);
        return ResponseEntity.ok(buscarUsuarios);
    }

    @GetMapping("/findTurmas")
    public ResponseEntity<List<TurmaResposeDTO>> findAllTurma(){
        List<TurmaResposeDTO> buscarTurmas = adminService.getTurmas();
        return ResponseEntity.ok(buscarTurmas);
    }

    @PostMapping("/addTurma")
    public ResponseEntity<MessageResponseDTO> addTurma(@RequestBody @Validated({OnCreate.class, Default.class}) TurmaRequestDTO turmaRequestDTO) {
        MessageResponseDTO res = adminService.adicionarTurma(turmaRequestDTO);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/updateTurma")
    public ResponseEntity<MessageResponseDTO> upadateTurma(@RequestBody @Validated({OnCreate.class, Default.class}) UpdateTurmaResquestDTO updateTurmaResquestDTO) {
        MessageResponseDTO res = adminService.updateTurma(updateTurmaResquestDTO);
        return ResponseEntity.ok(res);
    }


    @GetMapping("/getDisciplina")
    public ResponseEntity<List<DisciplinaResposeDTO>> findAllDisciplina() {
        List<DisciplinaResposeDTO> disciplinas = adminService.getDisciplinas();
        return ResponseEntity.ok(disciplinas);
    }

    @PostMapping("/addDisciplina")
    public ResponseEntity<MessageResponseDTO> addDisciplina(@RequestParam(name = "disciplina")String disciplina){
        MessageResponseDTO res = adminService.adicionarDisciplina(disciplina);
        return ResponseEntity.ok(res);
    }
    @PostMapping("/updateDiciplina")
    public ResponseEntity<MessageResponseDTO> updateDiciplina(@RequestBody @Validated({OnCreate.class, Default.class})UpdateDiciplinaRequestDTO updateDiciplinaRequestDTO){
        MessageResponseDTO res = adminService.updateDiciplina(updateDiciplinaRequestDTO);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getProfessor")
    public ResponseEntity<List<ProfessorResposeDTO>> getProfessor(){
        List<ProfessorResposeDTO> res = usuarioService.listarProfessores();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getAlunos")
    public ResponseEntity<List<AlunoResposeDTO>> getAlunos() {
        List<AlunoResposeDTO> res = usuarioService.listarAlunos();
        return ResponseEntity.ok(res);
    }

    @PostMapping("/updateUsuario")
    public ResponseEntity<MessageResponseDTO> updadeUsuario(@RequestBody @Validated({OnCreate.class, Default.class}) UpdateUsuarioRequestDTO updateUsuarioRequestDTO, @RequestParam(name = "emailAtual")String emailAtual){
        MessageResponseDTO res = adminService.updateUsuario(updateUsuarioRequestDTO, emailAtual);
       return ResponseEntity.ok(res);
    }


}


