package com.healthcare.projeto_final.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Procedimento extends BaseEntity{

    private String nome;

    private String descricao;

    private Double valor;

    @JsonIgnore
    @ManyToMany(mappedBy = "procedimentos")
    private List<Faturamento> faturamento;


}
