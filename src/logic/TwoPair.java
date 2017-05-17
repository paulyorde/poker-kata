package logic;

import java.util.ArrayList; 
import java.util.List;

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class TwoPair {
	
	

	public TwoPair() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand, int beginningCardIndex, int nextCardBeginningIndex) {
		final int MAX_CARD_INDEX = 4;
		List<Integer> playerOneCardsForDisplay = new ArrayList<>();
		List<Integer> playerTwoCardsForDisplay = new ArrayList<>();
		int playerOneCounter = 0;
		int playerTwoCounter = 0;
		final int TWO_PAIR = 2;
		boolean playerOneHasTwoPair = playerOneCounter == TWO_PAIR;
		boolean playerTwoHasTwoPair = playerTwoCounter == TWO_PAIR;

		for (int card = beginningCardIndex, nextCard = nextCardBeginningIndex; card < MAX_CARD_INDEX; card++, nextCard++) {
			boolean playerOneHasPair = playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue();
			boolean playerTwoHasPair = playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue();
			
			// find and count each set of pairs
			if (playerOneHasPair) {
				playerOneCardsForDisplay.add(card);
				playerOneCardsForDisplay.add(nextCard);
				playerOneCounter++;
			}
			else if (playerTwoHasPair) {
				playerTwoCardsForDisplay.add(card);
				playerTwoCardsForDisplay.add(nextCard);
				playerTwoCounter++;
			}
			
			// return winner, if any
			if (playerOneHasTwoPair && playerTwoHasTwoPair) {
				return GameRules.findHighestCard(playerOneHand, playerTwoHand);
			}
			else if (playerOneHasTwoPair) {
				return GameDisplay.winnerWithTwoPair(Game.getPlayerOne(), playerOneCardsForDisplay);
			} 
			else if (playerTwoHasTwoPair) {
					return GameDisplay.winnerWithTwoPair(Game.getPlayerTwo(), playerTwoCardsForDisplay);
			} 
			else {
				determineFor(playerOneHand, playerTwoHand, beginningCardIndex+1, nextCardBeginningIndex+1); // recursively look for two pair
			}
		}
		
		return GameRules.findPair(playerOneHand, playerTwoHand, HandTypeMarker.PAIR); // if two pair not found look for pair
	}

}
