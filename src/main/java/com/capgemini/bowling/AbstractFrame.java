package com.capgemini.bowling;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFrame implements FrameInterface {

	protected List<Integer> rolls;
	protected AbstractFrame nextFrame;

	public AbstractFrame() {
		rolls = new ArrayList<Integer>();
		nextFrame = null;
	}

	public void addRoll(int roll) {
		if (!isFinished()) {
			this.rolls.add(roll);
		}
	}

	public int getScore() {
		int score = 0;
		for (Integer roll : rolls) {
			score += roll;
		}
		score += getExtra();
		return score;
	}

	public boolean isStrike() {
		return !rolls.isEmpty() && rolls.get(0) == 10;
	}

	public boolean isSpare() {
		int score = 0;
		for (Integer roll : rolls) {
			score += roll;
		}

		return score == 10 && rolls.size() == 2;
	}

	public int getOneThrow() {
		if (rolls.size() >= 1) {
			return rolls.get(0);
		}
		return 0;
	}

	public void setNextFrame(FrameInterface newFrame) {
		this.nextFrame = (AbstractFrame) newFrame;
	}

	abstract public int getExtra();

	abstract public boolean isFinished();

	abstract public int getSumOfTwoThrows();

}
