package com.healthcare.projeto_final.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AgendamentoDto(

        @NotBlank(message = "Motivo obrigatorio")
        String motivo,
        @NotBlank(message = "Data obrigatorio")
        LocalDateTime dataHora,
        @NotBlank(message = "Paciente obrigatorio")
        Long idPaciente
) {
}
