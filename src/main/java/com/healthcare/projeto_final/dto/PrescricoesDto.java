package com.healthcare.projeto_final.dto;

import java.time.LocalDateTime;

public record PrescricoesDto(
        Long idPaciente,

        String nome,

        LocalDateTime data,

        String nomeMedico
) {
}
