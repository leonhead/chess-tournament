package com.leonhead.chesstournament.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.leonhead.chesstournament.entity.Game;

@CrossOrigin("http://localhost:4200")
public interface GameRepository extends JpaRepository<Game, Integer> {

}
