package com.capgemini.bowling;

public class Frame extends AbstractFrame {

	public Frame() {
		super();
	}

	public int getExtra() {
		int extra = 0;
		if (this.isSpare() && nextFrame != null) {
			extra = nextFrame.getOneThrow();
		}

		if (this.isStrike() && nextFrame != null) {
			extra = nextFrame.getSumOfTwoThrows();
		}
		return extra;
	}

	public boolean isFinished() {
		return rolls.size() == 2 || (rolls.size() == 1 && this.rolls.get(0) == 10);
	}

	public int getSumOfTwoThrows() {
		int sumOfRoll = 0;
		if (rolls.size() == 1 && nextFrame != null) {
			sumOfRoll = rolls.get(0) + nextFrame.getOneThrow();
		}
		if (rolls.size() == 2) {
			sumOfRoll = rolls.get(0) + rolls.get(1);
		}
		return sumOfRoll;
	}

}
