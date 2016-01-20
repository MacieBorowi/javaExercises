package com.capgemini.pokerHands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardsParser {

	public ArrayList<Player> readPlayersCards() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/poker.txt"))) {
			ArrayList<Player> PlayerList = new ArrayList<Player>();

			String textLine = bufferedReader.readLine();
			while (textLine != null) {
				String[] allCards = textLine.split(" ");
				for (int i = 0; i < 2; i++) {
					Player thisPlayer = new Player();
					PlayerList.add(thisPlayer);
					ArrayList<Integer> onePlayerCards = new ArrayList<Integer>();
					for (int j = 0; j < 5; j++) {
						onePlayerCards.add(Character.getNumericValue(allCards[i * j].charAt(0)));
						onePlayerCards.add(Character.getNumericValue(allCards[i * j].charAt(1)));
					}
					thisPlayer.setFigures(onePlayerCards);
				}
				textLine = bufferedReader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
