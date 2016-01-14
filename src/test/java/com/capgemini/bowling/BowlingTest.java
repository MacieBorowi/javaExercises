package com.capgemini.bowling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

	private BowlingGameResultCalculator player;

	@Before
	public void startNewGamePlayer(){
		
		this.player = new Bowling();
	
	}

	@Test
	public void sholundOneZero() {

		// given
		int[] hitedPins = { 0 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}

		// then
		int result = player.score();
		Assert.assertEquals(0, result);

	}

	@Test
	public void sholundOneFrameNormalHits() {

		// given
		int[] hitedPins = { 2, 2 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}

		// then
		int result = player.score();
		Assert.assertEquals(4, result);

	}

	@Test
	public void sholundTwoNormalFrames() {

		// given
		int[] hitedPins = { 2, 2, 2, 2 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}

		// then
		int result = player.score();
		Assert.assertEquals(8, result);

	}

	@Test
	public void sholundScoreAfter5NormalHits() {

		// given
		int[] hitedPins = { 0, 1, 2, 3, 4 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}

		// then
		int result = player.score();
		Assert.assertEquals(10, result);

	}

	@Test
	public void sholundSpareInFirstFrame() {

		// given
		int[] hitedPins = { 9, 1, 2, 3 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		int result = player.score();

		// then
		Assert.assertEquals(17, result);

	}
}
