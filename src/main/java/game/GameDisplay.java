package game;

import java.util.Iterator;
import java.util.List;


import player.Player;

public class GameDisplay {

	public GameDisplay() {
	}

	public static String winnerWithHighestCard(Player winner, int highCard) {
		return String.format("%s wins. - with high card: %s", winner.getName(),
				winner.getHand().get(highCard).getAlias());
	}

	public static String winnerWithPair(Player winner, int card) {
		return String.format("%s wins. - with a pair: %s's", winner.getName(),
				winner.getHand().get(card).getAlias());
	}

	public static String winnerWithTwoPair(Player winner, List<Integer> playerTwoHighCardsForDisplay) {
		Iterator<Integer> cards = playerTwoHighCardsForDisplay.iterator();
		int highestCard = 0;
		int lowestCard  = 0;
		while(cards.hasNext()) {
			highestCard = cards.next();
			lowestCard  = cards.next();
		}
		
		return String.format("%s wins. - with two pair: %s's and %s's", winner.getName(),
				winner.getHand().get(highestCard).getAlias(), winner.getHand().get(lowestCard).getAlias());
	}

	public static String winnerWithThreeOfAKind(Player winner, int card) {
		return String.format("%s wins. - with three of a kind: %s's", winner.getName(),
				winner.getHand().get(card).getAlias());
	}

	public static String winnerWithStraight(Player winner) {
		return String.format("%s wins. - with straight", winner.getName());
	}

	public static String winnerWithFlush(Player winner) {
		return String.format("%s wins. - with flush", winner.getName());
	}
	
	public static String winnerWithFullHouse(Player winner) {
		return String.format("%s wins. - with fullhouse", winner.getName());
	}
	
	public static String winnerWithFourOfAKind(Player winner) {
		return String.format("%s wins. - with four of a kind", winner.getName()
				);
	}
	
	public static String winnerWithStraightFlush(Player winner) {
		return String.format("%s wins. - with straight flush", winner.getName());
	}

	public static String tie() {
		return "tie";
	}

	
}
