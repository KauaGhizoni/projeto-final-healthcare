package com.healthcare.projeto_final.controller;

import com.healthcare.projeto_final.dto.FaturamentoDto;
import com.healthcare.projeto_final.entity.Faturamento;
import com.healthcare.projeto_final.service.FaturamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faturamento")
public class FaturamentoController {

    private final FaturamentoService service;

    @PostMapping("/salvar")
    public ResponseEntity<Faturamento> save(@RequestBody FaturamentoDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Faturamento>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Faturamento> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
