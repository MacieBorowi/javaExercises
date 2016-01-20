package com.capgemini.bowling;

public class Frame {

	private int firstRoll = 0;
	private int secoundRoll = 0;
	private int extra = 0;
	private boolean isFinisched = false;

	public Frame(int firstRoll) {
		this.firstRoll = firstRoll;
		if (firstRoll == 10) {
			isFinisched = true;
		}
	}

	public int getScore() {
		return firstRoll + secoundRoll;
	}

	public boolean isStrike() {
		return firstRoll == 10;
	}

	public boolean isSpare() {
		return firstRoll + secoundRoll == 10 && !this.isStrike();
	}

	public boolean isFinisched() {
		return isFinisched;
	}

	public int getFirstRoll() {
		return firstRoll;
	}

	public int getSecoundRoll() {
		return secoundRoll;
	}

	public void setSecoundRoll(int secoundRoll) {
		if (!isFinisched) {
			this.secoundRoll = secoundRoll;
		}
		isFinisched = true;
	}

	public int getExtra() {
		return extra;
	}

	public void setExtra(int extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "[" + firstRoll + "][" + secoundRoll + "][" + extra + "]";
	}

}
