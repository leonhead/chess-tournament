package com.leonhead.chessplan.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;
import com.leonhead.chessplan.entity.Tournament;
import com.leonhead.chessplan.exceptions.EntityDuplicateException;

@Repository
public class TournamentDAOImpl implements TournamentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tournament> getTournaments() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Tournament> theQuery = currentSession.createQuery("from Tournament", Tournament.class);
		List<Tournament> tournaments = theQuery.getResultList();
		return tournaments;
	}

	@Override
	public Tournament getTournamentById(int tournamentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Tournament tournament = currentSession.get(Tournament.class, tournamentId);
		return tournament;
	}

	@Override
	public void saveTournament(Tournament tournament) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(tournament);
	}

	@Override
	public Player addPlayer(int tournamentId, Player player) {
		Session currentSession = sessionFactory.getCurrentSession();
		Tournament tournament = currentSession.get(Tournament.class, tournamentId);
		List<Integer> playerIds = tournament.getPlayers().stream().map(Player::getId).collect(Collectors.toList());
		if (playerIds.contains(player.getId())) {
			throw new EntityDuplicateException("Player already exists in tournament");
		}
		tournament.addPlayer(player);
		currentSession.saveOrUpdate(tournament);
		return player;
	}

	@Override
	public Player removePlayer(int tournamentId, Player player) {
		Session currentSession = sessionFactory.getCurrentSession();
		Tournament tournament = currentSession.get(Tournament.class, tournamentId);
		tournament.removePlayer(player);
		currentSession.saveOrUpdate(tournament);
		return player;
	}

	@Override
	public Set<Player> getPlayers(int tournamentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Tournament tournament = currentSession.get(Tournament.class, tournamentId);
		return tournament.getPlayers();
	}

	@Override
	public Set<Round> getRounds(int tournamentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Tournament tournament = currentSession.get(Tournament.class, tournamentId);
		return tournament.getRounds();
	}

	@Override
	public Tournament findByRoundId(int roundId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Round> query = currentSession.createQuery("from Round WHERE id LIKE ?1", Round.class);
		query.setParameter(1, roundId);
		Round round = query.getSingleResult();
		Tournament tournament = Optional.of(round.getTournament()).orElse(null);
		return tournament;
	}

	@Override
	public Round addRound(int tournamentId, Round round) {
		Session currentSession = sessionFactory.getCurrentSession();
		Tournament tournament = currentSession.get(Tournament.class, tournamentId);
		round.setTournament(tournament);
		tournament.addRound(round);
		currentSession.merge(tournament);
		return round;
	}

}
