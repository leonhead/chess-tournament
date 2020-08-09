package com.leonhead.chesstournament.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Embedded
	private Rating rating;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "team_id")
	private Team team;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "tournament_player", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "tournament_id"))
	private List<Tournament> tournaments = new ArrayList<Tournament>();

	@OneToMany(mappedBy = "whitePlayer", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Game> whiteGames = new ArrayList<>();

	@OneToMany(mappedBy = "blackPlayer", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Game> blackGames = new ArrayList<>();

	public Player() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getTeamName() {
		if (this.team == null) {
			return "No teams found";
		}
		return this.team.getName();
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public List<Game> getWhiteGames() {
		return whiteGames;
	}

	public void setWhiteGames(List<Game> whiteGames) {
		this.whiteGames = whiteGames;
	}

	public List<Game> getBlackGames() {
		return blackGames;
	}

	public void setBlackGames(List<Game> blackGames) {
		this.blackGames = blackGames;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", rating=" + rating + ", team=" + team + "]";
	}

}
