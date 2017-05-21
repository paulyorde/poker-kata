package logic;

import java.util.List; 

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class Straight {

	public Straight() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand, HandTypeMarker handType) {
		int algebraicConstant = 1; // ex. x - 1 = 12
		int firstCard = 0, secondCard = 1, thirdCard =  2, fourthCard = 3, fifthCard =  4;
		
		// check that each consecutive card is one less than the previous
		boolean playerOneHasStraight = ((playerOneHand.get(firstCard).getValue() - algebraicConstant == playerOneHand.get(secondCard).getValue())
				&& (playerOneHand.get(secondCard).getValue() - algebraicConstant == playerOneHand.get(thirdCard).getValue())
				&& (playerOneHand.get(thirdCard).getValue() - algebraicConstant == playerOneHand.get(fourthCard).getValue())
				&& (playerOneHand.get(fourthCard).getValue() - algebraicConstant == playerOneHand.get(fifthCard).getValue()));
		boolean playerTwoHasStraight = ((playerTwoHand.get(firstCard).getValue() - algebraicConstant == playerTwoHand.get(secondCard).getValue())
				&& (playerTwoHand.get(secondCard).getValue() - algebraicConstant == playerTwoHand.get(thirdCard).getValue())
				&& (playerTwoHand.get(thirdCard).getValue() - algebraicConstant == playerTwoHand.get(fourthCard).getValue())
				&& (playerTwoHand.get(fourthCard).getValue() - algebraicConstant == playerTwoHand.get(fifthCard).getValue()));
		
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
		else if(handType.equals(HandTypeMarker.STRAIGHT_FLUSH)) { // set straight boolean for straight flush
			if (playerOneHasStraight && playerTwoHasStraight) {
				StraightFlush.setPlayerOneStraight(true);
				StraightFlush.setPlayerTwoStraight(true);
			} 
			else if(playerOneHasStraight) {
				StraightFlush.setPlayerOneStraight(true);
			}
			else if(playerTwoHasStraight) {
				StraightFlush.setPlayerTwoStraight(true);
			}
			
		}
		return GameRules.findThreeOfAKind(playerOneHand, playerTwoHand); // if straight not found - find three of a kind
	}

}
