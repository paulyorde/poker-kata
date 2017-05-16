package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gamePieces.Card;

public class Player {
	private String name;
	private List<Card> cards = new ArrayList<>();
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
