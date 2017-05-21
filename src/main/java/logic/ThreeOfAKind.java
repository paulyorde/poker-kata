package logic;

import java.util.List; 

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class ThreeOfAKind {
	public ThreeOfAKind() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		boolean playerOneHasThreeOfAKind = false, playerTwoHasThreeOfAKind = false; 
		final int MAX_CARD_INDEX = 5;
		
		for (int card = 0, nextCard = 1, endCard = 2; endCard < MAX_CARD_INDEX; card++, nextCard++, endCard++) {
			playerOneHasThreeOfAKind = (playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue())
					&& (playerOneHand.get(nextCard).getValue() == playerOneHand.get(endCard).getValue());
			playerTwoHasThreeOfAKind = (playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue())
					&& (playerTwoHand.get(nextCard).getValue() == playerTwoHand.get(endCard).getValue());;

			if(playerOneHasThreeOfAKind) {
				return GameDisplay.winnerWithThreeOfAKind(Game.getPlayerOne(), card);
			} 
			else if(playerTwoHasThreeOfAKind) {
				return GameDisplay.winnerWithThreeOfAKind(Game.getPlayerTwo(), card);
			}
		}
		return GameRules.findPair(playerOneHand, playerTwoHand); // if three of kind not found - find two pair
	}

}
