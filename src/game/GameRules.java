package game;

import logic.Flush;
import logic.FullHouse;
import logic.HighestCard;
import logic.Pair;
import logic.Straight;
import logic.ThreeOfAKind;
import logic.TwoPair;
import player.Player;

public class GameRules  {
	public static String findHighestCard(Player p1, Player p2) {
		return HighestCard.determineFor(p1, p2, 0);
	}

	public static String findPair(Player p1, Player p2) {
		return Pair.determineFor(p1, p2, 0, 1, "pair");
	}

	public static String findPairForFullHouse(Player p1, Player p2) {
		return Pair.determineFor(p1, p2, 0, 1, "fullhouse");
	}
	
	public static String findTwoPair(Player p1, Player p2) {
		return TwoPair.determineFor(p1, p2, 0, 1);
	}

	public static String findThreeOfAKind(Player p1, Player p2) {
		return ThreeOfAKind.determineFor(p1, p2, 0, 1, 2, "three of a kind");
	}
	
	public static String findThreeOfAKindForFullHouse(Player p1, Player p2) {
		return ThreeOfAKind.determineFor(p1, p2, 0, 1, 2, "fullhouse");
	}

	public static String findStraight(Player p1, Player p2) {
		return Straight.determineFor(p1, p2);
	}
	
	public static String findFlush(Player p1, Player p2) {
		return Flush.determineFor(p1,p2);
	}
	
	public static String findFullHouse(Player p1, Player p2) {
		return FullHouse.determineFor(p1,p2);
	}
}
