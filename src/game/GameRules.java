package game;

import java.util.List;

import gamePieces.Card;
import logic.HighestCard;
import logic.HandTypeMarker;
import logic.Pair;
import logic.TwoPair;
import logic.ThreeOfAKind;
import logic.Straight;
import logic.Flush;
import logic.FullHouse;
import logic.FourOfAKind;
import logic.StraightFlush;

public class GameRules  {
	public static String findHighestCard(List<Card> playerOneHand, List<Card> playerTwoHand) {
		return HighestCard.determineFor(playerOneHand, playerTwoHand, 0);
	}

	public static String findPair(List<Card> playerOneHand, List<Card> playerTwoHand, HandTypeMarker handType) {
		return Pair.determineFor(playerOneHand, playerTwoHand, 0, 1, handType);
	}
	
	public static String findTwoPair(List<Card> playerOneHand, List<Card> playerTwoHand) {
		return TwoPair.determineFor(playerOneHand, playerTwoHand, 0, 1);
	}
	
	public static String findThreeOfAKind(List<Card> playerOneHand, List<Card> playerTwoHand, HandTypeMarker handType) {
		return ThreeOfAKind.determineFor(playerOneHand, playerTwoHand, 0, 1, 2, handType);
	}

	public static String findStraight(List<Card> playerOneHand, List<Card> playerTwoHand, HandTypeMarker handType) {
		return Straight.determineFor(playerOneHand, playerTwoHand, handType);
	}
	
	public static String findFlush(List<Card> playerOneHand, List<Card> playerTwoHand, HandTypeMarker handType) {
		return Flush.determineFor(playerOneHand, playerTwoHand, handType);
	}
	
	public static String findFullHouse(List<Card> playerOneHand, List<Card> playerTwoHand) {
		return FullHouse.determineFor(playerOneHand, playerTwoHand);
	}
	
	public static String findFourOfAKind(List<Card> playerOneHand, List<Card> playerTwoHand) {
		return FourOfAKind.determineFor(playerOneHand, playerTwoHand, 0, 1, 2, 3);
	}

	public static String findStraightFlush(List<Card> playerOneHand, List<Card> playerTwoHand) {
		return StraightFlush.determineFor(playerOneHand, playerTwoHand);
	}
}
