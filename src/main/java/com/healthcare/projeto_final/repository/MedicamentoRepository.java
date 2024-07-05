package com.healthcare.projeto_final.repository;

import com.healthcare.projeto_final.entity.Material;
import com.healthcare.projeto_final.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento,Long> {

    @Query("select sum(m.preco) from Medicamento m where m.id in :ids")
    Double findSumOfMedicamentoPrecosByIds(@Param("ids") List<Integer> ids);

    @Query("select m from Medicamento m where m.id in :ids")
    List<Medicamento> findMedicamentos(@Param("ids") List<Integer> ids);

}
