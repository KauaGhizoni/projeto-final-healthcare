package com.healthcare.projeto_final.repository;

import com.healthcare.projeto_final.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {

    @Query("select sum(m.preco) from Material m where m.id in :ids")
    Double findSumOfMaterialPrecosByIds(@Param("ids") List<Long> ids);

    @Query("select m from Material m where m.id in :ids")
    List<Material> findMaterias(@Param("ids") List<Long> ids);
}
