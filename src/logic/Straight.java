package logic;

import java.util.List; 

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class Straight {

	public Straight() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand, HandTypeMarker handType) {
		int card = 0;

		boolean playerOneHasStraight = (playerOneHand.get(card).getValue()-1 == playerOneHand.get(card+1).getValue())
				&& (playerOneHand.get(card+1).getValue()-1 == playerOneHand.get(card+2).getValue())
				&& (playerOneHand.get(card+2).getValue()-1 == playerOneHand.get(card+3).getValue())
				&& (playerOneHand.get(card+3).getValue()-1 == playerOneHand.get(card+4).getValue());
		boolean playerTwoHasStraight = (playerTwoHand.get(card).getValue()-1 == playerTwoHand.get(card+1).getValue())
				&& (playerTwoHand.get(card+1).getValue()-1 == playerTwoHand.get(card+2).getValue())
				&& (playerTwoHand.get(card+2).getValue()-1 == playerTwoHand.get(card+3).getValue())
				&& (playerTwoHand.get(card+3).getValue()-1 == playerTwoHand.get(card+4).getValue());
		
		if(handType.equals(HandTypeMarker.STRAIGHT)) {
			if(playerOneHasStraight && playerTwoHasStraight) {
				return GameRules.findHighestCard(playerOneHand, playerTwoHand);
			}
			else if (playerOneHasStraight) {
				return GameDisplay.winnerWithStraight(Game.getPlayerOne());
			} 
			else if (playerTwoHasStraight) {
				return GameDisplay.winnerWithStraight(Game.getPlayerTwo());
			} 
		} 
		else if(handType.equals(HandTypeMarker.STRAIGHT_FLUSH)) {
			if (playerOneHasStraight && playerTwoHasStraight) {
				StraightFlush.setPlayerOneStraight(true);
				StraightFlush.setPlayerTwoStraight(true);
			} 
			else if(playerOneHasStraight) {
				StraightFlush.setPlayerOneStraight(true);
				return "";
			}
			else if(playerTwoHasStraight) {
				StraightFlush.setPlayerTwoStraight(true);
				return "";
			}
			
		}
		return GameRules.findThreeOfAKind(playerOneHand, playerTwoHand, HandTypeMarker.THREE_OF_A_KIND); // if three of kind not found - find two pair
	}

}
