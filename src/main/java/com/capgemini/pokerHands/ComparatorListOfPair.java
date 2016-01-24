package com.capgemini.pokerHands;

public class ComparatorListOfPair implements java.util.Comparator<CardAndAmontPair> {

	public int compare(CardAndAmontPair card1, CardAndAmontPair card2) {
		if (card1.getFigure() > card2.getFigure())
			return -1;
		else if (card1.getFigure() < card2.getFigure()) {
			return 1;
		}
		return 0;
	}
}
