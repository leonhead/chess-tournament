package com.leonhead.chessplan.service;

import java.util.List;
import java.util.Set;

import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;
import com.leonhead.chessplan.entity.Tournament;

public interface TournamentService {

	public List<Tournament> getTournaments();

	public Tournament getTournamentById(int tournamentId);

	public void saveTournament(Tournament tournament);

	public Player addPlayer(int tournamentId, Player player);

	public Player removePlayer(int tournamentId, Player player);

	public Round addRound(int tournamentId, Round round);

	public Set<Player> getPlayers(int tournamentId);

	public Set<Round> getRounds(int tournamentId);

	public Tournament findByRoundId(int roundId);

}
