package com.healthcare.projeto_final.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente extends BaseEntity{

    private String nome;

    private String cpf;

    private String telefone;

    private String genero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<Agendamento> agendamentos;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<Prontuario> prontuarios;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<Faturamento> contasPaciente;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<Prescricoes> prescricoes;
}
