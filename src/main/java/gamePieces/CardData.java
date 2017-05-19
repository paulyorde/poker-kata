package gamePieces;

import java.util.Arrays;
import java.util.List;

public class CardData {

	private static final List<String> SUIT   = Arrays.asList("C", "D", "H", "S");
	private static final List<String> FACE   = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k", "A");
	private static final List<String> ALIAS  = Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine", "Ten", "Jack", "Queen", "King", "Ace");
	private static final List<Integer> VALUE = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

	public CardData() {
		super();
	}

	public static List<String> suit() {
		return SUIT;
	}

	public static List<String> face() {
		return FACE;
	}

	public static List<String> alias() {
		return ALIAS;
	}

	public static List<Integer> value() {
		return VALUE;
	}

}
