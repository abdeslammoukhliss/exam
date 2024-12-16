package org.example.conferenceservice.repositories;

import org.example.conferenceservice.entites.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}