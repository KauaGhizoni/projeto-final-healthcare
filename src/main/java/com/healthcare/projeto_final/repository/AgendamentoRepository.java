package com.healthcare.projeto_final.repository;

import com.healthcare.projeto_final.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {

    @Query("select count(a) > 0 from Agendamento a where a.dataHora = :dataHora")
    boolean verificaDisponibilidadeDataHora(@Param("dataHora") LocalDateTime dataHora);

}
