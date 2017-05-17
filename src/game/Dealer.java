package game;

import java.util.Collections;

import gamePieces.Card;
import gamePieces.Deck;
import player.Player;

public class Dealer {
	private static final Deck DECK = new Deck();
	private static final int MAX_HAND_SIZE = 5;
	
	public Dealer() {}

	public static void dealToPlayerOne(Player playerOne) {
		shuffleCards();
		DECK.cards().stream()
			.limit(MAX_HAND_SIZE)
			.distinct()
		    .forEach(card -> playerOne.addCardToHand(card));
	}
	
	public static void dealToPlayerTwo(Player playerTwo) {
		shuffleCards();
		DECK.cards().stream()
			.limit(MAX_HAND_SIZE)
			.distinct()
		    .forEach(card -> toPlayerTwo(playerTwo, card));
	}
	
	private static void toPlayerTwo(Player playerTwo, Card card) {
		if(!Game.getPlayerOne().getHand().contains(card)) {
			playerTwo.addCardToHand(card);
		}
		if(Game.getPlayerTwo().getHand().size() < 1) {
			DECK.cards().stream()
				.limit(MAX_HAND_SIZE - Game.getPlayerTwo().getHand().size())
				.forEach(card2 -> playerTwo.addCardToHand(card2));
		}
			
	}
	
	private static void shuffleCards() {
		Collections.shuffle(DECK.cards());
	}
	
}
