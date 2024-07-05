package com.healthcare.projeto_final.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prontuario extends BaseEntity {

    private List<String> registros;

    private String evolucaoMedica;

    private LocalDateTime dataEntrada;

    private LocalDateTime dataAlta;

    private String convenio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}
