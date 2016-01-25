package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsParser {

	private Hand firstHand;
	private Hand secoundHand;

	public CardsParser(String inputLine) {
		List<String> playerOneCards = getCardsSet(inputLine.substring(0, inputLine.length() / 2));
		List<String> playerTwoCards = getCardsSet(inputLine.substring((inputLine.length() / 2) + 1));

		List<CardAndAmontPair> playerOneSet = groupCards(playerOneCards);
		List<CardAndAmontPair> playerTwoSet = groupCards(playerTwoCards);

		firstHand = new Hand(playerOneSet);
		secoundHand = new Hand(playerTwoSet);
		firstHand.setColor(isFirstColor(playerOneCards));
		secoundHand.setColor(isSecoundColor(playerTwoCards));
	}

	private List<String> getCardsSet(String Cards) {
		String[] cardsTable = Cards.split(" ");
		List<String> playerCards = new ArrayList<String>();
		for (int i = 0; i < cardsTable.length; i++) {
			String tempFigure = cardsTable[i].substring(0, 1);
			String tempColore = cardsTable[i].substring(1);
			playerCards.add(tempFigure);
			playerCards.add(tempColore);
		}
		return playerCards;
	}

	private List<CardAndAmontPair> groupCards(List<String> playerCards) {
		List<CardAndAmontPair> groupedList = new ArrayList<>();
		groupedList.add(new CardAndAmontPair(changeNames(playerCards, 0), 1));

		for (int i = 2; i < playerCards.size(); i += 2) {
			int figure = changeNames(playerCards, i);
			boolean added = false;
			for (int j = 0; j < groupedList.size(); j++) {
				CardAndAmontPair thePair = groupedList.get(j);
				if (thePair.getFigure() == figure) {
					thePair.setAmount(thePair.getAmount() + 1);
					added = true;
				}
			}
			if (!added) {
				groupedList.add(new CardAndAmontPair(figure, 1));
			}
		}
		Collections.sort(groupedList, new ComparatorListOfPair());
		return new ArrayList<CardAndAmontPair>(groupedList);
	}

	public Hand getFirstHand() {
		return firstHand;
	}

	public Hand getSecoundHand() {
		return secoundHand;
	}

	private boolean isFirstColor(List<String> playerOneCards) {
		String color = playerOneCards.get(1);

		return color.equals(playerOneCards.get(3)) && color.equals(playerOneCards.get(5))
				&& color.equals(playerOneCards.get(7)) && color.equals(playerOneCards.get(9));
	}

	private boolean isSecoundColor(List<String> playerTwoCards) {
		String color = playerTwoCards.get(1);

		return color.equals(playerTwoCards.get(3)) && color.equals(playerTwoCards.get(5))
				&& color.equals(playerTwoCards.get(7)) && color.equals(playerTwoCards.get(9));
	}

	private int changeNames(List<String> playerCards, int i) {
		int temp = 0;
		try {
			temp = Integer.parseInt(playerCards.get(i));
		} catch (Exception e) {
			if (playerCards.get(i).equals("T")) {
				temp = 10;
			}
			if (playerCards.get(i).equals("J")) {
				temp = 11;
			}
			if (playerCards.get(i).equals("Q")) {
				temp = 12;
			}
			if (playerCards.get(i).equals("K")) {
				temp = 13;
			}
			if (playerCards.get(i).equals("A")) {
				temp = 14;
			}
			if (playerCards.get(i).equals("S")) {
				temp = 1;
			}
			if (playerCards.get(i).equals("H")) {
				temp = 2;
			}
			if (playerCards.get(i).equals("D")) {
				temp = 3;
			}
			if (playerCards.get(i).equals("C")) {
				temp = 4;
			}
			playerCards.set(i, String.valueOf(temp));
		}
		return temp;
	}
}
