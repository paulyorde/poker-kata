package game;

import player.Player;

public class Game {
	
	public Game() {}

	public static String play(Player playerOne, Player playerTwo) {
		Dealer.dealTo(playerOne);
		Dealer.dealTo(playerTwo);
		
		// get cards from each player called playerOneCards, playerTwoCards , pass into findWinner
		
		return findWinner(playerOne, playerTwo);
	}
	
	private static String findWinner(Player playerOne, Player playerTwo) {
		return GameRules.findFlushForStraightFlush(playerOne, playerTwo);
	}
}
