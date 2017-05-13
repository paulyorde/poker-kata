package logic;

import player.Player;

public class HighestCard {

	public HighestCard() {}

	public static int determineFor(Player p1, Player p2, int iIn) {
		int noWinner = 0;
		
		for (int i = iIn; i < 4; i++) {
			int playerOneHighestCard = p1.getHand().getCards().get(i).getValue();
			int playerTwoHighestCard = p2.getHand().getCards().get(i).getValue();
			boolean playerOneCardIsHighest = playerOneHighestCard > playerTwoHighestCard;
			boolean playerTwoCardIsHighest = playerOneHighestCard < playerTwoHighestCard;

			if (playerOneCardIsHighest) {
				return playerOneHighestCard;
			} else if (playerTwoCardIsHighest) {
				return playerTwoHighestCard;
			} else {
				determineFor(p1, p2, iIn + 1); // recursively look for highest card
			}
		}
		return noWinner;
	}

}
