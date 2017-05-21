package logic;

import java.util.ArrayList;
import java.util.List;

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class FullHouse {

	public FullHouse() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		boolean playerOneHasThreeOfAKind = false, playerTwoHasThreeOfAKind = false;
		boolean playerOneHasPair = false, playerTwoHasPair = false;
		int FIRST_CARD = 0, SECOND_CARD = 1, TWO_CARDS = 2, MAX_CARD_INDEX = 4;
		List<Card> threeOfAKind = new ArrayList<>();
		List<Card> remainingCards = new ArrayList<>();
		
		// find three of a kind and it to list
		for (int card = 0, nextCard = 1, endCard = 2; nextCard < MAX_CARD_INDEX; card++, nextCard++, endCard++) {
			playerOneHasThreeOfAKind = (playerOneHand.get(card).getValue() == playerOneHand.get(nextCard).getValue())
					&& (playerOneHand.get(nextCard).getValue() == playerOneHand.get(endCard).getValue());
			playerTwoHasThreeOfAKind = (playerTwoHand.get(card).getValue() == playerTwoHand.get(nextCard).getValue())
					&& (playerTwoHand.get(nextCard).getValue() == playerTwoHand.get(endCard).getValue());
			
			if(playerOneHasThreeOfAKind) {
				threeOfAKind.add(playerOneHand.get(card));
				threeOfAKind.add(playerOneHand.get(nextCard));
				threeOfAKind.add(playerOneHand.get(endCard));
				break;
			}
			
		}
		
		// determine that pairs aren't already in three of a kind
		for(Card cardInThreOfAKind : threeOfAKind) {
		    for (int card = 0; card < MAX_CARD_INDEX; card++) {
				if (playerOneHand.get(card).getValue() != cardInThreOfAKind.getValue())  {
					remainingCards.add(playerOneHand.get(card));
					if(remainingCards.size() == TWO_CARDS)
						playerOneHasPair = (remainingCards.get(FIRST_CARD).getValue() == remainingCards.get(SECOND_CARD).getValue());
					if(playerOneHasPair) {
						break;
					}
				}
			}
		}
		
		if (playerOneHasThreeOfAKind && playerOneHasPair) {
			return GameDisplay.winnerWithFullHouse(Game.getPlayerOne());
		} 
		else if (playerTwoHasThreeOfAKind && playerTwoHasPair) {
			return GameDisplay.winnerWithFullHouse(Game.getPlayerTwo());
		}
		
		return GameRules.findFlush(playerOneHand, playerTwoHand, HandTypeMarker.FLUSH); // if full house not found, look for flush
	}
}