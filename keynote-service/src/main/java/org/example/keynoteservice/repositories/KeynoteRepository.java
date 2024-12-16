package org.example.keynoteservice.repositories;


import org.example.keynoteservice.entites.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
}
