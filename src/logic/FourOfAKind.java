package logic;

import java.util.List; 

import game.Game;
import game.GameDisplay;
import gamePieces.Card;

public class FourOfAKind {

	public FourOfAKind() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand, int i, int j, int k, int l) {
		final int MAX_CARD_INDEX = 5;
		
		for (int card = i, nextCard = j, next = k, lastCard = l; lastCard < MAX_CARD_INDEX; card++, nextCard++, next++, lastCard++) {
			boolean playerOneHasFourOfAKind = (playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue())
					&& (playerOneHand.get(nextCard).getValue() == playerOneHand.get(next).getValue()
					&& (playerOneHand.get(next).getValue() == playerOneHand.get(lastCard).getValue()));
			boolean playerTwoHasFourOfAKind = (playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue())
					&& (playerTwoHand.get(nextCard).getValue() == playerTwoHand.get(next).getValue()
					&& (playerTwoHand.get(next).getValue() == playerTwoHand.get(lastCard).getValue()));

			if(playerOneHasFourOfAKind) {
				return GameDisplay.winnerWithFourOfAKind(Game.getPlayerOne(), card);
			} 
			else if(playerTwoHasFourOfAKind) {
				return GameDisplay.winnerWithFourOfAKind(Game.getPlayerTwo(), card);
			}
			else {
				determineFor(playerOneHand, playerTwoHand, i+1, j+1, k+1, l+1); // recursively look for three of kind
			}
		}
		return FullHouse.determineFor(playerOneHand, playerTwoHand); // if four of kind not found - find full house
	}

}
