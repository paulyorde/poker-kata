package logic;

import java.util.List; 

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class FullHouse {
	private static boolean playerOneHasThreeOfAKind;
	private static boolean playerTwoHasThreeOfAKind;
	private static boolean playerOneHasPair;
	private static boolean playerTwoHasPair;

	public FullHouse() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		GameRules.findPair(playerOneHand, playerTwoHand, HandTypeMarker.FULL_HOUSE);
		GameRules.findThreeOfAKind(playerOneHand, playerTwoHand, HandTypeMarker.FULL_HOUSE);
		
		if(playerOneHasThreeOfAKind && playerOneHasPair) {
			return GameDisplay.winnerWithFullHouse(Game.getPlayerOne());
		} 
		else if(playerTwoHasThreeOfAKind && playerTwoHasPair) {
			return GameDisplay.winnerWithFullHouse(Game.getPlayerTwo());
		}
		
		return GameRules.findFlush(playerOneHand, playerTwoHand, HandTypeMarker.FLUSH); // if fullhouse not found - find flush
	}

	public static void setPlayerOneHasThreeOfAKind(boolean isThreeOfAKind) {
		playerOneHasThreeOfAKind = isThreeOfAKind;
	}

	public static void setPlayerTwoHasThreeOfAKind(boolean isThreeOfAKind) {
		playerTwoHasThreeOfAKind = isThreeOfAKind;
	}

	public static void setPlayerOneHasPair(boolean isPair) {
		playerOneHasPair = isPair;
	}

	public static void setPlayerTwoHasPair(boolean isPair) {
		playerTwoHasPair = isPair;
	}
}
