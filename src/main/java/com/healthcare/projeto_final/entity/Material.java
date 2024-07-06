package com.healthcare.projeto_final.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Material extends BaseEntity {

    private String nome;

    private Integer quantidade;

    private String descricao;

    private Double preco;

    @JsonIgnore
    @ManyToMany(mappedBy = "materiais")
    private List<Faturamento> faturamento;

}
