package org.example.keynoteservice.mappers;


import org.example.keynoteservice.dtos.KeynoteDTO;
import org.example.keynoteservice.entites.Keynote;
import org.springframework.stereotype.Component;

@Component
public class KeynoteMapper {

    // Convert Keynote Entity to KeynoteDTO
    public KeynoteDTO toDTO(Keynote keynote) {
        KeynoteDTO dto = new KeynoteDTO();
        dto.setId(keynote.getId());
        dto.setFirstName(keynote.getFirstName());
        dto.setLastName(keynote.getLastName());
        dto.setEmail(keynote.getEmail());
        dto.setRole(keynote.getRole());
        return dto;
    }

    // Convert KeynoteDTO to Keynote Entity
    public Keynote toEntity(KeynoteDTO dto) {
        Keynote keynote = new Keynote();
        keynote.setId(dto.getId());
        keynote.setFirstName(dto.getFirstName());
        keynote.setLastName(dto.getLastName());
        keynote.setEmail(dto.getEmail());
        keynote.setRole(dto.getRole());
        return keynote;
    }
}
