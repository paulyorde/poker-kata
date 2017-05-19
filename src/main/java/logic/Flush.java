package logic;

import java.util.List;

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class Flush {

	public Flush() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand, HandTypeMarker handType) {
		int card = 0;
		
		boolean playerOneHasFlush = (playerOneHand.get(card).getSuit() == playerOneHand.get(card+1).getSuit())
				&& (playerOneHand.get(card+1).getSuit() == playerOneHand.get(card+2).getSuit())
				&& (playerOneHand.get(card+2).getSuit() == playerOneHand.get(card+3).getSuit())
				&& (playerOneHand.get(card+3).getSuit() == playerOneHand.get(card+4).getSuit());
		boolean playerTwoHasFlush = (playerTwoHand.get(card).getSuit() == playerTwoHand.get(card+1).getSuit())
				&& (playerTwoHand.get(card+1).getSuit() == playerTwoHand.get(card+2).getSuit())
				&& (playerTwoHand.get(card+2).getSuit() == playerTwoHand.get(card+3).getSuit())
				&& (playerTwoHand.get(card+3).getSuit() == playerTwoHand.get(card+4).getSuit());

		if(handType.equals(HandTypeMarker.FLUSH)) { 
			if (playerOneHasFlush && playerTwoHasFlush) {
				return GameRules.findHighestCard(playerOneHand, playerTwoHand);
			}
			else if (playerOneHasFlush) {
				return GameDisplay.winnerWithFlush(Game.getPlayerOne());
			} 
			else if (playerTwoHasFlush) {
				return GameDisplay.winnerWithFlush(Game.getPlayerTwo());
			} 
		}
		else if(handType.equals(HandTypeMarker.STRAIGHT_FLUSH)) {
			if (playerOneHasFlush) {
				StraightFlush.setPlayerOneFlush(true);
				return "";
			} 
			else if (playerTwoHasFlush) {
				StraightFlush.setPlayerTwoFlush(true);
				return "";
			}
			
		}
		return Straight.determineFor(playerOneHand, playerTwoHand, HandTypeMarker.STRAIGHT); // if flush not found - find straight
	}

}
