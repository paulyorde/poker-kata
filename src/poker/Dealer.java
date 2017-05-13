package poker;

import java.util.Collections;

public class Dealer {
	private static final Deck DECK = new Deck();
	
	public Dealer() {
		super();
	}

	public static void dealTo(Player player) {
		shuffleCards();
		DECK.cards.stream()
			.limit(5)
			.forEach(card -> player.addCardToHand(card));
	}
	
	private static void shuffleCards() {
		Collections.shuffle(DECK.cards);
	}
	
}
