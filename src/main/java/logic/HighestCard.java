package logic;

import java.util.List;

import game.Game;
import game.GameDisplay;
import gamePieces.Card;

public class HighestCard {

	
	public HighestCard() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		final int MAX_CARD_INDEX = 4;
		int playerOneHighestCard = 0, playerTwoHighestCard = 0;
		boolean playerOneHasHighestCard = false, playerTwoHasHighestCard = false;
		 
		for (int card = 0; card < MAX_CARD_INDEX; card++) {
			playerOneHighestCard = playerOneHand.get(card).getValue();
			playerTwoHighestCard = playerTwoHand.get(card).getValue();
			playerOneHasHighestCard = playerOneHighestCard > playerTwoHighestCard;
			playerTwoHasHighestCard = playerOneHighestCard < playerTwoHighestCard;
			
			if (playerOneHasHighestCard) {
				return GameDisplay.winnerWithHighestCard(Game.getPlayerOne(), card);
			} 
			else if (playerTwoHasHighestCard) {
				return GameDisplay.winnerWithHighestCard(Game.getPlayerTwo(), card);
			} 
		}
		
		return GameDisplay.tie(); // if both hands have same value - display tie;
	}

}
