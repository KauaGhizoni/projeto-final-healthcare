package com.healthcare.projeto_final.service;

import com.healthcare.projeto_final.dto.AgendamentoDto;
import com.healthcare.projeto_final.dto.PrescricoesDto;
import com.healthcare.projeto_final.entity.Agendamento;
import com.healthcare.projeto_final.entity.Prescricoes;
import com.healthcare.projeto_final.repository.AgendamentoRepository;
import com.healthcare.projeto_final.repository.PacienteRepository;
import com.healthcare.projeto_final.repository.PrescricoesRepository;
import com.healthcare.projeto_final.service.interfaces.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescricoesService implements AbstractService<Prescricoes, PrescricoesDto> {

    private final PrescricoesRepository repository;
    @Override
    public Prescricoes save(PrescricoesDto entity) {
        return repository.save(Prescricoes.builder()
                .nome(entity.nome())
                .data(entity.data())
                .nomeMedico(entity.nomeMedico())
                .build());
    }

    @Override
    public Prescricoes findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Prescrição não encontrada"));
    }

    @Override
    public List<Prescricoes> findAll() {
        return repository.findAll();
    }

    @Override
    public Prescricoes update(Long id, PrescricoesDto entity) {
        return repository.save(Prescricoes.builder()
                .nome(entity.nome())
                .data(entity.data())
                .nomeMedico(entity.nomeMedico())
                .build());
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

}
