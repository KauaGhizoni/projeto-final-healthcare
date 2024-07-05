package com.healthcare.projeto_final.service;

import com.healthcare.projeto_final.dto.FaturamentoDto;
import com.healthcare.projeto_final.entity.Faturamento;
import com.healthcare.projeto_final.repository.FaturamentoRepository;
import com.healthcare.projeto_final.repository.MaterialRepository;
import com.healthcare.projeto_final.repository.MedicamentoRepository;
import com.healthcare.projeto_final.repository.ProcedimentoRepository;
import com.healthcare.projeto_final.service.interfaces.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaturamentoService implements AbstractService<Faturamento, FaturamentoDto> {

    private final FaturamentoRepository repository;
    private final MedicamentoRepository medicamentoRepository;
    private final ProcedimentoRepository procedimentoRepository;
    private final MaterialRepository materialRepository;

    @Override
    public Faturamento save(FaturamentoDto entity) {
        return repository.save(Faturamento.builder()
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
        var valorMedicamento = medicamentoRepository.findSumOfMedicamentoPrecosByIds(dto.medicamentoIds());
        var valorProcedimento = procedimentoRepository.findSumOfProcedimentoPrecosByIds(dto.procedimentoIds());
        var valorMaterial = materialRepository.findSumOfMaterialPrecosByIds(dto.materialIds());
        return valorMaterial + valorMedicamento + valorProcedimento;
    }
}
