package logic;

import game.GameDisplay;
import game.GameRules;
import player.Player;

public class Flush {

	public Flush() {}

	public static String determineFor(Player p1, Player p2) {
		int card = 0;
		
		boolean playerOneHasFlush = (p1.getHand().getCards().get(card).getSuit() == p1.getHand().getCards().get(card+1).getSuit())
				&& (p1.getHand().getCards().get(card+1).getSuit() == p1.getHand().getCards().get(card+2).getSuit())
				&& (p1.getHand().getCards().get(card+2).getSuit() == p1.getHand().getCards().get(card+3).getSuit())
				&& (p1.getHand().getCards().get(card+3).getSuit() == p1.getHand().getCards().get(card+4).getSuit());
		boolean playerTwoHasFlush = (p2.getHand().getCards().get(card).getSuit() == p2.getHand().getCards().get(card+1).getSuit())
				&& (p2.getHand().getCards().get(card+1).getSuit() == p2.getHand().getCards().get(card+2).getSuit())
				&& (p2.getHand().getCards().get(card+2).getSuit() == p2.getHand().getCards().get(card+3).getSuit())
				&& (p2.getHand().getCards().get(card+3).getSuit() == p2.getHand().getCards().get(card+4).getSuit());

		if (playerOneHasFlush && playerTwoHasFlush) {
			return GameRules.findHighestCard(p1, p2);
		}
		else if (playerOneHasFlush) {
			return GameDisplay.winnerWithFlush(p1);
		} 
		else if (playerTwoHasFlush) {
			return GameDisplay.winnerWithFlush(p2);
		} 
		return Straight.determineFor(p1, p2); // if flush not found - find straight
	}

}
