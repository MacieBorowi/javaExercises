package com.capgemini.gameOfLife;

import java.util.HashSet;
import java.util.Set;

public class GameOfLife {

	private Set<Point> cellSet = new HashSet<Point>();

	public void createStartBoard(Set<Point> newSetOfCells) {
		cellSet = newSetOfCells;
		// cellSet.clear();
		// cellSet.addAll(newSetOfCells);
	}

	public Set<Point> getLivingCells() {
		return cellSet;
	}

	public void genarationToWait(int generationCounter) {
		for (int i = 0; i < generationCounter; i++) {
			lifeOneGeneration();
		}
	}

	private void lifeOneGeneration() {
		Set<Point> newGenerationCellSet = new HashSet<Point>();
		survive(newGenerationCellSet);
		resurectNeighbours(newGenerationCellSet);
		cellSet = newGenerationCellSet;
	}

	private void survive(Set<Point> newGenerationCellSet) {
		for (Point thisCell : cellSet) {
			int neighbours = countNeigbours(thisCell);
			if (neighbours > 1 && neighbours < 4) {
				newGenerationCellSet.add(thisCell);
			}
		}
	}

	private int countNeigbours(Point thisCell) {
		int neighbours = 0;
		for (Point theNeighbour : thisCell.getPointNeigbours()) {
			if (cellSet.contains(theNeighbour)) {
				neighbours++;
			}
		}
		return neighbours;
	}

	private void resurectNeighbours(Set<Point> newGenerationCellSet) {
		Set<Point> couldResurect = new HashSet<Point>();
		for (Point thisCell : cellSet) {
			couldResurect.addAll(thisCell.getPointNeigbours());
		}
		couldResurect.removeAll(cellSet);
		for (Point thisCell : couldResurect) {
			if (countNeigbours(thisCell) == 3) {
				newGenerationCellSet.add(thisCell);
			}
		}
	}
}
