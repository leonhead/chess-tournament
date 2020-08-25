package com.leonhead.chessplan.doa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leonhead.chessplan.entity.Game;
import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;
import com.leonhead.chessplan.entity.Tournament;

@Repository
public class RoundDAOImpl implements RoundDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Round> getRounds() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Round> theQuery = currentSession.createQuery("from Round", Round.class);
		List<Round> rounds = theQuery.getResultList();
		return rounds;
	}

	@Override
	public Round getRoundById(int roundId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Round round = currentSession.get(Round.class, roundId);
		return round;
	}

	@Override
	public Set<Game> getGamesById(int roundId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Round round = currentSession.get(Round.class, roundId);
		Set<Game> games = new HashSet<Game>(round.getGames());
		return games;
	}

	@Override
	public void createGames(List<Player> whitePlayers, List<Player> blackPlayers, int roundId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Round round = currentSession.get(Round.class, roundId);
		round.getGames().clear();

		Iterator<Player> whitePlayerIter = whitePlayers.iterator();
		Iterator<Player> blackPlayerIter = blackPlayers.iterator();

		int boardNumber = 1;
		while (whitePlayerIter.hasNext() && blackPlayerIter.hasNext()) {
			Game game = new Game();
			game.setRound(round);
			game.setScore("0-0");
			game.setWhitePlayer(whitePlayerIter.next());
			game.setBlackPlayer(blackPlayerIter.next());
			game.setBoardNumber(boardNumber++);
			round.getGames().add(game);
		}
		currentSession.persist(round.getTournament());
	}

	@Override
	public Set<Player> getPlayers(int roundId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Round round = currentSession.get(Round.class, roundId);
		Tournament tournament = round.getTournament();
		return tournament.getPlayers();
	}

}
