package com.leonhead.chesstournament.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.leonhead.chesstournament.entity.Player;

@CrossOrigin("http://localhost:4200")
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	public List<Player> findByTeamId(int id);

}
