package com.healthcare.projeto_final.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record FaturamentoDto(
        @NotBlank(message = "Procedimento obrigatorio")
        List<Long> procedimentoIds,
        @NotBlank(message = "Material obrigatorio")
        List<Long> materialIds,
        @NotBlank(message = "Medicamento obrigatorio")
        List<Long> medicamentoIds,
        Double valorTotal
) {
}
