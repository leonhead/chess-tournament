package com.leonhead.chessplan.service;

import java.util.List;
import java.util.Set;

import com.leonhead.chessplan.entity.Game;
import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;

public interface RoundService {

	public List<Round> getRounds();

	public Round getRoundById(int roundId);

	public Set<Game> getGamesById(int roundId);

	public void createGames(int roundId);

	public Set<Player> getPlayers(int roundId);

}
