package logic;

import java.util.List;

import game.Game;
import game.GameDisplay;
import gamePieces.Card;

public class HighestCard {

	
	public HighestCard() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand, int beginningCardIndex) {
		final int MAX_CARD_INDEX = 4;
		for (int card = beginningCardIndex; card < MAX_CARD_INDEX; card++) {
			int playerOneHighestCard = playerOneHand.get(card).getValue();
			int playerTwoHighestCard = playerTwoHand.get(card).getValue();
			boolean playerOneCardIsHighest = playerOneHighestCard > playerTwoHighestCard;
			boolean playerTwoCardIsHighest = playerOneHighestCard < playerTwoHighestCard;
			
			if (playerOneCardIsHighest && playerTwoCardIsHighest) {
				return GameDisplay.tie();
			}
			else if (playerOneCardIsHighest) {
				return GameDisplay.winnerWithHighestCard(Game.getPlayerOne(), card);
			} 
			else if (playerTwoCardIsHighest) {
				return GameDisplay.winnerWithHighestCard(Game.getPlayerTwo(), card);
			} 
			else {
				determineFor(playerOneHand, playerTwoHand, beginningCardIndex+1); // recursively look for highest card
			}
		}
		return GameDisplay.tie();
	}

}
