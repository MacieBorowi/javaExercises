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
	public void sholundLostWithOneHighCardVSPair() {

		// given
		String playerCards = "8C TS KC AH 4S 7D 2S 5D 9S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(0, result);

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
	public void sholundTwoPairs() {

		// given
		String playerCards = "8C 8S KC KH 4S 7D 2S 5D 8S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundThreeKind() {

		// given
		String playerCards = "8C 8S 8C KH 4S 7D 2S 5D 8S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundStrit() {

		// given
		String playerCards = "3C 4S 5C 6H 2S 7D 2S 5D 8S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundFlusch() {

		// given
		String playerCards = "8C TC KC AC 4C 7D 2S 5D 3S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundFull() {

		// given
		String playerCards = "3C 3S 3C 6H 6S 7D 2S 5D 8S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundFourKind() {

		// given
		String playerCards = "3C 3S 3C 3H 6S 7D 2S 5D 8S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundPoker() {

		// given
		String playerCards = "4C 5C 6C 7C 8C 7D 2S 5D 8S 9C";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundStreightWinInPlayOff() {

		// given
		String playerCards = "6D 7C 8D 5C 9C 7D 5D 6H 8D 4D";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundFourKindWinInPlayOff() {

		// given
		String playerCards = "9C 9C 9D 9C 2H 5D 5D 5H 5D 9D";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

	@Test
	public void sholundTwoPairsWinInPlayOff() {

		// given
		String playerCards = "9C 9C 6D 6C 8C 7D 5D 5H 8D 8D";

		// when
		game.playOneRound(playerCards);
		int result = game.getScore();

		// then
		Assert.assertEquals(1, result);

	}

}
