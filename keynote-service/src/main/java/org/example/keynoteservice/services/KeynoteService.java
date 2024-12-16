package org.example.keynoteservice.services;

import  lombok.RequiredArgsConstructor;
import org.example.keynoteservice.dtos.KeynoteDTO;
import org.example.keynoteservice.entites.Keynote;
import org.example.keynoteservice.mappers.KeynoteMapper;
import org.example.keynoteservice.repositories.KeynoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeynoteService {
    @Autowired
    private  KeynoteRepository repository;
    @Autowired
    private  KeynoteMapper mapper;

    public List<KeynoteDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public KeynoteDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Keynote not found"));
    }

    public KeynoteDTO create(KeynoteDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public KeynoteDTO update(Long id, KeynoteDTO dto) {
        Keynote keynote = repository.findById(id).orElseThrow(() -> new RuntimeException("Keynote not found"));
        keynote.setFirstName(dto.getFirstName());
        keynote.setLastName(dto.getLastName());
        keynote.setEmail(dto.getEmail());
        keynote.setRole(dto.getRole());
        return mapper.toDTO(repository.save(keynote));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
