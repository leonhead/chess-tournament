package com.leonhead.chessplan.service;

import java.util.Set;

import com.leonhead.chessplan.entity.Player;

public interface PlayerService {

	public Set<Player> getPlayers();

	public Player getPlayerById(int playerId);

	public Set<Player> findByNameContaining(String name);
	
	public Set<Player> findByTournamentId(int tournamentId);

}
