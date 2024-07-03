package com.healthcare.projeto_final.dto;

import java.time.LocalDateTime;

public record AgendamentoDto(
        String motivo,
        LocalDateTime dataHora,
        Long idPaciente
) {
}
