package com.healthcare.projeto_final.repository;

import com.healthcare.projeto_final.entity.Material;
import com.healthcare.projeto_final.entity.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {

    @Query("select sum(m.valor) from Procedimento m where m.id in :ids")
    Double findSumOfProcedimentoPrecosByIds(@Param("ids") List<Integer> ids);

    @Query("select p from Procedimentos p where p.id in :ids")
    List<Procedimento> findProcedimentos(@Param("ids") List<Integer> ids);

}
