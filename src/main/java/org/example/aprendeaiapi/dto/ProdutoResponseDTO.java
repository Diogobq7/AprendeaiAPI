package org.example.aprendeaiapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.aprendeaiapi.model.Produto;

@Schema(description = "Objeto de resposta com dados do produto")
public class ProdutoResponseDTO {
    @Schema(description = "Nome do produto", example = "Hamburger de frango")
    private String nome;
    @Schema(description = "Descrição do produto", example = "Hamburger de frango com carne de frango, mussarela e cheddar")
    private String descricao;
    @Schema(description = "Preço do produto", example = "25.99")
    private Double preco;
    @Schema(description = "Quantidade em estoque do produto", example = "10")
    private Integer quantidadeEstoque;

    public static ProdutoResponseDTO fromModel(Produto produto) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        return dto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
