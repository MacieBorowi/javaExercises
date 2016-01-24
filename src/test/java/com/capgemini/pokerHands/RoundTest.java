package com.capgemini.pokerHands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoundTest {

	private PokerGame game;

	@Before
	public void startNewGamePlayer() {

		this.game = new PokerGame();

	}

	@Test
	public void sholundColorCard() {

		// given
		String playerCards = "8C TC KC AC 4C 7D 2S 5D 3S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundOneHighCard() {

		// given
		String playerCards = "8C TS KC AH 4S 7D 2S 5D 3S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundLostWithOneHighCardVSPair() {

		// given
		String playerCards = "8C TS KC AH 4S 7D 2S 5D 9S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(0, result);

	}

}
