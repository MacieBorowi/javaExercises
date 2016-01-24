package com.capgemini.bowling;

import java.util.ArrayList;
import java.util.List;

public class Bowling implements BowlingGameResultCalculator {

	private int totalScore = 0;
	private boolean finished = false;
	private List<FrameInterface> frameScoreList = new ArrayList<FrameInterface>();

	public Bowling() {
	}

	public void roll(int numberOfPins) {
		if (frameScoreList.isEmpty()) {
			Frame firstFrame = (Frame) RoundFactory.getRoundObject(0);
			firstFrame.addRoll(0);
			firstFrame.addRoll(0);
			frameScoreList.add(firstFrame);
		}
		FrameInterface correntFrame = getCurrentRound();
		if (correntFrame.isFinished()) {
			FrameInterface newFrame = RoundFactory.getRoundObject(frameScoreList.size());
			newFrame.addRoll(numberOfPins);
			correntFrame.setNextFrame(newFrame);
			frameScoreList.add(newFrame);
		} else {
			correntFrame.addRoll(numberOfPins);
		}
	}

	public int score() {
		totalScore = 0;
		for (FrameInterface oneFrame : frameScoreList) {
			totalScore += oneFrame.getScore();
		}
		return totalScore;
	}

	private FrameInterface getCurrentRound() {
		return frameScoreList.get(frameScoreList.size() - 1);
	}

	public boolean isFinished() {
		if (frameScoreList.size() == 11) {
			finished = frameScoreList.get(10).isFinished();
		}
		return finished;
	}
}
