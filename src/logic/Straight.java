package logic;

import game.GameDisplay;
import game.GameRules;
import player.Player;

public class Straight {

	public Straight() {}

	public static String determineFor(Player p1, Player p2) {
		int card = 0;
		// make recursive / could have a hand already available 
		boolean playerOneHasStraight = (p1.getHand().getCards().get(card).getValue()-1 == p1.getHand().getCards().get(card+1).getValue())
				&& (p1.getHand().getCards().get(card+1).getValue()-1 == p1.getHand().getCards().get(card+2).getValue())
				&& (p1.getHand().getCards().get(card+2).getValue()-1 == p1.getHand().getCards().get(card+3).getValue())
				&& (p1.getHand().getCards().get(card+3).getValue()-1 == p1.getHand().getCards().get(card+4).getValue());
		boolean playerTwoHasStraight = (p2.getHand().getCards().get(card).getValue()-1 == p2.getHand().getCards().get(card+1).getValue())
				&& (p2.getHand().getCards().get(card+1).getValue()-1 == p2.getHand().getCards().get(card+2).getValue())
				&& (p2.getHand().getCards().get(card+2).getValue()-1 == p2.getHand().getCards().get(card+3).getValue())
				&& (p2.getHand().getCards().get(card+3).getValue()-1 == p2.getHand().getCards().get(card+4).getValue());
		
		// make generic method 
		if(playerOneHasStraight && playerTwoHasStraight) {
			return GameRules.findHighestCard(p1, p2);
		}
		if (playerOneHasStraight) {
			return GameDisplay.winnerWithStraight(p1);
		} else if (playerTwoHasStraight) {
			return GameDisplay.winnerWithStraight(p2);
		} else if (playerOneHasStraight && playerTwoHasStraight) {
			
		} 
		return ThreeOfAKind.determineFor(p1, p2, 0, 1, 2, "three of a kind"); // if three of kind not found - find two pair
	}

}
