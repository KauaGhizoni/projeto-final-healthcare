package com.healthcare.projeto_final.controller;

import com.healthcare.projeto_final.dto.MedicamentoDto;
import com.healthcare.projeto_final.entity.Medicamento;
import com.healthcare.projeto_final.service.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoService service;

    @PostMapping("/salvar")
    public ResponseEntity<Medicamento> salvar(@RequestBody MedicamentoDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Medicamento>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Medicamento> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Medicamento> atualizar(
            @PathVariable Long id,
            @RequestBody MedicamentoDto dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

