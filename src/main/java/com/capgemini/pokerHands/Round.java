package com.capgemini.pokerHands;

import java.util.List;

public class Round {

	private Hand playerOneHand;
	private Hand playerTwoHand;

	public Round(String inputLine) {
		CardsParser parseCard = new CardsParser(inputLine);
		playerOneHand = parseCard.getFirstHand();
		playerTwoHand = parseCard.getSecoundHand();
	}

	public boolean isPlayerOneWins() {
		Ranking.rankPlayer(playerOneHand);
		Ranking.rankPlayer(playerTwoHand);
		boolean winner = false;
		if (playerOneHand.getRank() == playerTwoHand.getRank()) {
			winner = drowRankChooser(playerOneHand, playerTwoHand);
		}
		if (playerOneHand.getRank() > playerTwoHand.getRank()) {
			winner = true;
		}
		return winner;
	}

	private boolean drowRankChooser(Hand playerOneHand, Hand playerTwoHand) {
		int maximalOne = 0;
		int maximalTwo = 0;
		int rank = playerOneHand.getRank();
		if (rank == 1 || rank == 5 || rank == 6 || rank == 9) {
			maximalOne = getMaximumFigure(playerOneHand);
			maximalTwo = getMaximumFigure(playerTwoHand);
		}
		if (rank == 2 || rank == 4 || rank == 7 || rank == 8) {
			maximalOne = getPopularFigure(playerOneHand);
			maximalTwo = getPopularFigure(playerTwoHand);
		}
		if (rank == 3) {
			maximalOne = twoPairMaximum(playerOneHand);
			maximalTwo = twoPairMaximum(playerTwoHand);
		}

		return maximalOne > maximalTwo;
	}

	private int getMaximumFigure(Hand playerHand) {
		int maximal = 0;
		for (CardAndAmontPair cardAmount : playerHand.getList()) {
			int temp = cardAmount.getFigure();
			if (temp > maximal) {
				maximal = temp;
			}
		}
		return maximal;
	}

	private int getPopularFigure(Hand playerHand) {
		List<CardAndAmontPair> listOfCards = playerHand.getList();
		int temp = 0;
		if (playerHand.getRank() == 8) {
			temp = getMaximumInMany(listOfCards, 4); // FOUR_OF_A_KIND
		}
		if (playerHand.getRank() == 4 || playerOneHand.getRank() == 7) {
			temp = getMaximumInMany(listOfCards, 3); // THREE_CARDS_OF_THE_SAME_VALUE
			// , FULL_HOUSE
		}
		if (playerHand.getRank() == 2) {
			temp = getMaximumInMany(listOfCards, 2);
		}
		return temp;
	}

	private int getMaximumInMany(List<CardAndAmontPair> listOfCards, int howMany) {
		int figure = 0;
		for (CardAndAmontPair c : listOfCards) {
			if (c.getAmount() == howMany) {
				figure = c.getFigure();
			}
		}
		return figure;
	}

	private int twoPairMaximum(Hand playerOneHand) {
		int figure = 0;
		for (CardAndAmontPair c : playerOneHand.getList()) {
			if (c.getAmount() == 2) {
				if (c.getFigure() > figure) {
					figure = c.getFigure();
				}
			}
		}
		return figure;
	}

}
