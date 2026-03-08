package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.dto.Usuario.AlunoResposeDTO;
import org.example.aprendeaiapi.dto.Usuario.ProfessorResposeDTO;
import org.example.aprendeaiapi.dto.Usuario.UsuarioResposeDTO;
import org.example.aprendeaiapi.dto.disciplina.DisciplinaResposeDTO;
import org.example.aprendeaiapi.model.TipoUsuario;
import org.example.aprendeaiapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Modifying
    @Query("UPDATE Usuario u SET u.senha = :senha WHERE u.email = :email")
    void updateSenha(@Param("email") String email,
                     @Param("senha") String senha);
    List<UsuarioResposeDTO> findByTipoUsuario(TipoUsuario tipoUsuario);

    @Query("""
    SELECT u.matricula, u.nomeCompleto, u.cpf, u.email, t.anoEscolar FROM Usuario  u
            JOIN UsuarioTurma ut ON u.id = ut.usuario.id
            JOIN Turma t ON ut.turma.id = t.id
            WHERE u.tipoUsuario = 'ALUNO'
    """)
    List<AlunoResposeDTO> findAllAluno();

    @Query("""
        SELECT u.matricula, u.nomeCompleto, d.nomeDisciplina, u.email, t.anoEscolar FROM Usuario u
        JOIN UsuarioTurma ut ON u.id = ut.usuario.id
        JOIN Turma t ON ut.turma.id = t.id
        JOIN Disciplina d ON t.disciplina.id = d.id
        WHERE u.tipoUsuario = 'PROFESSOR'
    """)
    List<ProfessorResposeDTO> findAllProfessor();
}
