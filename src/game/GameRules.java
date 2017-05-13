package game;

import logic.HighestCard;
import player.Player;

public class GameRules  {
	// return player or null to access players data
	public static int foo(Player p1, Player p2, int iIn) {
		return HighestCard.determineFor(p1, p2, iIn);
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Player white = new Player("white");
		Player black = new Player("black");
		Game.play(white, black);
		System.out.println(GameRules.foo(white, black, 0));
	}

}
