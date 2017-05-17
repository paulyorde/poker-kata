package logic;

import java.util.List;

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class Pair {
	
	public Pair() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand, int beginningCardIndex, int nextCardBeginningIndex, HandTypeMarker handType) {
		boolean playerOneIsPair = false;
		boolean playerTwoIsPair = false;
		final int MAX_CARD_INDEX = 4;
		
		for (int card = beginningCardIndex, nextCard = nextCardBeginningIndex = 1; card < MAX_CARD_INDEX; card++, nextCard++) {
			playerOneIsPair = playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue();
			playerTwoIsPair = playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue();

			if(handType.equals(HandTypeMarker.PAIR)) {
				 if(playerOneIsPair && playerTwoIsPair) {
					 return GameRules.findHighestCard(playerOneHand, playerTwoHand);
				 }
				 if (playerOneIsPair) {
					return GameDisplay.winnerWithPair(Game.getPlayerOne(), card);
				} 
				else if (playerTwoIsPair) {
					return GameDisplay.winnerWithPair(Game.getPlayerTwo(), card);
				}
			} 
			else if(handType.equals(HandTypeMarker.FULL_HOUSE)) {
				if (playerOneIsPair) {
					FullHouse.setPlayerOneHasPair(true);
					return "";
				}
				else if (playerTwoIsPair) {
					FullHouse.setPlayerTwoHasPair(true);
					return "";
				}
			} 
		    else {
				determineFor(playerOneHand, playerTwoHand, beginningCardIndex+1, nextCardBeginningIndex+1, handType); // recursively look for pair
			}
		}
		return GameRules.findHighestCard(playerOneHand, playerTwoHand); // if pair not found, look for highest card
	}

}
