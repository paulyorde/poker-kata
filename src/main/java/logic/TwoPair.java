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
		List<Integer> playerOneCardsForDisplay = new ArrayList<>();
		List<Integer> playerTwoCardsForDisplay = new ArrayList<>();

		for (int card = 0, nextCard = 1, i = 2, j = 3; i < MAX_CARD_INDEX; card++, nextCard++, i++, j++) {
			boolean playerOneHasTwoPair = ((playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue())
					&& (playerOneHand.get(i).getValue() == playerOneHand.get(j).getValue()));
			boolean playerTwoHasTwoPair = (playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue())
					&& (playerTwoHand.get(i).getValue() == playerTwoHand.get(j).getValue());

			if (playerOneHasTwoPair && playerTwoHasTwoPair) {
				return GameRules.findHighestCard(playerOneHand, playerTwoHand);
			}
			else if (playerOneHasTwoPair) {
				playerOneCardsForDisplay.add(card);
				playerOneCardsForDisplay.add(i);
				return GameDisplay.winnerWithTwoPair(Game.getPlayerOne(), playerOneCardsForDisplay);
			} 
			else if (playerTwoHasTwoPair) {
				playerTwoCardsForDisplay.add(card);
				playerTwoCardsForDisplay.add(i);
				return GameDisplay.winnerWithTwoPair(Game.getPlayerTwo(), playerTwoCardsForDisplay);
			} 
		}
		
		return GameRules.findPair(playerOneHand, playerTwoHand); // if two pair not found look for pair
	}

}
