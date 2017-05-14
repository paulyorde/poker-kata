package game;

import player.Player;

public class GameDisplay {

	public GameDisplay() {}

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

	public static String tie() {
		return "tie";
	}

	

	

}
