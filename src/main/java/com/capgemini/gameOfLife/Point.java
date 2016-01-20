package com.capgemini.gameOfLife;

import java.util.HashSet;
import java.util.Set;

public class Point {

	private Integer positionX;
	private Integer positionY;

	public Point(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Set<Point> getPointNeigbours() {
		Set<Point> tempSet = new HashSet<Point>();
		for (int i = positionX - 1; i <= positionX + 1; i++) {
			for (int j = positionY - 1; j <= positionY + 1; j++) {
				Point tempPoint = new Point(i, j);
				if (!this.equals(tempPoint)) {
					tempSet.add(tempPoint);
				}
			}
		}
		return tempSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + positionX;
		result = prime * result + positionY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (positionX != other.positionX)
			return false;
		if (positionY != other.positionY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return positionX + " " + positionY;
	}

}
