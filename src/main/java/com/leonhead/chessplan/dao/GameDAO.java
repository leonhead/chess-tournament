package com.leonhead.chessplan.dao;

import java.util.List;

import com.leonhead.chessplan.entity.Game;

public interface GameDAO {

	public List<Game> getGames();

	public Game getGameById(int gameId);

	public void saveGame(Game game);

}
