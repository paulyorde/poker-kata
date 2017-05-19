package logic;

import java.util.List;

import game.Game;
import game.GameDisplay;
import gamePieces.Card;

public class HighestCard {

	
	public HighestCard() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		final int MAX_CARD_INDEX = 4;
		for (int card = 0; card < MAX_CARD_INDEX; card++) {
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
		}
		return GameDisplay.tie();
	}

}
