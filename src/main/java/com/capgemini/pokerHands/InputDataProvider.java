package com.capgemini.pokerHands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InputDataProvider {

	private List<String> roundList;
	private int iter;

	public InputDataProvider() {
		roundList = new LinkedList<String>();
		iter = 0;
		readHandsFile();
	}

	private void readHandsFile() {
		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader("src//main//java//com//capgemini//pokerHands//poker.txt"))) {

			List<String> textList = new ArrayList<>();
			String textLine = bufferedReader.readLine();
			while (textLine != null) {
				textList.add(textLine);
				textLine = bufferedReader.readLine();
			}
			roundList.addAll(textList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean hasNext() {
		return iter + 1 < roundList.size();
	}

	public String getNext() {
		if (this.hasNext()) {
			iter++;
		}
		return roundList.get(iter);
	}

}
