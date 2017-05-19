package gamePieces;

import java.util.ArrayList; 
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<>();

	public Deck() {
		buildDeck();
	}

	public void buildDeck() {
		for (int i = 0; i < CardData.suit().size(); i++) {
			for (int j = 0; j < CardData.face().size(); j++) {
				cards.add(new Card(
						CardData.suit().get(i), 
						CardData.face().get(j), 
						CardData.value().get(j), 
						CardData.alias().get(j)));
			}
		}
	}

	public List<Card> cards() {
		return cards;
	}

	
}
