package org.example.conferenceservice.mappers;


import org.example.conferenceservice.dtos.ReviewDTO;
import org.example.conferenceservice.entites.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewDTO toDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setDate(review.getDate());
        dto.setText(review.getText());
        dto.setStars(review.getStars());
        return dto;
    }

    public Review toEntity(ReviewDTO dto) {
        Review review = new Review();
        review.setId(dto.getId()); // Optional, usually for updates
        review.setDate(dto.getDate());
        review.setText(dto.getText());
        review.setStars(dto.getStars());
        return review;
    }
}
