

import org.junit.Test;

import game.GameRules;

import org.junit.Assert;

import gamePieces.Card;
import gamePieces.CardData;
import player.Player;

public class LogicTest {

	@Test
	public void shouldReturnStraightFlush() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(10)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(9)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(8)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(7)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(6)));

		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(11)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(9)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(8)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(6)));
		
		Assert.assertEquals("white wins. - with straight flush", GameRules.findStraightFlush(p1, p2));
		
	}
	
	@Test
	public void shouldReturnFullHouse() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(10)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(10)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(10)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(7)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(7)));

		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(11)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(9)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(8)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(6)));
		
		Assert.assertEquals("white wins. - with fullhouse", GameRules.findFullHouse(p1, p2));
		
	}

}








