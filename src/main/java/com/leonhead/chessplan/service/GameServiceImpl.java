package com.leonhead.chessplan.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonhead.chessplan.dao.GameDAO;
import com.leonhead.chessplan.entity.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAO;

	@Override
	@Transactional
	public void saveGame(Game game) {
		game.setScore(game.getScore().replaceAll("\\s",""));
		gameDAO.saveGame(game);
	}

	@Override
	@Transactional
	public Set<Game> getGames() {
		Set<Game> games = new HashSet<Game>(gameDAO.getGames());
		return games;
	}

	@Override
	@Transactional
	public Game getGameById(int playerId) {
		return gameDAO.getGameById(playerId);
	}

}
