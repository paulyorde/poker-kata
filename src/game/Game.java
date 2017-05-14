package game;

import player.Player;

public class Game {
	
	public Game() {}

	public static void play(Player playerOne, Player playerTwo) {
		Dealer.dealTo(playerOne);
		Dealer.dealTo(playerTwo);
		System.out.println(playerOne.getHand());
		System.out.println(playerTwo.getHand());
	}

	
	
	
	public static void main(String[] args) {
		Player white = new Player("white");
		Player black = new Player("black");
		Game.play(white, black);
		System.out.println(GameRules.findHighestCard(white, black));
	}

}
