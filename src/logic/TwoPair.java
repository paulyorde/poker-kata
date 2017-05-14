package logic;

import java.util.ArrayList;
import java.util.List;

import game.GameDisplay;
import player.Player;

public class TwoPair {
	
	public TwoPair() {}

	public static String determineFor(Player p1, Player p2, int beginningCardIndex, int nextCardBeginningIndex) {
		final int MAX_CARD_INDEX = 4;
		List<Integer> playerOneHighCardOfPair = new ArrayList<>();
		List<Integer> playerTwoHighCardOfPair = new ArrayList<>();
		int p1counter = 0;
		int p2counter = 0;

		for (int card = beginningCardIndex, nextCard = nextCardBeginningIndex = 1; card < MAX_CARD_INDEX; card++, nextCard++) {
			boolean playerOneIsPair = p1.getHand().getCards().get(card).getValue() == p1.getHand().getCards()
					.get(nextCard).getValue();
			boolean playerTwoIsPair = p2.getHand().getCards().get(card).getValue() == p2.getHand().getCards()
					.get(nextCard).getValue();

			if (playerOneIsPair) {
				playerOneHighCardOfPair.add(card);
				p1counter++;
			}
			if (playerTwoIsPair) {
				playerTwoHighCardOfPair.add(card);
				p2counter++;
			}
			if (p1counter == 2) {
				return GameDisplay.winnerWithTwoPair(p1, playerOneHighCardOfPair.get(0));
			} else if (p2counter == 2) {
				return GameDisplay.winnerWithTwoPair(p2, playerTwoHighCardOfPair.get(0));
			} else {
				determineFor(p1, p2, beginningCardIndex+1, nextCardBeginningIndex+1); // recursively look for two pair
			}
		}
		return Pair.determineFor(p1, p2, 0, 1); // if two pair not found look for pair
	}

}
