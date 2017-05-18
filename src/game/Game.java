package game;


import java.util.List;

import player.Player;
import gamePieces.Card;

public class Game {
	private static Player playerOne;
	private static Player playerTwo;
	
	public Game() {}

	public static String play(Player playerOneIn, Player playerTwoIn) {
		playerOne = playerOneIn;
		playerTwo = playerTwoIn;
		
		Dealer.dealToPlayers(playerOne, playerTwo);
		
		return findWinner(playerOne, playerTwo);
	}
	
	private static String findWinner(Player playerOne, Player playerTwo) {
		List<Card> playerOneHand = playerOne.getHand();
		List<Card> playerTwoHand = playerTwo.getHand();
		return GameRules.findStraightFlush(playerOneHand, playerTwoHand);
	}

	public static Player getPlayerOne() {
		return playerOne;
	}

	public static Player getPlayerTwo() {
		return playerTwo;
	}
	
}
