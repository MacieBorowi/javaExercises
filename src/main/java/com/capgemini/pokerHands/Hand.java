package com.capgemini.pokerHands;

import java.util.List;

public class Hand {

	private int rank = 0;
	boolean color = false;
	List<CardAndAmontPair> cardsList;

	public Hand(List<CardAndAmontPair> playerOneSet) {
		this.cardsList = (List<CardAndAmontPair>) playerOneSet;
	}

	public List<CardAndAmontPair> getList() {
		return cardsList;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public boolean getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "rank=" + rank + ", color=" + color + ",List=" + cardsList.get(0).toString() + " |"
				+ cardsList.get(1).toString() + " |" + cardsList.get(2).toString() + " |" + cardsList.get(3).toString()
				+ " |" + cardsList.get(4).toString() + " |";
	}

}
