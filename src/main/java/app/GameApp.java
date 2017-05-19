package app;

import game.Game; 
import player.Player;

public class GameApp {

	public GameApp() {}
	
	public static void main(String[] args) {
		System.out.println(Game.play(new Player("white"), new Player("black")) + "\n");
		System.out.println(Game.getPlayerOne().getName() + " " + Game.getPlayerOne().getHand());
		System.out.println(Game.getPlayerTwo().getName() + " " + Game.getPlayerTwo().getHand());
	}

}
