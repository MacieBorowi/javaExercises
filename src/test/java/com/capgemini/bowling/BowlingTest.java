package com.capgemini.bowling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

	private BowlingGameResultCalculator player;

	@Before
	public void startNewGamePlayer() {

		this.player = new Bowling();

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

	@Test
	public void sholundStrikeInFirstFrame() {

		// given
		int[] hitedPins = { 10, 5, 4 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		int score = player.score();

		// then
		Assert.assertEquals(28, score);

	}

	@Test
	public void sholundSpareAndStrike() {

		// given
		int[] hitedPins = { 3, 7, 10, 1, 1 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		int score = player.score();

		// then
		Assert.assertEquals(34, score);

	}

	@Test
	public void sholundStrikeAndSpare() {

		// given
		int[] hitedPins = { 10, 3, 7, 3, 3 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		int score = player.score();

		// then
		Assert.assertEquals(39, score);

	}

	@Test
	public void sholundTenStrikesInRow() {

		// given
		int[] hitedPins = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }; // 10times

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		int score = player.score();

		// then
		Assert.assertEquals(270, score);

	}

	@Test
	public void shouldAllNormal() {

		// given
		int singleHit = 4;
		int howManyTimes = 20;

		// when
		for (int i = 0; i < howManyTimes; i++) {
			player.roll(singleHit);
		}
		int score = player.score();

		// then
		Assert.assertEquals(80, score);

	}

	@Test
	public void sholundNormalEnding() {

		// given
		int[] hitedPins = { 10, 10, 10, 10, 10, 10, 10, 10, 10 }; // 9times

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		player.roll(2);
		player.roll(2);
		int score = player.score();

		// then
		Assert.assertEquals(250, score);
		Assert.assertTrue(player.isFinished());

	}

	@Test
	public void shouldAllStrike() {

		// given
		int hit = 10;

		// when
		for (int i = 0; i < 12; i++) {
			player.roll(hit);
		}
		int score = player.score();

		// then
		Assert.assertEquals(300, score);
		Assert.assertTrue(player.isFinished());

	}

	@Test
	public void sholundSpareEnding() {

		// given
		int[] hitedPins = { 10, 10, 10, 10, 10, 10, 10, 10, 10 }; // 9times
		int[] hitedPins2 = { 5, 5, 2 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		for (int oneRoll : hitedPins2) {
			player.roll(oneRoll);
		}
		int score = player.score();

		// then
		Assert.assertEquals(267, score);
		Assert.assertTrue(player.isFinished());

	}

	@Test
	public void sholundStrikeEndingNormal() {

		// given
		int[] hitedPins = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }; // 10times
		int[] hitedPins2 = { 2, 2 };

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		for (int oneRoll : hitedPins2) {
			player.roll(oneRoll);
		}
		int score = player.score();

		// then
		Assert.assertEquals(276, score);
		Assert.assertTrue(player.isFinished());

	}

	@Test
	public void sholundStrikeEndingStrike() {

		// given
		int[] hitedPins = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }; // 11times
		int hit = 2;

		// when
		for (int oneRoll : hitedPins) {
			player.roll(oneRoll);
		}
		player.roll(hit);
		int score = player.score();

		// then
		Assert.assertEquals(292, score);
		Assert.assertTrue(player.isFinished());

	}

}
