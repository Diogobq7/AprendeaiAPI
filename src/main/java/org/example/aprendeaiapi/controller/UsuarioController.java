package org.example.aprendeaiapi.controller;

import jakarta.validation.groups.Default;
import org.example.aprendeaiapi.dto.Usuario.LoginUsuarioRequestDTO;
import org.example.aprendeaiapi.dto.Usuario.LoginUsuarioResposeDTO;
import org.example.aprendeaiapi.dto.Usuario.SenhaUpadateRequestDTO;
import org.example.aprendeaiapi.dto.Usuario.UsuarioRequestDTO;
import org.example.aprendeaiapi.dto.message.MessageResponseDTO;
import org.example.aprendeaiapi.service.UsuarioService;
import org.example.aprendeaiapi.validation.OnCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUsuarioResposeDTO> login(@RequestBody @Validated({OnCreate.class, Default.class}) LoginUsuarioRequestDTO usuarioRequestDTO) {
        LoginUsuarioResposeDTO res = usuarioService.login(usuarioRequestDTO);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/updateSenha")
    public ResponseEntity<MessageResponseDTO> updateSenha(@RequestBody @Validated({OnCreate.class, Default.class})SenhaUpadateRequestDTO senhaUpadateRequestDTO) {
        MessageResponseDTO res = usuarioService.trocaSenha(senhaUpadateRequestDTO);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/deleteUsuario")
    public  ResponseEntity<MessageResponseDTO> deleteUsuario(@RequestParam(name = "idUsuario")Long idUsuario){
        MessageResponseDTO res = usuarioService.desativarConta(idUsuario);
        return ResponseEntity.ok(res);
    }
}
