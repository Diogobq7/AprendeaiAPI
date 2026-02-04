package org.example.aprendeaiapi.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.aprendeaiapi.dto.ProdutoResponseDTO;
import org.example.aprendeaiapi.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProdutoOpenAPI {
    @Operation(summary = "Buscar produto por ID",
            description = "Retorna um produto pelo seu ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProdutoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    ResponseEntity<Produto> buscarProduto(
            @Parameter(description = "ID do produto a ser buscado") @PathVariable Long id);


}
