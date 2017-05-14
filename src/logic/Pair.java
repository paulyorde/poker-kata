package logic;

import game.GameDisplay;
import player.Player;

public class Pair {

	public Pair() {}

	public static String determineFor(Player p1, Player p2, int beginningCardIndex, int nextCardBeginningIndex) {
		final int MAX_CARD_INDEX = 4;

		for (int card = beginningCardIndex, nextCard = nextCardBeginningIndex = 1; card < MAX_CARD_INDEX; card++, nextCard++) {
			boolean playerOneIsPair = p1.getHand().getCards().get(card).getValue() == p1.getHand().getCards().get(nextCard).getValue();
			boolean playerTwoIsPair = p2.getHand().getCards().get(card).getValue() == p2.getHand().getCards().get(nextCard).getValue();

			if (playerOneIsPair) {
				return GameDisplay.displayWinnerWithPair(p1, card);
			} else if (playerTwoIsPair) {
				return GameDisplay.displayWinnerWithPair(p2, card);
			} else if (playerOneIsPair && playerTwoIsPair) {
				// find which player has highest card if pairs are the same
				// test case
				// high cards below the pair
				// need to check next highest card after the pairs
				// remove pairs from hands and check for highest card OR change the beginning index accordingly
				//return HighestCard.determineFor(p1, p2, 0);
				
				// test case
				// high cards above the pairs
				
				// this may only work if bools can be checked outside the loop
				
				
				// possibly else if !pair and !pair recurese
				
				 // then check if both are pairs with else 
				
				
			} else {
				determineFor(p1, p2, beginningCardIndex+1, nextCardBeginningIndex+1); // recursively look for pair
			}
		}
		return HighestCard.determineFor(p1, p2, 0);
	}

}
