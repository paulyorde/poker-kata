package poker;

import java.util.Collections;

public class Player {
	private String name;
	private Hand hand = new Hand();

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Hand getHand() {
		Collections.sort(hand.getCards());
		return hand;
	}

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}
}
