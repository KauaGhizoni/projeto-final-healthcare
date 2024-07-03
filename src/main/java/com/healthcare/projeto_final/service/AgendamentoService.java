package com.healthcare.projeto_final.service;
import com.healthcare.projeto_final.dto.AgendamentoDto;
import com.healthcare.projeto_final.dto.ProntuarioDto;
import com.healthcare.projeto_final.entity.Agendamento;
import com.healthcare.projeto_final.entity.Prontuario;
import com.healthcare.projeto_final.repository.AgendamentoRepository;
import com.healthcare.projeto_final.repository.PacienteRepository;
import com.healthcare.projeto_final.service.interfaces.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService implements AbstractService<Agendamento, AgendamentoDto> {

    private final AgendamentoRepository repository;
    private final PacienteRepository pacienteRepository;
    @Override
    public Agendamento save(AgendamentoDto entity) {
        var paciente = pacienteRepository.findById(entity.idPaciente()).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        return repository.save(Agendamento.builder()
                .motivo(entity.motivo())
                .dataHora(entity.dataHora())
                .paciente(paciente)
                .build());
    }

    @Override
    public Agendamento findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
    }

    @Override
    public List<Agendamento> findAll() {
        return repository.findAll();
    }

    @Override
    public Agendamento update(Long id, AgendamentoDto entity) {
        var paciente = pacienteRepository.findById(entity.idPaciente()).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        return repository.save(Agendamento.builder()
                .motivo(entity.motivo())
                .dataHora(entity.dataHora())
                .paciente(paciente)
                .build());
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

}
