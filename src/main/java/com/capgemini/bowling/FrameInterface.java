package com.capgemini.bowling;

public interface FrameInterface {

	public void setNextFrame(FrameInterface f);

	public void addRoll(int r);

	public int getScore();

	public boolean isFinished();

	public int getOneThrow();

	public int getSumOfTwoThrows();

}
