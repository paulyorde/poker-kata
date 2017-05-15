package gamePieces;

public class Card implements Comparable<Card> {
	private String suit;
	private String face;
	private int    value;
	private String alias;

	public Card(String suit, String face, int value, String alias) {
		this.suit  = suit;
		this.face  = face;
		this.value = value;
		this.alias = alias;
	}

	public Card(String suit, Integer value) {
		this.suit = suit;
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public String getFace() {
		return face;
	}

	public int getValue() {
		return value;
	}

	public String getAlias() {
		return alias;
	}

	@Override
	public String toString() {
		return String.format("%s %s %d %s", suit, face, value, alias);
	}

	@Override
	public int compareTo(Card comparisonCard) {
		int comparisonValue = comparisonCard.getValue();
		return  comparisonValue - this.value;
	}
}
