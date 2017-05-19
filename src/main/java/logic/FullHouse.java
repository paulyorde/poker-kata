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
		boolean playerOneHasThreeOfAKind = false;
		boolean playerTwoHasThreeOfAKind = false;
		boolean playerOneIsPair = false;
		boolean playerTwoIsPair = false;
		final int MAX_CARD_INDEX = 4;
		List<Card> threeOfAKind = new ArrayList<>();
		List<Card> pair = new ArrayList<>();
		
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
		
		for(Card cardInThreOfAKind : threeOfAKind) {
		    for (int card = 0; card < 5; card++) {
				if (playerOneHand.get(card).getValue() != cardInThreOfAKind.getValue())  {
					if(pair.size() < 2)
						pair.add(playerOneHand.get(card));
					if(pair.size() > 1)
						playerOneIsPair = (pair.get(0).getValue() == pair.get(1).getValue());
					if(playerOneIsPair) {
						break;
					}
				}
			}
		}
		
		if (playerOneHasThreeOfAKind && playerOneIsPair) {
			return GameDisplay.winnerWithFullHouse(Game.getPlayerOne());
		} 
		else if (playerTwoHasThreeOfAKind && playerTwoIsPair) {
			return GameDisplay.winnerWithFullHouse(Game.getPlayerTwo());
		}
		
		return GameRules.findFlush(playerOneHand, playerTwoHand, HandTypeMarker.FLUSH); // if pair not found, look for highest card
	}
}