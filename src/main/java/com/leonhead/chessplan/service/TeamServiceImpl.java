package com.leonhead.chessplan.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonhead.chessplan.dao.TeamDAO;
import com.leonhead.chessplan.entity.Team;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDAO teamDAO;

	@Override
	@Transactional
	public List<Team> getTeams() {
		return teamDAO.getTeams();
	}

	@Override
	@Transactional
	public Team getTeamById(int teamId) {
		return teamDAO.getTeamById(teamId);
	}

	@Override
	@Transactional
	public Set<Team> findByNameContaining(String name) {
		return teamDAO.findByNameContaining(name);
	}

}
