package poker;

import java.util.Collections;

public class Game {

	public Game() {

	}

	public static void deal(Player toPlayer) {
		Deck deck = new Deck();
		Collections.shuffle(deck.cards);
		int cardCount = 0;
		for (Card card : deck.cards) {
			cardCount++;
			toPlayer.addCardToHand(card);
			if (cardCount == 5) {
				break;
			}
		}
		Collections.sort(toPlayer.getHand().getCards());
		System.out.println(toPlayer.getHand());
	}

	public String displayWinner(Player p1, Player p2) {
		Player winner = GameRules.compareHands(p1, p2);

		return String.format("%s", winner);
	}

	public static void main(String[] args) {
		Game.deal(new Player("white"));
		Game.deal(new Player("black"));
		// Game.displayWinner(playerWhite, playerBlack);
	}

}
