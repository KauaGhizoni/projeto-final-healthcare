package com.healthcare.projeto_final.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ProntuarioDto(
        Long idPaciente,

        List<String> regristros,

        LocalDateTime dataEntrada,

        LocalDateTime dataAlta,

        String convenio,

        String evolucaoMedica
) {
}
