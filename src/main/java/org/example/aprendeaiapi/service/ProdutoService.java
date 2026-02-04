package org.example.aprendeaiapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.aprendeaiapi.dto.ProdutoRequestDTO;
import org.example.aprendeaiapi.dto.ProdutoResponseDTO;
import org.example.aprendeaiapi.exception.InsufficientStockException;
import org.example.aprendeaiapi.model.Produto;
import org.example.aprendeaiapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.*;

@Service
public class ProdutoService {
    private final ObjectMapper objectMapper;
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository, ObjectMapper objectMapper) {
        this.produtoRepository = produtoRepository;
        this.objectMapper = objectMapper;
    }

    public List<ProdutoResponseDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoResponseDTO> produtoResponseDTOs = new ArrayList<>();
        for (Produto produto : produtos) {
            produtoResponseDTOs.add(ProdutoResponseDTO.fromModel(produto));
        }
        return produtoResponseDTOs;
    }

    public Produto buscarProduto(Long id) {
         return produtoRepository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    @Transactional
    public ProdutoResponseDTO inserirProduto(ProdutoRequestDTO dto) {
        Produto produto = objectMapper.convertValue(dto, Produto.class);
        return objectMapper.convertValue(
                produtoRepository.save(produto),
                ProdutoResponseDTO.class
        );
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO dto) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        produtoExistente.setNome(dto.getNome());
        produtoExistente.setDescricao(dto.getDescricao());
        produtoExistente.setPreco(dto.getPreco());
        produtoExistente.setQuantidadeEstoque(dto.getQuantidadeEstoque());

        return objectMapper.convertValue(produtoExistente, ProdutoResponseDTO.class);
    }

    public ProdutoResponseDTO atualizarProdutoParcial(Long id, ProdutoRequestDTO dto) {
        Produto produto = buscarProduto(id);
        if (dto.getPreco() != null) {
            produto.setPreco(dto.getPreco());
        }
        if (dto.getQuantidadeEstoque() != null) {
            produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        }
        if (dto.getNome() != null) {
            if (dto.getNome().trim().isEmpty())
                throw new IllegalArgumentException("O nome não pode ser vazio ou conter apenas espaços.");
            produto.setNome(dto.getNome().trim());
        }
        if (dto.getDescricao() != null) {
            produto.setDescricao(dto.getDescricao());
        }

        return objectMapper.convertValue(produto, ProdutoResponseDTO.class);
    }

    @Transactional
    public Integer lancarBaixaEstoque(Long id, Integer quantidade) {
        Produto produto = buscarProduto(id);
        if (produto.getQuantidadeEstoque() < quantidade) {
            throw new InsufficientStockException("Quantidade de estoque insuficiente!");
        }
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
        return produto.getQuantidadeEstoque();
    }

    public ProdutoResponseDTO buscarProdutoPorNome(String nome) {
        return objectMapper.convertValue(produtoRepository.findByNomeEquals(nome), ProdutoResponseDTO.class);
    }

    public List<ProdutoResponseDTO> listarProdutoPorNome(@RequestParam String nome) {
        List<Produto> produtos = produtoRepository.findByNomeLikeIgnoreCase("%" + nome + "%");
        List<ProdutoResponseDTO> produtoResponseDTOs = new ArrayList<>();
        for (Produto produto : produtos) {
            produtoResponseDTOs.add(ProdutoResponseDTO.fromModel(produto));
        }
        return produtoResponseDTOs;
    }

    public List<ProdutoResponseDTO> listarProdutoPorPreco(@RequestParam Double preco) {
        List<Produto> produtos = produtoRepository.findByPrecoEquals(preco);
        List<ProdutoResponseDTO> produtoResponseDTOs = new ArrayList<>();
        for (Produto produto : produtos) {
            produtoResponseDTOs.add(ProdutoResponseDTO.fromModel(produto));
        }
        return produtoResponseDTOs;
    }

    public List<ProdutoResponseDTO> listarProdutoPorPrecoMenor(@RequestParam Double preco) {
        List<Produto> produtos = produtoRepository.findByPrecoLessThan(preco);
        List<ProdutoResponseDTO> produtoResponseDTOs = new ArrayList<>();
        for (Produto produto : produtos) {
            produtoResponseDTOs.add(ProdutoResponseDTO.fromModel(produto));
        }
        return produtoResponseDTOs;
    }

    public List<ProdutoResponseDTO> listarProdutoPorPrecoMenorNome(@RequestParam Double preco, @RequestParam String nome) {
        List<Produto> produtos = produtoRepository.findByNomeLikeIgnoreCaseAndPrecoLessThan("%" + nome + "%",preco);
        List<ProdutoResponseDTO> produtoResponseDTOs = new ArrayList<>();
        for (Produto produto : produtos) {
            produtoResponseDTOs.add(ProdutoResponseDTO.fromModel(produto));
        }
        return produtoResponseDTOs;
    }

    @Transactional
    public Long deletarProdutoPorQuantidadeEstoque(@RequestParam Integer quantidade) {
        return produtoRepository.deleteByQuantidadeEstoqueEquals(quantidade);
    }

    public List<ProdutoResponseDTO> listarProdutosNomeIgualComQuery(String nome){
        return produtoRepository.findByNome(nome)
                .stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoResponseDTO.class))
                .toList();
    }

    public List<ProdutoResponseDTO> listarProdutosQueryParteNome(String nome){
        return produtoRepository.findByParteNome("%" + nome + "%")
                .stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoResponseDTO.class))
                .toList();
    }

    public List<ProdutoResponseDTO> listarProdutosQueryPreco(Double preco){
        return produtoRepository.findByPreco(preco)
                .stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoResponseDTO.class))
                .toList();
    }

    public List<ProdutoResponseDTO> listarProdutosQueryPrecoMenor(Double preco){
        return produtoRepository.findByPrecoMenor(preco)
                .stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoResponseDTO.class))
                .toList();
    }

    public List<ProdutoResponseDTO> listarProdutosQueryParteNomePrecoMenor(String nome, Double preco){
        return produtoRepository.findByParteNomeAndPrecoMenor("%" + nome + "%", preco)
                .stream()
                .map(produto -> objectMapper.convertValue(produto, ProdutoResponseDTO.class))
                .toList();
    }

    public Long deletarProdutoPorQuantidadeEstoqueQuery(Integer quantidade){
        return produtoRepository.deleteByQuantidadeEstoque(quantidade);
    }
}
