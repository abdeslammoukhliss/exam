package org.example.conferenceservice.mappers;


import org.example.conferenceservice.dtos.ConferenceDTO;
import org.example.conferenceservice.dtos.ReviewDTO;
import org.example.conferenceservice.entites.Conference;
import org.example.conferenceservice.entites.ConferenceType;
import org.example.conferenceservice.entites.Review;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConferenceMapper {

    public ConferenceDTO toDTO(Conference conference) {
        ConferenceDTO dto = new ConferenceDTO();
        dto.setId(conference.getId());
        dto.setTitle(conference.getTitle());
        dto.setType(conference.getType().name());
        dto.setDate(conference.getDate());
        dto.setDuration(conference.getDuration());
        dto.setAttendees(conference.getAttendees());
        dto.setScore(conference.getScore());
        dto.setReviews(conference.getReviews().stream().map(this::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public ReviewDTO toDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setDate(review.getDate());
        dto.setText(review.getText());
        dto.setStars(review.getStars());
        return dto;
    }

    public Conference toEntity(ConferenceDTO dto) {
        Conference conference = new Conference();
        conference.setTitle(dto.getTitle());
        conference.setType(ConferenceType.valueOf(dto.getType()));
        conference.setDate(dto.getDate());
        conference.setDuration(dto.getDuration());
        conference.setAttendees(dto.getAttendees());
        return conference;
    }
}
