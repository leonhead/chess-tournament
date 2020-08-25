package com.leonhead.chessplan.service;

import java.util.Set;

import com.leonhead.chessplan.entity.Game;

public interface GameService {

	public void saveGame(Game game);

	public Set<Game> getGames();

	public Game getGameById(int playerId);

}
