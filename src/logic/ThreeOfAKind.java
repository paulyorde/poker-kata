package logic;

import java.util.List; 

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class ThreeOfAKind {
	public ThreeOfAKind() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand,
			int beginningCardIndex, int nextCardIndex, int endingCardIndex, HandTypeMarker handType) {
		
		final int MAX_CARD_INDEX = 5;
		
		for (int card = beginningCardIndex, nextCard = nextCardIndex, endCard = endingCardIndex; endCard < MAX_CARD_INDEX; card++, nextCard++, endCard++) {
			boolean playerOneHasThreeOfAKind = (playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue())
					&& (playerOneHand.get(nextCard).getValue() == playerOneHand.get(endCard).getValue());
			boolean playerTwoHasThreeOfAKind = (playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue())
					&& (playerTwoHand.get(nextCard).getValue() == playerTwoHand.get(endCard).getValue());;

			if(handType.equals(HandTypeMarker.THREE_OF_A_KIND)) {
				if(playerOneHasThreeOfAKind) {
					return GameDisplay.winnerWithThreeOfAKind(Game.getPlayerOne(), card);
				} 
				else if(playerTwoHasThreeOfAKind) {
					return GameDisplay.winnerWithThreeOfAKind(Game.getPlayerTwo(), card);
				}
			} 
			else if(handType.equals(HandTypeMarker.FULL_HOUSE)) {
				if(playerOneHasThreeOfAKind) {
					FullHouse.setPlayerOneHasThreeOfAKind(true);;
					return "";
				}
				if(playerTwoHasThreeOfAKind) {
					FullHouse.setPlayerTwoHasThreeOfAKind(true);;
					return "";
				}
			}
			else {
				determineFor(playerOneHand, playerTwoHand, beginningCardIndex+1, nextCardIndex+1, endingCardIndex+1, handType); // recursively look for three of kind
			}
		}
		return GameRules.findPair(playerOneHand, playerTwoHand, HandTypeMarker.PAIR); // if three of kind not found - find two pair
	}

}
