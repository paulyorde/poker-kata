package logic;

import java.util.List;

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class Flush {

	public Flush() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand, HandTypeMarker handType) {
		int firstCard = 0, secondCard = 1, thirdCard =  2, fourthCard = 3, fifthCard =  4;
		
		boolean playerOneHasFlush = ((playerOneHand.get(firstCard).getSuit() == playerOneHand.get(secondCard).getSuit())
				&& (playerOneHand.get(secondCard).getSuit() == playerOneHand.get(thirdCard).getSuit())
				&& (playerOneHand.get(thirdCard).getSuit() == playerOneHand.get(fourthCard).getSuit())
				&& (playerOneHand.get(fourthCard).getSuit() == playerOneHand.get(fifthCard).getSuit()));
		boolean playerTwoHasFlush = ((playerTwoHand.get(firstCard).getSuit() == playerTwoHand.get(secondCard).getSuit())
				&& (playerTwoHand.get(secondCard).getSuit() == playerTwoHand.get(thirdCard).getSuit())
				&& (playerTwoHand.get(thirdCard).getSuit() == playerTwoHand.get(fourthCard).getSuit())
				&& (playerTwoHand.get(fourthCard).getSuit() == playerTwoHand.get(fifthCard).getSuit()));

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
