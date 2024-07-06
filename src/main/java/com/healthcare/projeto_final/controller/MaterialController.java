package com.healthcare.projeto_final.controller;

import com.healthcare.projeto_final.dto.MaterialDto;
import com.healthcare.projeto_final.entity.Material;
import com.healthcare.projeto_final.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @PostMapping("/salvar")
    public ResponseEntity<Material> salvar(@RequestBody MaterialDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Material>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Material> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Material> atualizar(
            @PathVariable Long id,
            @RequestBody MaterialDto dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
