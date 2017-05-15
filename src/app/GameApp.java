package app;

import game.Game;
import game.GameRules;
import player.Player;

public class GameApp {

	public GameApp() {}
	
	public static void main(String[] args) {
		Player white = new Player("white");
		Player black = new Player("black");
		Game.play(white, black);
		System.out.println(GameRules.findStraightFlush(white, black));
//		System.out.println(GameRules.findFullHouse(white, black));
//		System.out.println(GameRules.findPair(white, black));
	}

}
