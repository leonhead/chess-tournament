package com.leonhead.chessplan.doa;

import java.util.Set;

import com.leonhead.chessplan.entity.Player;

public interface PlayerDAO {
	
	public Set<Player> getPlayers();

	public Player getPlayerById(int playerId);

	public Set<Player> findByNameContaining(String name);

	public Set<Player> findByTournamentId(int tournamentId);

}
