package com.leonhead.chessplan.doa;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Tournament;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Set<Player> getPlayers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Player> query = currentSession.createQuery("from Player order by name", Player.class);
		Set<Player> players = new HashSet<Player>(query.getResultList());
		return players;
	}

	@Override
	public Player getPlayerById(int playerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Player player = currentSession.get(Player.class, playerId);
		return player;
	}

	@Override
	public Set<Player> findByNameContaining(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Player> query = currentSession.createQuery("from Player p WHERE p.name LIKE CONCAT('%',?1,'%')",
				Player.class);
		query.setParameter(1, name);
		Set<Player> players = new HashSet<Player>(query.getResultList());
		return players;
	}

	@Override
	public Set<Player> findByTournamentId(int tournamentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Tournament tournament = currentSession.get(Tournament.class, tournamentId);
		return tournament.getPlayers();
	}

}
