package com.capgemini.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Bowling implements BowlingGameResultCalculator {

	private boolean finished = false;
	private int score = 0;
	private List<Integer> hitList = new ArrayList<Integer>(2);

	public void roll(int numberOfPins) {
		hitList.add(numberOfPins);
	}

	public int score() {

		ListIterator<Integer> iter = hitList.listIterator();

		while (iter.hasNext()) {
			
			int element = (Integer) iter.next();
			
			if(element==10){
	
			}
			else if(element==9){
	
			}
			
			scoreListUpdate();
			
			score += element;
		}

		return score;
	}

	public boolean isFinished() {
			return finished;
	}
	
	private void scoreListUpdate() {
		// TODO Auto-generated method stub
		
	}

}
