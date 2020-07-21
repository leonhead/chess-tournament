package com.leonhead.chesstournament.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Rating {

	@Column(name = "elo")
	private int elo;

	public Rating() {
	}

	public Rating(int elo) {
		this.elo = elo;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	@Override
	public String toString() {
		return "Rating [elo=" + elo + "]";
	}

}
