package logic;

import game.GameDisplay;
import player.Player;

public class FourOfAKind {

	public FourOfAKind() {}

	public static String determineFor(Player p1, Player p2, int i, int j, int k, int l) {
		final int MAX_CARD_INDEX = 5;
		
		for (int card = i, nextCard = j, next = k, lastCard = l; lastCard < MAX_CARD_INDEX; card++, nextCard++, next++, lastCard++) {
			boolean playerOneHasFourOfAKind = (p1.getHand().getCards().get(card).getValue() == p1.getHand().getCards().get(nextCard).getValue())
					&& (p1.getHand().getCards().get(nextCard).getValue() == p1.getHand().getCards().get(next).getValue()
					&& (p1.getHand().getCards().get(next).getValue() == p1.getHand().getCards().get(lastCard).getValue()));
			boolean playerTwoHasFourOfAKind = (p2.getHand().getCards().get(card).getValue() == p2.getHand().getCards().get(nextCard).getValue())
					&& (p2.getHand().getCards().get(nextCard).getValue() == p2.getHand().getCards().get(next).getValue()
					&& (p2.getHand().getCards().get(next).getValue() == p2.getHand().getCards().get(lastCard).getValue()));

			if(playerOneHasFourOfAKind) {
				return GameDisplay.winnerWithFourOfAKind(p1, card);
			} 
			else if(playerTwoHasFourOfAKind) {
				return GameDisplay.winnerWithFourOfAKind(p2, card);
			}
			else {
				determineFor(p1, p2, i+1, j+1, k+1, l+1); // recursively look for three of kind
			}
		}
		return FullHouse.determineFor(p1, p2); // if four of kind not found - find full house
	}

}
