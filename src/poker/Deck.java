package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> cards = new ArrayList<>();
	// move to carddata class
	List<String>  suitList = Arrays.asList("C","D","H","S");
	List<String>  aliasList = Arrays.asList("Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace");
	List<Integer> valueList = Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14);
	List<String>  faceList = Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","k","A");
	
	public Deck() {
		buildDeck();
	}
	
	// change to privat static final / use enhanced for loop to add 'card'
	public void buildDeck() {
		for(int i = 0; i < suitList.size(); i++) {
			for(int j = 0; j < faceList.size(); j++) {
				cards.add(new Card(suitList.get(i),faceList.get(j),valueList.get(j),aliasList.get(j)));
			}
		}
		
	}
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.buildDeck();
		Collections.shuffle(deck.cards);
		for(Card card : deck.cards) {
			System.out.println(card.toString());
		}
	}
}





