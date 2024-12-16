package org.example.conferenceservice.controllers;


import org.example.conferenceservice.dtos.ConferenceDTO;
import org.example.conferenceservice.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")

public class ConferenceController {
    @Autowired
    private  ConferenceService service;

    @GetMapping
    public List<ConferenceDTO> getAllConferences() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ConferenceDTO getConferenceById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ConferenceDTO createConference(@RequestBody ConferenceDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ConferenceDTO updateConference(@PathVariable Long id, @RequestBody ConferenceDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteConference(@PathVariable Long id) {
        service.delete(id);
    }
}