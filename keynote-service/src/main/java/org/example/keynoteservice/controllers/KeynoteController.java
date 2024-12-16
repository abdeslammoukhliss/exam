package org.example.keynoteservice.controllers;


import lombok.RequiredArgsConstructor;
import org.example.keynoteservice.dtos.KeynoteDTO;
import org.example.keynoteservice.services.KeynoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keynotes")

public class KeynoteController {
    @Autowired
    private  KeynoteService service;

    @GetMapping
    public ResponseEntity<List<KeynoteDTO>> getAllKeynotes() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeynoteDTO> getKeynoteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<KeynoteDTO> createKeynote(@RequestBody KeynoteDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeynoteDTO> updateKeynote(@PathVariable Long id, @RequestBody KeynoteDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKeynote(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}