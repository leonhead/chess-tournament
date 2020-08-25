package com.leonhead.chessplan.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonhead.chessplan.doa.TournamentDAO;
import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;
import com.leonhead.chessplan.entity.Tournament;

@Service
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	private TournamentDAO tournamentDAO;

	@Override
	@Transactional
	public List<Tournament> getTournaments() {
		return tournamentDAO.getTournaments();
	}

	@Override
	@Transactional
	public Tournament getTournamentById(int tournamentId) {
		return tournamentDAO.getTournamentById(tournamentId);
	}

	@Override
	@Transactional
	public void saveTournament(Tournament tournament) {
		tournament.setRounds(null);
		tournamentDAO.saveTournament(tournament);
	}

	@Override
	@Transactional
	public Player addPlayer(int tournamentId, Player player) {
		return tournamentDAO.addPlayer(tournamentId, player);
	}

	@Override
	@Transactional
	public Player removePlayer(int tournamentId, Player player) {
		return tournamentDAO.removePlayer(tournamentId, player);
	}

	@Override
	@Transactional
	public Set<Player> getPlayers(int tournamentId) {
		return tournamentDAO.getPlayers(tournamentId);
	}

	@Override
	@Transactional
	public Set<Round> getRounds(int tournamentId) {
		return tournamentDAO.getRounds(tournamentId);
	}

	@Override
	@Transactional
	public Tournament findByRoundId(int roundId) {
		return tournamentDAO.findByRoundId(roundId);
	}

	@Override
	@Transactional
	public Round addRound(int tournamentId, Round round) {
		return tournamentDAO.addRound(tournamentId, round);
	}

}
