package org.example.aprendeaiapi.repository;

import org.example.aprendeaiapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByNomeEquals(String nome);

    List<Produto> findByNomeLikeIgnoreCase(String nome);

    List<Produto> findByPrecoEquals(Double preco);

    List<Produto> findByPrecoLessThan(Double preco);

    List<Produto> findByNomeLikeIgnoreCaseAndPrecoLessThan(String nome, Double preco);

    Long deleteByQuantidadeEstoqueEquals(Integer quantidadeEstoque);

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    List<Produto> findByNome(@Param("nome")String nome);

    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(:nome)")
    List<Produto> findByParteNome(@Param("nome")String nome);

    @Query("SELECT p FROM Produto p WHERE p.preco = :preco")
    List<Produto> findByPreco(@Param("preco")Double preco);

    @Query("SELECT p FROM Produto p WHERE p.preco < :preco")
    List<Produto> findByPrecoMenor(@Param("preco")Double preco);

    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(:nome) AND p.preco < :preco")
    List<Produto> findByParteNomeAndPrecoMenor(@Param("nome")String nome, @Param("preco")Double preco);

    @Query("DELETE FROM Produto p WHERE p.quantidadeEstoque = :quantidadeEstoque")
    Long deleteByQuantidadeEstoque(@Param("quantidadeEstoque")Integer quantidadeEstoque);
}
