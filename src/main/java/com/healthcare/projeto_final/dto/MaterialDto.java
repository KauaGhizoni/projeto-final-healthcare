package com.healthcare.projeto_final.dto;

import jakarta.validation.constraints.NotBlank;

public record MaterialDto(
        @NotBlank(message = "Nome obrigatorio")
        String nome,
        @NotBlank(message = "Quantidade obrigatorio")
        Integer quantidade,
        @NotBlank(message = "Descricao obrigatorio")
        String descricao,
        @NotBlank(message = "Preco obrigatorio")
        Double preco

) {
}
