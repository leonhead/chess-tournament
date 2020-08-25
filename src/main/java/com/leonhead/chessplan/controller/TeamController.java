package com.leonhead.chessplan.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonhead.chessplan.entity.Team;
import com.leonhead.chessplan.exceptions.EntityNotFoundException;
import com.leonhead.chessplan.service.TeamService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping("/teams")
	public List<Team> getTeams() {
		return teamService.getTeams();
	}

	@GetMapping("/teams/{teamId}")
	public Team getTeamById(@PathVariable int teamId) {
		Team team = teamService.getTeamById(teamId);
		if (team == null) {
			throw new EntityNotFoundException("Team not found for id - " + teamId);
		}
		return team;
	}

	@GetMapping("/teams/search/findByNameContaining")
	public Set<Team> getTeamsByName(@RequestParam String name) {
		return teamService.findByNameContaining(name);
	}

}
