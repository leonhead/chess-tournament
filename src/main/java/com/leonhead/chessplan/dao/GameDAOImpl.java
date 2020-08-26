package com.leonhead.chessplan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leonhead.chessplan.entity.Game;

@Repository
public class GameDAOImpl implements GameDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveGame(Game game) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(game);
	}

	@Override
	public List<Game> getGames() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Game> query = currentSession.createQuery("from Game", Game.class);

		List<Game> games = query.getResultList();
		return games;
	}

	@Override
	public Game getGameById(int playerId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Game game = currentSession.get(Game.class, playerId);
		return game;
	}

}
