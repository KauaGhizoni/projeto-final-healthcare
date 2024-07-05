package com.healthcare.projeto_final.dto;

import jakarta.validation.constraints.NotBlank;

public record MedicamentoDto(
        @NotBlank(message = "Nome obrigatorio")
        String nome,
        @NotBlank(message = "Descricao obrigatorio")
        String descricao,
        @NotBlank(message = "Quantidade obrigatorio")
        Integer quantidade,
        @NotBlank(message = "Preco obrigatorio")
        Double preco
) {
}
