package com.leonhead.chessplan.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonhead.chessplan.entity.Game;
import com.leonhead.chessplan.exceptions.EntityNotFoundException;
import com.leonhead.chessplan.service.GameService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping("/games")
	public Set<Game> getGames() {
		return gameService.getGames();
	}

	@PostMapping("/games")
	public Game saveGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return game;
	}

	@GetMapping("/games/{gameId}")
	public Game getRoundById(@PathVariable int gameId) {
		Game game = gameService.getGameById(gameId);
		if (game == null) {
			throw new EntityNotFoundException("Game not found for id - " + gameId);
		}
		return game;
	}

}
