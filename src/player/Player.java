package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gamePieces.Card;

public class Player {
	private String name;
	private List<Card> hand = new ArrayList<>();

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Card> getHand() {
		Collections.sort(hand);
		return hand;
	}

	public void addCardToHand(Card card) {
		hand.add(card);
	}
}
