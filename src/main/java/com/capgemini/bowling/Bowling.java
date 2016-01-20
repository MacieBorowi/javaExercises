package com.capgemini.bowling;

import java.util.ArrayList;
import java.util.List;

public class Bowling implements BowlingGameResultCalculator {

	private int totalScore = 0;
	private boolean finished = false;
	private List<Frame> frameScoreList = new ArrayList<Frame>();

	public void roll(int numberOfPins) {
		if (frameScoreList.isEmpty() || frameScoreList.get(frameScoreList.size() - 1).isFinisched()) {
			frameScoreList.add(new Frame(numberOfPins));
		} else {
			frameScoreList.get(frameScoreList.size() - 1).setSecoundRoll(numberOfPins);
		}
		recountFrameScoreList();
		correctFinish();
	}

	public int score() {
		totalScore = 0;
		for (Frame thisFrame : frameScoreList) {
			totalScore += thisFrame.getScore() + thisFrame.getExtra();
		}
		return totalScore;
	}

	public boolean isFinished() {
		return finished;
	}

	private void recountFrameScoreList() {
		int lastRound = frameScoreList.size();
		for (int i = 0; i < lastRound; i++) {
			Frame thisFrame = frameScoreList.get(i);
			if (thisFrame.isSpare() && i < lastRound - 1) {
				thisFrame.setExtra(frameScoreList.get(i + 1).getFirstRoll());
			}
			if (thisFrame.isStrike() && i < lastRound - 1) {
				Frame nextFrame = frameScoreList.get(i + 1);
				thisFrame.setExtra(nextFrame.getScore());
				if (nextFrame.isStrike() && i < lastRound - 2) {
					thisFrame.setExtra(10 + frameScoreList.get(i + 2).getFirstRoll());
				}
			}
		}
	}

	private void correctFinish() {
		int lastRound = frameScoreList.size();
		if (lastRound >= 10) {
			Frame tenthRound = frameScoreList.get(9);
			if (tenthRound.isFinisched() && tenthRound.getScore() < 10) {
				finished = true;
			}
			if (lastRound == 11 && tenthRound.isSpare()) {
				tenthRound.setExtra(0);
				finished = true;
			}
			if (lastRound == 11 && frameScoreList.get(10).isFinisched() && !frameScoreList.get(10).isStrike()) {
				finished = true;
			}
			if (lastRound == 12) {
				tenthRound.setExtra(0);
				finished = true;
			}
			for (int i = 10; i < lastRound; i++) {
				frameScoreList.get(i).setExtra(0);
			}
		}
	}
}
