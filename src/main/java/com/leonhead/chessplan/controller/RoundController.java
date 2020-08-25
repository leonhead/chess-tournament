package com.leonhead.chessplan.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonhead.chessplan.entity.Game;
import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;
import com.leonhead.chessplan.exceptions.EntityNotFoundException;
import com.leonhead.chessplan.service.RoundService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RoundController {

	@Autowired
	private RoundService roundService;

	@GetMapping("/rounds")
	public List<Round> getRounds() {
		return roundService.getRounds();
	}

	@GetMapping("/rounds/{roundId}")
	public Round getRoundById(@PathVariable int roundId) {
		Round round = roundService.getRoundById(roundId);
		if (round == null) {
			throw new EntityNotFoundException("Round not found for id - " + roundId);
		}
		return round;
	}

	@GetMapping("/rounds/{roundId}/games")
	public Set<Game> getGames(@PathVariable int roundId) {
		Set<Game> games = roundService.getGamesById(roundId);
		return games;
	}

	@GetMapping("/rounds/{roundId}/players")
	public Set<Player> getPlayers(@PathVariable int roundId) {
		Set<Player> games = roundService.getPlayers(roundId);
		return games;
	}

	@PostMapping("/rounds/{roundId}/games")
	public void createGames(@PathVariable int roundId) {
		roundService.createGames(roundId);
	}

}
