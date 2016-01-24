package com.capgemini.bowling;

public class LastFrame extends AbstractFrame {

	public LastFrame() {
		super();
	}

	public int getExtra() {
		return 0;
	}

	public boolean isFinished() {
		return rolls.size() == 3 || (rolls.size() == 2 && this.getScore() < 10);
	}

	public int getSumOfTwoThrows() {
		int sumOfRoll = 0;
		if (rolls.size() == 1) {
			sumOfRoll = rolls.get(0);
		}
		if (rolls.size() >= 2) {
			sumOfRoll = rolls.get(0) + rolls.get(1);
		}
		return sumOfRoll;
	}
}
