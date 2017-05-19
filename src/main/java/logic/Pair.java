package logic;

import java.util.List;

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class Pair {
	
	public Pair() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		boolean playerOneIsPair = false;
		boolean playerTwoIsPair = false;
		final int MAX_CARD_INDEX = 4;
	
		for (int card = 0, nextCard = 1; card < MAX_CARD_INDEX; card++, nextCard++) {
			playerOneIsPair = (playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue());
			playerTwoIsPair = (playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue());
			
			if(playerOneIsPair && playerTwoIsPair) {
				 return GameRules.findHighestCard(playerOneHand, playerTwoHand);
			 }
			 else if (playerOneIsPair) {
				return GameDisplay.winnerWithPair(Game.getPlayerOne(), card);
			} 
			else if (playerTwoIsPair) {
				return GameDisplay.winnerWithPair(Game.getPlayerTwo(), card);
			}
		}
		
		return GameRules.findHighestCard(playerOneHand, playerTwoHand); // if pair not found, look for highest card
	}
}
