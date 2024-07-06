package com.healthcare.projeto_final.controller;


import com.healthcare.projeto_final.dto.PrescricoesDto;
import com.healthcare.projeto_final.entity.Prescricoes;
import com.healthcare.projeto_final.service.PrescricoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescricoes")
@RequiredArgsConstructor
public class PrescricoesController {

    private final PrescricoesService service;

    @PostMapping("/cadastro")
    public ResponseEntity<Prescricoes> cadastrar(@RequestBody PrescricoesDto dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Prescricoes>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Prescricoes> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Prescricoes> atualizar(@PathVariable Long id, @RequestBody PrescricoesDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
