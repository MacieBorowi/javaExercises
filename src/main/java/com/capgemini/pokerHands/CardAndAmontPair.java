package com.capgemini.pokerHands;

public class CardAndAmontPair {

	private int figure;
	private int amount;

	public CardAndAmontPair(int figure, int amount) {
		this.figure = figure;
		this.amount = amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getFigure() {
		return figure;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "[" + figure + "," + amount + "]";
	}

}
