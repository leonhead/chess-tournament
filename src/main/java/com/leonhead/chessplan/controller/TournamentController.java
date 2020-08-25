package com.leonhead.chessplan.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;
import com.leonhead.chessplan.entity.Tournament;
import com.leonhead.chessplan.exceptions.EntityNotFoundException;
import com.leonhead.chessplan.service.TournamentService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class TournamentController {

	@Autowired
	private TournamentService tournamentService;

	@GetMapping("/tournaments")
	public List<Tournament> getTournaments() {
		return tournamentService.getTournaments();
	}

	@GetMapping("/tournaments/{tournamentId}")
	public Tournament getTournamentById(@PathVariable int tournamentId) {
		Tournament tournament = tournamentService.getTournamentById(tournamentId);
		if (tournament == null) {
			throw new EntityNotFoundException("Tournament not found for id - " + tournamentId);
		}

		return tournament;
	}

	@GetMapping("/tournaments/search/findByRoundId")
	public Tournament getTournamentByRoundId(@RequestParam int id) {
		Tournament tournament = tournamentService.findByRoundId(id);
		if (tournament == null) {
			throw new EntityNotFoundException("Tournament not found for id - " + id);
		}

		return tournament;
	}

	@PostMapping("/tournaments")
	public Tournament saveTournament(@RequestBody Tournament tournament) {
		tournamentService.saveTournament(tournament);
		return tournament;
	}

	@GetMapping("/tournaments/{tournamentId}/players")
	public Set<Player> getPlayersByTournamentId(@PathVariable int tournamentId) {
		return tournamentService.getPlayers(tournamentId);
	}

	@GetMapping("/tournaments/{tournamentId}/rounds")
	public Set<Round> getRoundsByTournamentId(@PathVariable int tournamentId) {
		return tournamentService.getRounds(tournamentId);
	}

	@PostMapping("/tournaments/{tournamentId}/players")
	public Player addPlayer(@PathVariable int tournamentId, @RequestBody Player player) {
		return tournamentService.addPlayer(tournamentId, player);
	}

	@PostMapping("/tournaments/{tournamentId}/rounds")
	public Round addRound(@PathVariable int tournamentId, @RequestBody Round round) {
		return tournamentService.addRound(tournamentId, round);
	}

	@DeleteMapping("/tournaments/{tournamentId}/players")
	public Player removePlayer(@PathVariable int tournamentId, @RequestBody Player player) {
		return tournamentService.removePlayer(tournamentId, player);
	}
}
