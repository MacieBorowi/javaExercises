package com.capgemini.bowling;

public class RoundFactory {

	public static FrameInterface getRoundObject(int frameNumber) {
		if (frameNumber == 10) {
			return new LastFrame();
		}
		return new Frame();
	}

}
