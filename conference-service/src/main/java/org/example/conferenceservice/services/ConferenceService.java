package org.example.conferenceservice.services;

import org.example.conferenceservice.dtos.ConferenceDTO;
import org.example.conferenceservice.entites.Conference;
import org.example.conferenceservice.entites.ConferenceType;
import org.example.conferenceservice.mappers.ConferenceMapper;
import org.example.conferenceservice.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ConferenceService {
    @Autowired
    private  ConferenceRepository repository;
    @Autowired
    private ConferenceMapper mapper;

    public List<ConferenceDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public ConferenceDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(() -> new RuntimeException("Conference not found"));
    }

    public ConferenceDTO create(ConferenceDTO dto) {
        Conference conference = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(conference));
    }

    public ConferenceDTO update(Long id, ConferenceDTO dto) {
        Conference conference = repository.findById(id).orElseThrow(() -> new RuntimeException("Conference not found"));
        conference.setTitle(dto.getTitle());
        conference.setType(ConferenceType.valueOf(dto.getType()));
        conference.setDate(dto.getDate());
        conference.setDuration(dto.getDuration());
        conference.setAttendees(dto.getAttendees());
        return mapper.toDTO(repository.save(conference));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
