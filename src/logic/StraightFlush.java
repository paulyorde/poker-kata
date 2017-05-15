package logic;

import game.GameDisplay;
import player.Player;

public class StraightFlush {

	public StraightFlush() {}

	public static String determineFor(Player p1, Player p2) {
		boolean playerOneStraightFlag = false;
		boolean playerTwoStraightFlag = false;
		boolean playerOneFlushFlag    = false;
		boolean playerTwoFlushFlag    = false;
		int card = 0;
		
		// find straight
		boolean playerOneHasStraight = (p1.getHand().getCards().get(card).getValue()-1 == p1.getHand().getCards().get(card+1).getValue())
				&& (p1.getHand().getCards().get(card+1).getValue()-1 == p1.getHand().getCards().get(card+2).getValue())
				&& (p1.getHand().getCards().get(card+2).getValue()-1 == p1.getHand().getCards().get(card+3).getValue())
				&& (p1.getHand().getCards().get(card+3).getValue()-1 == p1.getHand().getCards().get(card+4).getValue());
		boolean playerTwoHasStraight = (p2.getHand().getCards().get(card).getValue()-1 == p2.getHand().getCards().get(card+1).getValue())
				&& (p2.getHand().getCards().get(card+1).getValue()-1 == p2.getHand().getCards().get(card+2).getValue())
				&& (p2.getHand().getCards().get(card+2).getValue()-1 == p2.getHand().getCards().get(card+3).getValue())
				&& (p2.getHand().getCards().get(card+3).getValue()-1 == p2.getHand().getCards().get(card+4).getValue());

		if (playerOneHasStraight) {
			playerOneStraightFlag = true;
		} else if (playerTwoHasStraight) {
			playerTwoStraightFlag = true;
		} else if (playerOneHasStraight && playerTwoHasStraight) {
			// check highest card send to display to show strait with higest card/ pass in higest card
		} 
		
		// check for flush
		boolean playerOneHasFlush = (p1.getHand().getCards().get(card).getSuit() == p1.getHand().getCards().get(card+1).getSuit())
				&& (p1.getHand().getCards().get(card+1).getSuit() == p1.getHand().getCards().get(card+2).getSuit())
				&& (p1.getHand().getCards().get(card+2).getSuit() == p1.getHand().getCards().get(card+3).getSuit())
				&& (p1.getHand().getCards().get(card+3).getSuit() == p1.getHand().getCards().get(card+4).getSuit());
		boolean playerTwoHasFlush = (p2.getHand().getCards().get(card).getSuit() == p2.getHand().getCards().get(card+1).getSuit())
				&& (p2.getHand().getCards().get(card+1).getSuit() == p2.getHand().getCards().get(card+2).getSuit())
				&& (p2.getHand().getCards().get(card+2).getSuit() == p2.getHand().getCards().get(card+3).getSuit())
				&& (p2.getHand().getCards().get(card+3).getSuit() == p2.getHand().getCards().get(card+4).getSuit());

		if (playerOneHasFlush) {
			playerOneFlushFlag = true;
		} else if (playerTwoHasFlush) {
			playerTwoFlushFlag = true;
		} 
		if (playerOneHasFlush && playerTwoHasFlush) {
			HighestCard.determineFor(p1, p2, 0);
		} 
		
		if(playerOneStraightFlag && playerOneFlushFlag) {
			return GameDisplay.winnerWithStraightFlush(p1);
		} else if(playerTwoStraightFlag && playerTwoFlushFlag) {
			return GameDisplay.winnerWithStraightFlush(p2);
		}
		
		
		return FourOfAKind.determineFor(p1, p2, 0, 1, 2, 3); // if straight flush not found - find four of a kind
	}

}
