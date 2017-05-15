package game;

import player.Player;

public class Game {
	
	public Game() {}

	public static void play(Player playerOne, Player playerTwo) {
		Dealer.dealTo(playerOne);
		Dealer.dealTo(playerTwo);
		// functions that calls first royal flush - returns gamedisplay , change return type of play to String
		System.out.println(playerOne.getHand());
		System.out.println(playerTwo.getHand());
	}
}
