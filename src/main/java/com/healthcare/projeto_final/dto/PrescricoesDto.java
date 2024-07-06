package com.healthcare.projeto_final.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record PrescricoesDto(
        @NotBlank(message = "Paciente obrigatorio")
        Long idPaciente,
        @NotBlank(message = "Nome obrigatorio")
        String nome,
        @NotBlank(message = "Data obrigatorio")
        LocalDateTime data,
        @NotBlank(message = "Medico obrigatorio")
        String nomeMedico
) {
}
