package com.healthcare.projeto_final.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public record ProntuarioDto(

        @NotBlank(message = "Paciente obrigatorio")
        Long idPaciente,
        @NotBlank(message = "Regristros obrigatorio")
        List<String> regristros,
        @NotBlank(message = "Data de entrada obrigatorio")
        LocalDateTime dataEntrada,
        @NotBlank(message = "Data de alta obrigatorio")
        LocalDateTime dataAlta,

        String convenio,
        @NotBlank(message = "Evolucao medica obrigatorio")
        String evolucaoMedica
) {
}
