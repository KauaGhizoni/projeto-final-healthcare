package com.healthcare.projeto_final.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record FaturamentoDto(
        @NotBlank(message = "Procedimento obrigatorio")
        List<Integer> procedimentoIds,
        @NotBlank(message = "Material obrigatorio")
        List<Integer> materialIds,
        @NotBlank(message = "Medicamento obrigatorio")
        List<Integer> medicamentoIds,
        Double valorTotal
) {
}
