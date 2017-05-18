package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gamePieces.Card;
import gamePieces.Deck;
import player.Player;

public class Dealer {
	private static final Deck DECK = new Deck();
	private static final int MAX_HAND_SIZE = 5;
	
	public Dealer() {}

	public static void dealToPlayers(Player playerOne, Player playerTwo) {
		List<Card> gameCards = new ArrayList<>();
		
		shuffleCards();
		DECK.cards().stream()
			.limit(10)
			.distinct()
		    .forEach(card -> gameCards.add(card));
		
		dealToPlayerOne(playerOne, gameCards);
		
		dealToPlayerTwo(playerTwo, gameCards);
	}

	private static void dealToPlayerTwo(Player playerTwo, List<Card> gameCards) {
		gameCards.stream()
		    .skip(5)
			.limit(MAX_HAND_SIZE)
			.distinct()
			.forEach(card -> playerTwo.addCardToHand(card));
	}

	private static void dealToPlayerOne(Player playerOne, List<Card> gameCards) {
		gameCards.stream()
			.limit(MAX_HAND_SIZE)
			.distinct()
			.forEach(card -> playerOne.addCardToHand(card));
	}
	
	private static void shuffleCards() {
		Collections.shuffle(DECK.cards());
	}
	
}
