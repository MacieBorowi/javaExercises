package com.capgemini.gameOfLife;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {

	private GameOfLife Game;

	@Before
	public void doBeforeClass() {
		Game = new GameOfLife();
	}

	@Test
	public void shouldExpireOnePoint() {

		// given
		Set<Point> startBoard = new HashSet<Point>();
		int genetation = 1;
		startBoard.add(new Point(5, 5));

		// when
		Game.createStartBoard(startBoard);
		Game.genarationToWait(genetation);
		Set<Point> resultBoard = Game.getLivingCells();

		// then
		Assert.assertTrue(resultBoard.isEmpty());

	}

	@Test
	public void shouldSurviveOnePointWithTwoNeigbours() {

		// given
		Set<Point> startBoard = new HashSet<Point>();
		int genetation = 1;
		startBoard.add(new Point(4, 4));
		startBoard.add(new Point(5, 5));
		startBoard.add(new Point(6, 6));

		// when
		Game.createStartBoard(startBoard);
		Game.genarationToWait(genetation);
		Set<Point> resultBoard = Game.getLivingCells();

		// then
		Set<Point> finalBoard = new HashSet<Point>();
		finalBoard.add(new Point(5, 5));
		Assert.assertEquals(finalBoard, resultBoard);

	}

	@Test
	public void shouldSurviveOnePointWithThreeNeigbours() {

		// given
		Set<Point> startBoard = new HashSet<Point>();
		int genetation = 1;
		startBoard.add(new Point(4, 4));
		startBoard.add(new Point(5, 5));
		startBoard.add(new Point(6, 6));
		startBoard.add(new Point(5, 6));

		// when
		Game.createStartBoard(startBoard);
		Game.genarationToWait(genetation);
		Set<Point> resultBoard = Game.getLivingCells();

		// then
		Assert.assertTrue(resultBoard.contains(new Point(5, 5)));

	}

	@Test
	public void oneExpireFromOvercrowded() {
		// given
		Set<Point> startBoard = new HashSet<Point>();
		int genetation = 1;
		startBoard.add(new Point(6, 4));
		startBoard.add(new Point(6, 5));
		startBoard.add(new Point(6, 6));
		startBoard.add(new Point(5, 4));
		startBoard.add(new Point(5, 5));

		// when
		Game.createStartBoard(startBoard);
		Game.genarationToWait(genetation);
		Set<Point> resultBoard = Game.getLivingCells();

		// then
		Assert.assertFalse(resultBoard.contains(new Point(5, 5)));

	}

	@Test
	public void oneResurection() {
		// given
		Set<Point> startBoard = new HashSet<Point>();
		int genetation = 1;
		startBoard.add(new Point(4, 5));
		startBoard.add(new Point(5, 5));
		startBoard.add(new Point(5, 6));

		// when
		Game.createStartBoard(startBoard);
		Game.genarationToWait(genetation);
		Set<Point> resultBoard = Game.getLivingCells();

		// then
		Set<Point> finalBoard = new HashSet<Point>();
		finalBoard.add(new Point(4, 5));
		finalBoard.add(new Point(5, 5));
		finalBoard.add(new Point(5, 6));
		finalBoard.add(new Point(4, 6));
		Assert.assertEquals(finalBoard, resultBoard);

	}

}
