package com.healthcare.projeto_final.service;

import com.healthcare.projeto_final.dto.MaterialDto;
import com.healthcare.projeto_final.entity.Material;
import com.healthcare.projeto_final.repository.MaterialRepository;
import com.healthcare.projeto_final.service.interfaces.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService implements AbstractService<Material, MaterialDto> {

    private final MaterialRepository repository;

    @Override
    public Material save(MaterialDto dto) {
        return repository.save(Material.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .quantidade(dto.quantidade())
                .build());
    }

    @Override
    public Material findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Material não encontrado."));
    }

    @Override
    public List<Material> findAll() {
        return repository.findAll();
    }

    @Override
    public Material update(Long id, MaterialDto dto) {
        var material = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Material não encontrado."));
        material.setNome(dto.nome());
        material.setDescricao(dto.descricao());
        material.setQuantidade(dto.quantidade());
        return repository.save(material);
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Material não encontrado.");
        }
    }
}
