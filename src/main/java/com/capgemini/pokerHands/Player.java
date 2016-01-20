package com.capgemini.pokerHands;

import java.util.ArrayList;

public class Player {

	private ArrayList<Integer> figures = new ArrayList<Integer>(5);
	private ArrayList<Integer> colours = new ArrayList<Integer>(5);

	public Player() {
	}

	public void setFigures(ArrayList<Integer> figures) {
		this.figures = figures;
	}

	public void setColours(ArrayList<Integer> colours) {
		this.colours = colours;
	}

	public ArrayList<Integer> getFigures() {
		return figures;
	}

	public ArrayList<Integer> getColours() {
		return colours;
	}

}
