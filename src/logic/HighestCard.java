package logic;

import poker.Player;

public class HighestCard {

	public HighestCard() {}

	public static int determineFor(Player p1, Player p2, int iIn) {
		int playerOneHighestCard = 0;
		int playerTwoHighestCard = 0;
		boolean playerOneCardIsHighest = playerOneHighestCard > playerTwoHighestCard;
		boolean playerTwoCardIsHighest = playerOneHighestCard < playerTwoHighestCard;
		int noWinner = 0;
		
		for (int i = iIn; i < 4; i++) {
			playerOneHighestCard = p1.getHand().getCards().get(i).getValue();
			playerTwoHighestCard = p2.getHand().getCards().get(i).getValue();

			if (playerOneCardIsHighest) {
				return playerOneHighestCard;
			} else if (playerTwoCardIsHighest) {
				return playerTwoHighestCard;
			} else {
				// recursively look for highest card
				determineFor(p1, p2, iIn + 1);
			}
		}
		return noWinner;
	}

}
