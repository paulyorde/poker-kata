package logic;

import game.GameDisplay;
import player.Player;

public class ThreeOfAKind {

	public ThreeOfAKind() {}

	public static String determineFor(Player p1, Player p2, int i, int j, int k) {
		final int MAX_CARD_INDEX = 5;

		for (int card = i, nextCard = j, next = k; next < MAX_CARD_INDEX; card++, nextCard++, next++) {
			boolean playerOneHasThreeOfAKind = (p1.getHand().getCards().get(card).getValue() == p1.getHand().getCards().get(nextCard).getValue())
					&& (p1.getHand().getCards().get(nextCard).getValue() == p1.getHand().getCards().get(next).getValue());
			boolean playerTwoHasThreeOfAKind = (p2.getHand().getCards().get(card).getValue() == p2.getHand().getCards().get(nextCard).getValue())
					&& (p2.getHand().getCards().get(nextCard).getValue() == p2.getHand().getCards().get(next).getValue());;

			if (playerOneHasThreeOfAKind) {
				return GameDisplay.winnerWithThreeOfAKind(p1, card);
			} else if (playerTwoHasThreeOfAKind) {
				return GameDisplay.winnerWithThreeOfAKind(p2, card);
			} else if (playerOneHasThreeOfAKind && playerTwoHasThreeOfAKind) {
				
			} else {
				determineFor(p1, p2, i+1, j+1, k+1); // recursively look for pair
			}
		}
		return TwoPair.determineFor(p1, p2, 0, 1);
	}

}
