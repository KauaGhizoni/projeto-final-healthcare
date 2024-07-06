package com.healthcare.projeto_final.service;

import com.healthcare.projeto_final.dto.FaturamentoDto;
import com.healthcare.projeto_final.entity.Faturamento;
import com.healthcare.projeto_final.repository.*;
import com.healthcare.projeto_final.service.interfaces.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class FaturamentoService implements AbstractService<Faturamento, FaturamentoDto> {

    private final FaturamentoRepository repository;
    private final MedicamentoRepository medicamentoRepository;
    private final ProcedimentoRepository procedimentoRepository;
    private final MaterialRepository materialRepository;
    private final PacienteRepository pacienteRepository;

    @Override
    public Faturamento save(FaturamentoDto entity) {
        var paciente = pacienteRepository.findById(entity.idPaciente()).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        return repository.save(Faturamento.builder()
                .paciente(paciente)
                .materiais(materialRepository.findMaterias(entity.materialIds()))
                .procedimentos(procedimentoRepository.findProcedimentos(entity.procedimentoIds()))
                .medicamentos(medicamentoRepository.findMedicamentos(entity.medicamentoIds()))
                .valorTotal(calculaValorTotal(entity))
                .build());
    }

    @Override
    public Faturamento findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Faturamento não encontrada"));
    }

    @Override
    public List<Faturamento> findAll() {
        return repository.findAll();
    }

    @Override
    public Faturamento update(Long id, FaturamentoDto entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    private Double calculaValorTotal(FaturamentoDto dto) {
        return calculaValorPorIds(dto.medicamentoIds(), medicamentoRepository::findSumOfMedicamentoPrecosByIds) +
                calculaValorPorIds(dto.procedimentoIds(), procedimentoRepository::findSumOfProcedimentoPrecosByIds) +
                calculaValorPorIds(dto.materialIds(), materialRepository::findSumOfMaterialPrecosByIds);
    }

    private Double calculaValorPorIds(List<Long> ids, Function<List<Long>, Double> valorFinder) {
        Double valor = valorFinder.apply(ids);
        return valor != null ? valor : 0.0;
    }
}
