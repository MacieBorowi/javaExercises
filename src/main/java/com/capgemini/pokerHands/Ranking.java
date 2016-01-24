package com.capgemini.pokerHands;

public class Ranking {

	public static void rankPlayer(Hand playerHand) {
		boolean singleFigure = true;
		for (CardAndAmontPair cardAmount : playerHand.getList()) {
			if (cardAmount.getAmount() > 1) {
				singleFigure = false;
			}
		}

		if (singleFigure) {
			allSingleCardsOnHand(playerHand);
		} else {
			fewSameFigures(playerHand);
		}
	}

	public static void allSingleCardsOnHand(Hand playerHand) {
		int rank = 1;
		boolean allContinious = continuousFigures(playerHand);

		if (allContinious && playerHand.getColor()) {
			rank = 9; // POKER
		}
		if (allContinious && !playerHand.getColor()) {
			rank = 5; // STRAIGHT
		}
		if (!allContinious && playerHand.getColor()) {
			rank = 6; // FLUSCH
		}
		playerHand.setRank(rank);
	}

	private static boolean continuousFigures(Hand playerHand) {
		boolean noGap = true;
		int previousFigure = playerHand.getList().get(0).getFigure();
		for (int i = 1; i < playerHand.getList().size(); i++) {
			int thisFigure = playerHand.getList().get(i).getFigure();
			if (previousFigure != thisFigure + 1) {
				noGap = false;
				i = playerHand.getList().size();
			}
			previousFigure = thisFigure;
		}
		return noGap;
	}

	private static void fewSameFigures(Hand playerHand) {
		int maximal = 0;
		int rank = 1;

		for (CardAndAmontPair cardAmount : playerHand.getList()) {
			int temp = cardAmount.getAmount();
			if (temp > maximal) {
				maximal = temp;
			}
		}
		if (maximal == 4) {
			rank = 8; // FOUR_OF_A_KIND
		}
		if (maximal == 3) {
			rank = 4; // THREE_CARDS_OF_THE_SAME_VALUE
			if (isItFull(playerHand)) {
				rank = 7; // FULL_HOUSE
			}
		}
		if (maximal == 2) {
			rank = 2; // ONE_PAIR
			if (isItTwoPairs(playerHand)) {
				rank = 3; // TWO_PAIRS
			}
		}
		playerHand.setRank(rank);

	}

	private static boolean isItFull(Hand playerHand) {
		for (CardAndAmontPair cardAmount : playerHand.getList()) {
			int temp = cardAmount.getAmount();
			if (temp == 2) {
				return true;
			}
		}
		return false;
	}

	private static boolean isItTwoPairs(Hand playerHand) {
		int counter = 0;
		for (CardAndAmontPair cardAmount : playerHand.getList()) {
			int temp = cardAmount.getAmount();
			if (temp == 2) {
				counter++;
			}
		}
		return counter == 2;
	}
}
