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

    @Query(value = """
        SELECT 
            u.matricula as matricula,
            u.nome_completo as nomeCompleto,
            u.cpf as cpf,
            u.email as email,
            t.ano_escolar as anoEscolar
        FROM usuario u
        JOIN usuario_turma ut ON u.id = ut.id_usuario
        JOIN turma t ON ut.id_turma = t.id
        WHERE u.tipo_usuario = 'ALUNO'
    """, nativeQuery = true)
    List<AlunoResposeDTO> findAllAluno();

    @Query(value = """
    SELECT 
        u.matricula,
        u.nome_completo,
        d.nome_disciplina,
        u.email,
        t.ano_escolar
    FROM usuario u
    JOIN usuario_turma ut ON u.id = ut.id_usuario
    JOIN turma t ON ut.id_turma = t.id
    JOIN disciplinas d ON t.id_disciplina = d.id
    WHERE u.tipo_usuario = 'PROFESSOR'
""", nativeQuery = true)
    List<ProfessorResposeDTO> findAllProfessor();
}
