package com.healthcare.projeto_final.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Prescricoes extends BaseEntity{

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime data;

    private String nomeMedico;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "prescricoes_medicamento",
            joinColumns = @JoinColumn(name = "prescricao_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> medicamentos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}
