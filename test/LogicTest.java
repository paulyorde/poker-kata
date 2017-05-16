

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
		p2.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(9)));
		p2.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(8)));
		p2.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(6)));
		
		Assert.assertEquals("white wins. - with straight flush", GameRules.findStraightFlush(p1, p2));
		
	}

	@Test
	public void shouldReturnTieIfBothHaveStraightWithSameValue() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10),CardData.alias().get(10)));   
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(9), CardData.alias().get(9)));   
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(8), CardData.alias().get(8))); 
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7))); 
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(6), CardData.alias().get(6)));   
		
		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10),CardData.alias().get(10)));  
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));    
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));    
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));    
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));    
		
		Assert.assertEquals("tie", GameRules.findStraight(p1, p2));
		
	}

	@Test
	public void shouldReturnTieIfBothHaveFlushWithSameValue() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(10),CardData.alias().get(10)));   
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(9), CardData.alias().get(9)));   
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(8), CardData.alias().get(8))); 
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7))); 
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(6), CardData.alias().get(6)));   
		
		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(10),CardData.alias().get(10)));  
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));    
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));    
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));    
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));    
		
		Assert.assertEquals("tie", GameRules.findFlush(p1, p2));
		
	}
	
	@Test
	public void shouldReturnFullHouse() {
		Player p1 = new Player("black");
		p1.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(11)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(9)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(8)));
		p1.addCardToHand(new Card(CardData.suit().get(2), CardData.value().get(7)));
		p1.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(6)));
		
		Player p2 = new Player("white");
		p2.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(10)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(10)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(10)));
		p2.addCardToHand(new Card(CardData.suit().get(1), CardData.value().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(0), CardData.value().get(7)));
		
		Assert.assertEquals("white wins. - with fullhouse", GameRules.findFullHouse(p1, p2));
		
	}

	@Test
	public void shouldReturnHighestCardIfBothHaveFullHouseWithSameValue() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10))); 
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(10), CardData.alias().get(10))); 
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(10), CardData.alias().get(10))); 
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7))); 
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7))); 
		                                                                           
		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7))); 
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7))); 
		
		Assert.assertEquals("white wins. - with fullhouse", GameRules.findFullHouse(p1, p2));
	}
	
	@Test
	public void shouldReturnHighestCardIfBothHaveFourOfAKind() {
		Player p1 = new Player("black");
		p1.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));
		p1.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));
		p1.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(9), CardData.alias().get(9)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9),  CardData.alias().get(9)));
		
		Player p2 = new Player("white");
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));
		p2.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(10), CardData.alias().get(10)));
		p2.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(10), CardData.alias().get(10)));
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));
		p2.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7),  CardData.alias().get(7)));
		
		Assert.assertEquals("black wins. - with four of a kind: Jack's", GameRules.findFourOfAKind(p1, p2));
		
	}

	@Test
	public void shouldReturnPair() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));
		p1.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6)));
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(5), CardData.alias().get(5)));
		
		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(0), CardData.alias().get(1)));
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(0), CardData.alias().get(1)));
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6)));
		p2.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(5), CardData.alias().get(5)));
		
		Assert.assertEquals("white wins. - with a pair: Nine's", GameRules.findPair(p1, p2));
		
	}
	
	@Test
	public void shouldReturnHighestCard() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(4), CardData.alias().get(4)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(5), CardData.alias().get(5)));
		p1.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(12), CardData.alias().get(12)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11), CardData.alias().get(11)));
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));
		
		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(11), CardData.alias().get(11)));
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6)));
		p2.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(5), CardData.alias().get(5)));
		
		Assert.assertEquals("white wins. - with high card: Ace", GameRules.findPair(p1, p2));
		
	}
	
	@Test
	public void shouldReturnHighestCardIfBothHavePair() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(4), CardData.alias().get(4)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(5), CardData.alias().get(5)));
		p1.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(12), CardData.alias().get(12)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));
		
		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6)));
		p2.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(5), CardData.alias().get(5)));
		
		Assert.assertEquals("white wins. - with high card: Ace", GameRules.findPair(p1, p2));
		
	}

	@Test
	public void shouldReturnHighestCardIfBothHaveTwoPair() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(4), CardData.alias().get(4)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(4), CardData.alias().get(4)));
		p1.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(12), CardData.alias().get(12)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));
		
		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7)));
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(4), CardData.alias().get(4)));
		p2.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(4), CardData.alias().get(4)));
		
		Assert.assertEquals("white wins. - with high card: Ace", GameRules.findTwoPair(p1, p2));
		
	}

	@Test
	public void shouldReturnTieIfBothHavePairAndSameHighestCard() {
		Player p1 = new Player("white");
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(4), CardData.alias().get(4)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(5), CardData.alias().get(5)));
		p1.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(12), CardData.alias().get(12)));
		p1.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));
		p1.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));
		
		Player p2 = new Player("black");
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(4), CardData.alias().get(4)));  
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(5), CardData.alias().get(5)));  
		p2.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(12), CardData.alias().get(12)));
		p2.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));  
		p2.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7)));  
		
		Assert.assertEquals("tie", GameRules.findPair(p1, p2));
		
	}

}








