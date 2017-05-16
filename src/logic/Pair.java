package logic;

import game.GameDisplay;
import game.GameRules;
import player.Player;

public class Pair {
	
	public Pair() {}

	public static String determineFor(Player p1, Player p2, int beginningCardIndex, int nextCardBeginningIndex, String handType) {
		final int MAX_CARD_INDEX = 4;
		String flag = handType;
		
		for (int card = beginningCardIndex, nextCard = nextCardBeginningIndex = 1; card < MAX_CARD_INDEX; card++, nextCard++) {
			boolean playerOneIsPair = p1.getHand().getCards().get(card).getValue() == p1.getHand().getCards().get(nextCard).getValue();
			boolean playerTwoIsPair = p2.getHand().getCards().get(card).getValue() == p2.getHand().getCards().get(nextCard).getValue();

			if(flag.equals("pair")) {
				 if(playerOneIsPair && playerTwoIsPair) {
					 return GameRules.findHighestCard(p1, p2);
				 }
				 if (playerOneIsPair) {
					return GameDisplay.displayWinnerWithPair(p1, card);
				} 
				else if (playerTwoIsPair) {
					return GameDisplay.displayWinnerWithPair(p2, card);
				}
			} 
			 if(flag.equals("fullhouse")) {
				if (playerOneIsPair) {
					FullHouse.p1pair = 1;
					return "";
				}
				else if (playerTwoIsPair) {
					FullHouse.p2pair = 2;
					return "";
				}
			} 
		    else {
				determineFor(p1, p2, beginningCardIndex+1, nextCardBeginningIndex+1, flag); // recursively look for pair
			}
		}
		return HighestCard.determineFor(p1, p2, 0); // if pair not found, look for highest card
	}

}
