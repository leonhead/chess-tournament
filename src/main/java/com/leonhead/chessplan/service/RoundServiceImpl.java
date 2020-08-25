package com.leonhead.chessplan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonhead.chessplan.doa.RoundDAO;
import com.leonhead.chessplan.entity.Game;
import com.leonhead.chessplan.entity.Player;
import com.leonhead.chessplan.entity.Round;

@Service
public class RoundServiceImpl implements RoundService {

	@Autowired
	private RoundDAO roundDAO;

	@Override
	@Transactional
	public List<Round> getRounds() {
		return roundDAO.getRounds();
	}

	@Override
	@Transactional
	public Round getRoundById(int roundId) {
		return roundDAO.getRoundById(roundId);
	}

	@Override
	@Transactional
	public Set<Game> getGamesById(int roundId) {
		return roundDAO.getGamesById(roundId);
	}

	@Override
	@Transactional
	public void createGames(int roundId) {
		Set<Player> players = roundDAO.getPlayers(roundId);
		List<Player> targetPlayers = new ArrayList<>(players);

		int midIndex = (targetPlayers.size() - 1) / 2;
		List<List<Player>> lists = new ArrayList<>(targetPlayers.stream()
				.collect(Collectors.partitioningBy(s -> targetPlayers.indexOf(s) > midIndex)).values());

		roundDAO.createGames(lists.get(0), lists.get(1), roundId);
	}

	@Override
	public Set<Player> getPlayers(int roundId) {
		return roundDAO.getPlayers(roundId);
	}

}
