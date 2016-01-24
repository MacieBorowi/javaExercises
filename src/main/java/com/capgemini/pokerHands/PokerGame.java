package com.capgemini.pokerHands;

public class PokerGame {

	private int playerOneWins;
	private InputDataProvider inputDataProvider;

	public void playGameFromFile() {
		playerOneWins = 0;
		inputDataProvider = new InputDataProvider();
		while (inputDataProvider.hasNext()) {
			Round round = new Round(inputDataProvider.getNext());
			if (round.isPlayerOneWins()) {
				playerOneWins++;
			}
		}
	}

	public void playOneRound(String oneRound) {
		playerOneWins = 0;
		Round round = new Round(oneRound);
		if (round.isPlayerOneWins()) {
			playerOneWins++;
		}
	}

	int getScore() {
		return playerOneWins;
	}

}
