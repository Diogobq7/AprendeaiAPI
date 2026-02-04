package org.example.aprendeaiapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.example.aprendeaiapi.validation.OnCreate;

@Schema(description = "Objeto para criação/atualização de produto")
public class ProdutoRequestDTO {
    @NotNull(message = "O nome não pode ser nulo", groups = OnCreate.class)
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres")
    @Schema(description = "Nome do produto", example = "Hamburguer de frango")
    private String nome;

    @NotNull(message = "A descrição não pode ser nula", groups = OnCreate.class)
    @Size(min = 2, message = "A descrição deve ter no mínimo 2 caracteres")
    private String descricao;

    @NotNull(message = "O preço não pode ser nulo", groups = OnCreate.class)
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que 0.00")
    @Schema(description = "Preço do produto", example = "12.99")
    private Double preco;

    @NotNull(message = "A quantidade em estoque não pode ser nula", groups = OnCreate.class)
    @Min(value = 0, message = "A quantidade em estoque deve ser maior ou igual a 0")
    @Schema(description = "Quantidade em estoque do produto", example = "10")
    private Integer quantidadeEstoque;

    // Método de conversão
//    public Produto toModel() {
//        Produto produto = new Produto();
//        produto.setNome(this.nome);
//        produto.setDescricao(this.descricao);
//        produto.setPreco(this.preco);
//        produto.setQuantidadeEstoque(this.quantidadeEstoque);
//        return produto;
//    }

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
