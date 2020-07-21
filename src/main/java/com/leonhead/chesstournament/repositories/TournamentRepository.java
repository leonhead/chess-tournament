package com.leonhead.chesstournament.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.leonhead.chesstournament.entity.Tournament;

@CrossOrigin("http://localhost:4200")
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

}
