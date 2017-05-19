package logic;

import java.util.List;  

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class FourOfAKind {

	public FourOfAKind() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		final int MAX_CARD_INDEX = 4;
		boolean playerOneHasFourOfAKind = false;
		boolean playerTwoHasFourOfAKind = false;
		
		for (int card = 0, nextCard = 1, next = 2, endingCard = 3; next < MAX_CARD_INDEX; card++, nextCard++, next++, endingCard++) {
			if(!playerOneHasFourOfAKind) {
				playerOneHasFourOfAKind = ((playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue())
					    && (playerOneHand.get(nextCard).getValue() == playerOneHand.get(next).getValue())
					    && (playerOneHand.get(next).getValue() == playerOneHand.get(endingCard).getValue()));
			}
			else if(!playerTwoHasFourOfAKind) {
				playerTwoHasFourOfAKind = (playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue())
						&& (playerTwoHand.get(nextCard).getValue() == playerTwoHand.get(next).getValue()
						&& (playerTwoHand.get(next).getValue() == playerTwoHand.get(endingCard).getValue()));
			}
			
			if(playerOneHasFourOfAKind && playerTwoHasFourOfAKind) {
				if(playerOneHand.get(next).getValue() > playerTwoHand.get(next).getValue()) {
					return GameDisplay.winnerWithFourOfAKind(Game.getPlayerOne());
				}
				else if(playerOneHand.get(next).getValue() < playerTwoHand.get(next).getValue()) {
					return GameDisplay.winnerWithFourOfAKind(Game.getPlayerTwo());
				}
			 } 
			else if(playerOneHasFourOfAKind) {
				return GameDisplay.winnerWithFourOfAKind(Game.getPlayerOne());
			} 
			else if(playerTwoHasFourOfAKind) {
				return GameDisplay.winnerWithFourOfAKind(Game.getPlayerTwo());
			}
		}
		
		return GameRules.findFullHouse(playerOneHand, playerTwoHand); // if four of kind not found - find full house
	}

}
