package com.healthcare.projeto_final.controller;

import com.healthcare.projeto_final.dto.AgendamentoDto;
import com.healthcare.projeto_final.dto.PacienteDto;
import com.healthcare.projeto_final.entity.Agendamento;
import com.healthcare.projeto_final.entity.Paciente;
import com.healthcare.projeto_final.repository.AgendamentoRepository;
import com.healthcare.projeto_final.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService service;

    @PostMapping("/cadastro")
    public ResponseEntity<Agendamento> cadastrar(@RequestBody AgendamentoDto dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Agendamento>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Agendamento> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody AgendamentoDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
