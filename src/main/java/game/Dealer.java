package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gamePieces.Card;
import gamePieces.Deck;
import player.Player;

public class Dealer {
	private static final int FIRST_FIVE_GAME_CARDS = 5;
	private static final int TEN_GAME_CARDS = 10;
	private static final Deck DECK = new Deck();
	private static final List<Card> GAME_CARDS = new ArrayList<>();
	private static final int MAX_HAND_SIZE = 5;
	
	public Dealer() {}

	public static void dealToPlayers(Player playerOne, Player playerTwo) {
		shuffleCards();
		DECK.cards().stream()
			.limit(TEN_GAME_CARDS)
		    .forEach(card -> GAME_CARDS.add(card));
		
		dealToPlayerOne(playerOne);
		
		dealToPlayerTwo(playerTwo);
	}
	
	private static void dealToPlayerOne(Player playerOne) {
		GAME_CARDS.stream()
			.limit(MAX_HAND_SIZE)
			.forEach(card -> playerOne.addCardToHand(card));
	}

	private static void dealToPlayerTwo(Player playerTwo) {
		GAME_CARDS.stream()
		    .skip(FIRST_FIVE_GAME_CARDS)
			.limit(MAX_HAND_SIZE)
			.forEach(card -> playerTwo.addCardToHand(card));
	}
	
	private static void shuffleCards() {
		Collections.shuffle(DECK.cards());
	}
	
}
