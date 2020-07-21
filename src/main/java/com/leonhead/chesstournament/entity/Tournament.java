package com.leonhead.chesstournament.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tournament")
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@NotBlank
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

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "tournament_player", joinColumns = @JoinColumn(name = "tournament_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
	private List<Player> players = new ArrayList<Player>();;

	public Tournament() {
	}

	public Tournament(@NotBlank String name, TournamentType type, TournamentSystem system, Address address) {
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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getParticipants() {
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

	@Override
	public String toString() {
		return "Tournament [name=" + name + ", numberOfPlayers=" + numberOfPlayers + ", type=" + type + ", system="
				+ system + "]";
	}

}
