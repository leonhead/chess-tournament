package com.leonhead.chessplan.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonhead.chessplan.doa.PlayerDAO;
import com.leonhead.chessplan.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDAO;

	@Override
	@Transactional
	public Set<Player> getPlayers() {
		return playerDAO.getPlayers();
	}

	@Override
	@Transactional
	public Player getPlayerById(int playerId) {
		return playerDAO.getPlayerById(playerId);
	}

	@Override
	@Transactional
	public Set<Player> findByNameContaining(String name) {
		return playerDAO.findByNameContaining(name);
	}

	@Override
	@Transactional
	public Set<Player> findByTournamentId(int tournamentId) {
		return playerDAO.findByTournamentId(tournamentId);
	}

}
