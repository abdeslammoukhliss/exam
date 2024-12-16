package org.example.conferenceservice.repositories;


import org.example.conferenceservice.entites.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}