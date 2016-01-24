package com.capgemini.pokerHands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InputDataProvider {

	private List<String> roundList;
	private Iterator<String> iter;

	public InputDataProvider() {
		roundList = new LinkedList<String>();
		iter = roundList.iterator();
		readHandsFile();
	}

	private void readHandsFile() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/poker.txt"))) {

			String textLine = bufferedReader.readLine();
			while (textLine != null) {
				roundList.add(textLine);
				textLine = bufferedReader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean hasNext() {
		return iter.hasNext();
	}

	public String getNext() {
		return iter.next();
	}

}
