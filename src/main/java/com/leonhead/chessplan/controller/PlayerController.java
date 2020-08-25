package com.leonhead.chessplan.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Team;
import com.leonhead.chessplan.service.PlayerService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/players")
	public Set<Player> getPlayers() {
		return playerService.getPlayers();
	}

	@GetMapping("/players/{playerId}")
	public Player getPlayerById(@PathVariable int playerId) {
		return playerService.getPlayerById(playerId);
	}

	@GetMapping("/players/{playerId}/team")
	public List<Team> getPlayerByTeamId(@PathVariable int playerId) {
		return null;
	}

	@GetMapping("/players/search/findByNameContaining")
	public Set<Player> getPlayersByName(@RequestParam String name) {
		return playerService.findByNameContaining(name);
	}
	
	@GetMapping("/players/search/findByTournamentId")
	public Set<Player> getPlayersByTournamentId(@RequestParam int id) {
		return playerService.findByTournamentId(id);
	}

}
