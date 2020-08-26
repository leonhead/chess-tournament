package com.leonhead.chessplan.dao;

import java.util.List;
import java.util.Set;

import com.leonhead.chessplan.entity.Game;
import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;

public interface RoundDAO {

	public List<Round> getRounds();

	public Round getRoundById(int roundId);

	public Set<Game> getGamesById(int roundId);

	public Set<Player> getPlayers(int roundId);

	void createGames(List<Player> whitePlayers, List<Player> blackPlayers, int roundId);

}
