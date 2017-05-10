package poker;

import java.util.ArrayList;
import java.util.List;

public class GameRules {
	// return array of alias, player name, etc for display output
	public static Player compareHands(Player p1, Player p2) {
		highestCard(p1,p2);
		return null;
	}
	
	private static List<String> highestCard(Player p1, Player p2) {
		List<String> winner = new ArrayList<>();
		int highCard = 0;
		for(Card card: p1.getHand().getCards()) {
			
		}
		return winner; 
	}

}
