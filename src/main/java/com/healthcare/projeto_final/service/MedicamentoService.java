package com.healthcare.projeto_final.service;

import com.healthcare.projeto_final.dto.MedicamentoDto;
import com.healthcare.projeto_final.entity.Medicamento;
import com.healthcare.projeto_final.repository.MedicamentoRepository;
import com.healthcare.projeto_final.service.interfaces.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicamentoService implements AbstractService<Medicamento, MedicamentoDto> {

    private final MedicamentoRepository repository;

    @Override
    public Medicamento save(MedicamentoDto dto) {
        return repository.save(Medicamento.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .quantidade(dto.quantidade())
                .preco(dto.preco())
                .build());
    }

    @Override
    public Medicamento findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado"));
    }

    @Override
    public List<Medicamento> findAll() {
        return repository.findAll();
    }

    @Override
    public Medicamento update(Long id, MedicamentoDto dto) {
        var medicamento = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado"));
        medicamento.setNome(dto.nome());
        medicamento.setDescricao(dto.descricao());
        medicamento.setQuantidade(dto.quantidade());
        medicamento.setPreco(dto.preco());
        return repository.save(medicamento);
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Medicamento não encontrado");
        }
    }
}
