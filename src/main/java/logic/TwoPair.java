package logic;

import java.util.ArrayList; 
import java.util.List;

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class TwoPair {

	public TwoPair() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		final int MAX_CARD_INDEX = 4;
		boolean playerOneHasTwoPair = false, playerTwoHasTwoPair = false;
		List<Integer> playerOneCardsForDisplay = new ArrayList<>();
		List<Integer> playerTwoCardsForDisplay = new ArrayList<>();

		for (int card = 0, nextCard = 1, next = 2, endCard = 3; next < MAX_CARD_INDEX; card++, nextCard++, next++, endCard++) {
			playerOneHasTwoPair = ((playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue())
					&& (playerOneHand.get(next).getValue() == playerOneHand.get(endCard).getValue()));
			playerTwoHasTwoPair = (playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue())
					&& (playerTwoHand.get(next).getValue() == playerTwoHand.get(endCard).getValue());

			if (playerOneHasTwoPair && playerTwoHasTwoPair) {
				return GameRules.findHighestCard(playerOneHand, playerTwoHand);
			}
			else if (playerOneHasTwoPair) {
				playerOneCardsForDisplay.add(card);
				playerOneCardsForDisplay.add(next);
				return GameDisplay.winnerWithTwoPair(Game.getPlayerOne(), playerOneCardsForDisplay);
			} 
			else if (playerTwoHasTwoPair) {
				playerTwoCardsForDisplay.add(card);
				playerTwoCardsForDisplay.add(next);
				return GameDisplay.winnerWithTwoPair(Game.getPlayerTwo(), playerTwoCardsForDisplay);
			} 
		}
		
		return GameRules.findPair(playerOneHand, playerTwoHand); // if two pair not found look for pair
	}

}
