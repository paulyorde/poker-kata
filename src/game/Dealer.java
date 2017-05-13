package game;

import java.util.Collections;

import gamePieces.Deck;
import player.Player;

public class Dealer {
	private static final Deck DECK = new Deck();
	
	public Dealer() {
		super();
	}

	public static void dealTo(Player player) {
		shuffleCards();
		DECK.getCards().stream()
			.limit(5)
			.forEach(card -> player.addCardToHand(card));
	}
	
	private static void shuffleCards() {
		Collections.shuffle(DECK.getCards());
	}
	
}
