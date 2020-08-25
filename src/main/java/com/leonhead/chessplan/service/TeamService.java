package com.leonhead.chessplan.service;

import java.util.List;
import java.util.Set;

import com.leonhead.chessplan.entity.Team;

public interface TeamService {

	public List<Team> getTeams();

	public Team getTeamById(int playerId);

	public Set<Team> findByNameContaining(String name);
}
