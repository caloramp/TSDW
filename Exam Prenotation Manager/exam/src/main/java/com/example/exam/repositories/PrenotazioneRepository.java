package com.example.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam.models.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    
}
