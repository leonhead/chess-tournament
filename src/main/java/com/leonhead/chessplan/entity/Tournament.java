package com.leonhead.chessplan.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tournament")
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "number_of_players")
	private int numberOfPlayers;

	@Column(name = "start_date")
	private Timestamp startDate;

	@Column(name = "end_date")
	private Timestamp endDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private TournamentType type = TournamentType.CLASSIC;

	@Enumerated(EnumType.STRING)
	@Column(name = "system")
	private TournamentSystem system = TournamentSystem.SWISS;

	@Embedded
	private Address address;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tournament", cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Round> rounds = new HashSet<Round>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "tournament_player", joinColumns = @JoinColumn(name = "tournament_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
	private Set<Player> players = new HashSet<Player>();

	public Tournament() {
	}

	public Tournament(String name, TournamentType type, TournamentSystem system, Address address) {
		this.name = name;
		this.type = type;
		this.system = system;
		this.address = address;
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

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public boolean addPlayer(Player player) {
		return this.players.add(player);
	}

	public boolean removePlayer(Player player) {
		return this.players.removeIf(e -> (player.getId() == e.getId()));
	}

	public int getParticipants() {
		if (getPlayers() == null) {
			return 0;
		}
		return getPlayers().size();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public TournamentType getType() {
		return type;
	}

	public void setType(TournamentType type) {
		this.type = type;
	}

	public TournamentSystem getSystem() {
		return system;
	}

	public void setSystem(TournamentSystem system) {
		this.system = system;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public Set<Round> getRounds() {
		return rounds;
	}

	public boolean addRound(Round round) {
		return this.rounds.add(round);
	}

	public void setRounds(Set<Round> rounds) {
		this.rounds = rounds;
	}

	@Override
	public String toString() {
		return "Tournament [name=" + name + ", numberOfPlayers=" + numberOfPlayers + ", type=" + type + ", system="
				+ system + "]";
	}

}
