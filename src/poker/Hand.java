package poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cards = new ArrayList<>();
	
	public Hand() {}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	@Override
	public String toString() {
		return String.format("%s", cards);
	}
}
