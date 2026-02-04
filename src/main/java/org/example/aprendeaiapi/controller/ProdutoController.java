package org.example.aprendeaiapi.controller;


import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.groups.Default;
import org.example.aprendeaiapi.dto.ProdutoRequestDTO;
import org.example.aprendeaiapi.dto.ProdutoResponseDTO;
import org.example.aprendeaiapi.model.Produto;
import org.example.aprendeaiapi.openapi.ProdutoOpenAPI;
import org.example.aprendeaiapi.service.ProdutoService;
import org.example.aprendeaiapi.validation.OnCreate;
import org.example.aprendeaiapi.validation.OnPatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController // Controller indica que essa classe possui endpoints - é um controlador (recebe as requisições e aciona os métodos apropriados)
@RequestMapping("/api/produtos")
public class ProdutoController implements ProdutoOpenAPI {
    private final ProdutoService produtoService;

//    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/selecionar")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        List<ProdutoResponseDTO> produtos = produtoService.listarProdutos();

        if (produtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.emptyList());  // Retorna lista vazia com status 404
        }

        return ResponseEntity.ok(produtos);  // Retorna os produtos com status 200
    }

    @GetMapping("/selecionar/{id}")
    public ResponseEntity<Produto> buscarProduto(
            @Parameter(description = "ID do produto a ser buscado") @PathVariable Long id) {
        System.out.println("Buscando produto com ID: " + id);
        Produto produto = produtoService.buscarProduto(id);
        System.out.println("Produto encontrado: " + produto);
        return ResponseEntity.ok(produto);
    }

    @PostMapping("/inserir")
    public ResponseEntity<ProdutoResponseDTO> inserirProduto(@RequestBody
                                             @Validated({OnCreate.class, Default.class}) ProdutoRequestDTO dto) {
        ProdutoResponseDTO responseDTO = produtoService.inserirProduto(dto);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.ok("Produto removido com sucesso!");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(
            @PathVariable Long id,
            @Validated({OnCreate.class, Default.class})
            @RequestBody ProdutoRequestDTO dto) {
        ProdutoResponseDTO responseDTO = produtoService.atualizarProduto(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("/atualizarParcial/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProdutoParcial(@PathVariable Long id, @RequestBody
                                                   @Validated({OnPatch.class, Default.class}) ProdutoRequestDTO dto) {
        ProdutoResponseDTO responseDTO = produtoService.atualizarProdutoParcial(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @PatchMapping("/lancarBaixaEstoque/produtoId/{id}/quantidade/{quantidade}")
    public ResponseEntity<Integer> lancarBaixaEstoque(@PathVariable Long id,
                                                   @PathVariable Integer quantidade) {
        Integer novaQuantidade = produtoService.lancarBaixaEstoque(id, quantidade);
        return ResponseEntity.ok(novaQuantidade);
   }

   @GetMapping("/selecionarPorNome/{nome}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorNome(@PathVariable String nome) {
       ProdutoResponseDTO produtos = produtoService.buscarProdutoPorNome(nome);
       return ResponseEntity.ok(produtos);
   }

   @GetMapping("/selecionarPorNome")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutoPorNome(@RequestParam String nome) {
        List<ProdutoResponseDTO> produtos = produtoService.listarProdutoPorNome(nome);
        return ResponseEntity.ok(produtos);
   }

   @GetMapping("/selecionarPorPreco")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutoPorPreco(@RequestParam Double preco) {
        List<ProdutoResponseDTO> produtos = produtoService.listarProdutoPorPreco(preco);
        return ResponseEntity.ok(produtos);
   }

   @GetMapping("/selecionarPorPrecoMenor")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutoPorPrecoMenor(@RequestParam Double preco) {
       List<ProdutoResponseDTO> produtos = produtoService.listarProdutoPorPrecoMenor(preco);
       return ResponseEntity.ok(produtos);
   }

   @GetMapping("/selecionarPorPrecoMenorNome")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutoPorPrecoMenorNome(
            @RequestParam Double preco,
            @RequestParam String nome
   ) {
       List<ProdutoResponseDTO> produtos = produtoService.listarProdutoPorPrecoMenorNome(preco, nome);
       return ResponseEntity.ok(produtos);
   }

   @DeleteMapping("/deletarPorQuantidadeEstoque")
    public ResponseEntity<String> deletarProdutoPorQuantidadeEstoque(@RequestParam Integer quantidade) {
        Long produtosDeletados = produtoService.deletarProdutoPorQuantidadeEstoque(quantidade);
        return ResponseEntity.ok(produtosDeletados + " produtos foram excluídos com sucesso!");
   }

   @GetMapping("/listarProdutosNomeIgualComQuery")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutosNomeIgualComQuery(@RequestParam String nome) {
       List<ProdutoResponseDTO> produtos = produtoService.listarProdutosNomeIgualComQuery(nome);
       return ResponseEntity.ok(produtos);
   }

   @GetMapping("/listarProdutosQueryParteNome")
   public ResponseEntity<List<ProdutoResponseDTO>> listarProdutosQueryParteNome(@RequestParam String nome) {
       List<ProdutoResponseDTO> produtos = produtoService.listarProdutosQueryParteNome(nome);
       return ResponseEntity.ok(produtos);
   }

   @GetMapping("/listarProdutosQueryPreco")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutosQueryPreco(@RequestParam Double preco) {
        List<ProdutoResponseDTO> produtos = produtoService.listarProdutosQueryPreco(preco);
        return ResponseEntity.ok(produtos);
   }

   @GetMapping("/listarProdutosQueryPrecoMenor")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutosQueryPrecoMenor(@RequestParam Double preco) {
        List<ProdutoResponseDTO> produtos = produtoService.listarProdutosQueryPrecoMenor(preco);
        return ResponseEntity.ok(produtos);
   }

   @GetMapping("/listarProdutosQueryPrecoMenorNome")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutosQueryPrecoMenorNome(
           @RequestParam String nome,
            @RequestParam Double preco
    ) {
        List<ProdutoResponseDTO> produtos = produtoService.listarProdutosQueryParteNomePrecoMenor(nome, preco);
        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/deletarProdutoPorQuantidadeEstoqueQuery")
    public ResponseEntity<String> deletarProdutoPorQuantidadeEstoqueQuery(@RequestParam Integer quantidade) {
        Long produtosDeletados = produtoService.deletarProdutoPorQuantidadeEstoque(quantidade);
        return ResponseEntity.ok(produtosDeletados + " produto(s) foram excluídos com sucesso!");
    }
}
