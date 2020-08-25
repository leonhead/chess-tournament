package com.leonhead.chessplan.doa;

import java.util.List;
import java.util.Set;

import com.leonhead.chessplan.entity.Team;

public interface TeamDAO {
	
	public List<Team> getTeams();

	public Team getTeamById(int teamId);

	public Set<Team> findByNameContaining(String name);

}
