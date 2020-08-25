package com.leonhead.chessplan.doa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leonhead.chessplan.entity.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Team> getTeams() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Team> theQuery = currentSession.createQuery("from Team order by name", Team.class);

		List<Team> teams = theQuery.getResultList();
		return teams;
	}

	@Override
	public Team getTeamById(int teamId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Team team = currentSession.get(Team.class, teamId);
		return team;
	}

	@Override
	public Set<Team> findByNameContaining(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Team> query = currentSession.createQuery("from Team p WHERE p.name LIKE CONCAT('%',?1,'%')", Team.class);
		query.setParameter(1, name);
		Set<Team> teams = new HashSet<Team>(query.getResultList());
		return teams;
	}

}
