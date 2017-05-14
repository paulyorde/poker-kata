package logic;

import game.GameDisplay;
import player.Player;

public class HighestCard {

	private static final int MAX_CARD_INDEX = 4;
	//private static int beginningCardIndex;
	public HighestCard() {}

	public static String determineFor(Player p1, Player p2, int beginningCardIndex) {
		
		for (int card = beginningCardIndex; card < MAX_CARD_INDEX; card++) {
			int playerOneHighestCard = p1.getHand().getCards().get(card).getValue();
			int playerTwoHighestCard = p2.getHand().getCards().get(card).getValue();
			boolean playerOneCardIsHighest = playerOneHighestCard > playerTwoHighestCard;
			boolean playerTwoCardIsHighest = playerOneHighestCard < playerTwoHighestCard;
			
			if (playerOneCardIsHighest) {
				return GameDisplay.displayWinnerWithHighestCard(p1, card);
			} else if (playerTwoCardIsHighest) {
				return GameDisplay.displayWinnerWithHighestCard(p2, card);
			} else {
				determineFor(p1, p2, beginningCardIndex+1); // recursively look for highest card
			}
		}
		return GameDisplay.tie();
	}

}
