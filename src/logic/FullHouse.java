package logic;

import game.GameDisplay;
import game.GameRules;
import player.Player;

public class FullHouse {
	public static int p13ofKind;
	public static int p23ofKind;
	public static int p1pair;
	public static int p2pair;

	public FullHouse() {}

	public static String determineFor(Player p1, Player p2) {
		
		GameRules.findPairForFullHouse(p1, p2);
		GameRules.findThreeOfAKindForFullHouse(p1, p2);
		
		if(((p13ofKind == 1) && (p1pair == 1))) {
			return GameDisplay.winnerWithFullHouse(p1);
		} 
		else if(((p23ofKind == 2) && (p2pair == 2))) {
			return GameDisplay.winnerWithFullHouse(p2);
		}
		return GameRules.findFlush(p1, p2);
	}

}
