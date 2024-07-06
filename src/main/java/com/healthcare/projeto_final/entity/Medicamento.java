package com.healthcare.projeto_final.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medicamento extends BaseEntity{

    private String nome;

    private String descricao;

    private Integer quantidade;

    private Double preco;

    @JsonIgnore
    @ManyToMany(mappedBy = "medicamentos")
    private List<Faturamento> faturamento;

    @JsonIgnore
    @ManyToMany(mappedBy = "medicamentos")
    private List<Prescricoes> prescricoes;

}
