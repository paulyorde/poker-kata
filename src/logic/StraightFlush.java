package logic;

import java.util.List;

import game.Game;
import game.GameDisplay;
import game.GameRules;
import gamePieces.Card;

public class StraightFlush {
	
	private static boolean playerOneHasStraight;
	private static boolean playerTwoHasStraight;
	private static boolean playerOneHasFlush;
	private static boolean playerTwoHasFlush;

	public StraightFlush() {}

	public static String determineFor(List<Card> playerOneHand, List<Card> playerTwoHand) {
		GameRules.findFlush(playerOneHand, playerTwoHand, HandTypeMarker.STRAIGHT_FLUSH);
		GameRules.findStraight(playerOneHand, playerTwoHand, HandTypeMarker.STRAIGHT_FLUSH);
		
		if((playerOneHasStraight && playerOneHasFlush) 
				&& (playerTwoHasStraight && playerTwoHasFlush)) {
			GameRules.findHighestCard(playerOneHand, playerTwoHand);
		}
		if(playerOneHasStraight && playerOneHasFlush) {
			return GameDisplay.winnerWithStraightFlush(Game.getPlayerOne());
		} 
		else if(playerTwoHasStraight && playerTwoHasFlush) {
			return GameDisplay.winnerWithStraightFlush(Game.getPlayerTwo());
		}
		return FourOfAKind.determineFor(playerOneHand, playerTwoHand, 0, 1, 2, 3); // if straight flush not found - find four of a kind
	}

	public static void setPlayerOneFlush(boolean isFlush) {
		playerOneHasFlush = isFlush;
	}

	public static void setPlayerTwoFlush(boolean isFlush) {
		playerTwoHasFlush = isFlush;
	}

	public static void setPlayerOneStraight(boolean isStraight) {
		playerOneHasStraight = isStraight;
	}

	public static void setPlayerTwoStraight(boolean isStraight) {
		playerTwoHasStraight = isStraight;
	}

}
