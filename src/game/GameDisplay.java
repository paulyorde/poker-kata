package game;

import player.Player;

public class GameDisplay {

	public GameDisplay() {
	}

	public static String displayWinnerWithHighestCard(Player winner, int highCard) {
		return String.format("%s wins. - with high card: %s", winner.getName(),
				winner.getHand().getCards().get(highCard).getAlias());
	}

	public static String displayWinnerWithPair(Player winner, int card) {
		return String.format("%s wins. - with a pair: %s's", winner.getName(),
				winner.getHand().getCards().get(card).getAlias());
	}

	public static String winnerWithTwoPair(Player winner, int card) {
		return String.format("%s wins. - with two pair: %s's", winner.getName(),
				winner.getHand().getCards().get(card).getAlias());
	}

	public static String winnerWithThreeOfAKind(Player winner, int card) {
		return String.format("%s wins. - with three of a kind: %s's", winner.getName(),
				winner.getHand().getCards().get(card).getAlias());
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
	
	public static String winnerWithFourOfAKind(Player winner, int card) {
		return String.format("%s wins. - with four of a kind: %s's", winner.getName(),
				winner.getHand().getCards().get(card).getAlias());
	}
	
	public static String winnerWithStraightFlush(Player winner) {
		return String.format("%s wins. - with straight flush", winner.getName());
	}

	public static String tie() {
		return "tie";
	}

	
}
