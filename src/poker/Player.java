package poker;

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
		return hand;
	}

	public void addCardToHand(Card card) {
		this.hand.addCard(card);
	}
	
	
}
