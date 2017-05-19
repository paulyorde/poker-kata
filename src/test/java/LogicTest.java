
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import game.Game;
import game.GameRules;
import gamePieces.Card;
import gamePieces.CardData;
import logic.HandTypeMarker;
import player.Player;

public class LogicTest {
	private Player playerOne, playerTwo;
	
	@Before
	public void setUp() {
		playerOne = new Player("white");
		playerTwo = new Player("black");
		Game.setPlayers(playerOne, playerTwo);
	}

	@Test
	public void shouldReturnStraightFlush() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));                                
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6))); 
		                                                                                                                   
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));                              
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6))); 
		
		Assert.assertEquals("white wins. - with straight flush", GameRules.findStraightFlush(playerOne.getHand(), playerTwo.getHand()));
		
	}

	@Test
	public void shouldReturnFourOfAKind() {
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(10), CardData.alias().get(10))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));                                
		
		playerTwo.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));                              
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(6), CardData.alias().get(6))); 
		// if one > the two return one | get.value > get.value
		Assert.assertEquals("white wins. - with four of a kind", GameRules.findFourOfAKind(playerOne.getHand(), playerTwo.getHand()));
		
	}

	@Test
	public void shouldReturnHandWithHighestValueFourOfAKind() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6)));                                
		
		playerTwo.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(8), CardData.alias().get(8)));                              
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(11), CardData.alias().get(11))); 
		// if one > the two return one | get.value > get.value
		Assert.assertEquals("white wins. - with four of a kind", GameRules.findFourOfAKind(playerOne.getHand(), playerTwo.getHand()));
		
	}
	
	@Test                                                                                                                       
	public void shouldReturnFullHouse() {                                                                                       
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(11), CardData.alias().get(11)));    
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(11), CardData.alias().get(11)));    
		playerOne.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(11), CardData.alias().get(11)));    
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));      
		playerOne.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7))); 
		
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11), CardData.alias().get(11)));    
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));      
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8)));      
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));      
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));      
		                                                                                                                        
		Assert.assertEquals("white wins. - with fullhouse", GameRules.findFullHouse(playerOne.getHand(), playerTwo.getHand())); 
		                                                                                                                        
	}       
	
	@Test
	public void shouldReturnFlush() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));                                
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6))); 
		                                                                                                                   
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));                              
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6))); 
		
		Assert.assertEquals("white wins. - with flush", GameRules.findFlush(playerOne.getHand(), playerTwo.getHand(), HandTypeMarker.FLUSH));
		
	}
	
	@Test
	public void shouldReturnStraight() {
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(10), CardData.alias().get(10)));                                
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6))); 
		                                                                                                                   
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));                              
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6))); 
		
		Assert.assertEquals("white wins. - with straight", GameRules.findStraight(playerOne.getHand(), playerTwo.getHand(), HandTypeMarker.STRAIGHT));
		
	}

	@Test
	public void shouldReturnTieIfBothHaveStraightWithSameValue() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6)));   

		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));    
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));    
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));    
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));    
		
		Assert.assertEquals("tie", GameRules.findStraight(playerOne.getHand(), playerTwo.getHand(), HandTypeMarker.STRAIGHT));
		
	}

	@Test
	public void shouldReturnTieIfBothHaveFlushWithSameValue() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11),CardData.alias().get(11)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(6), CardData.alias().get(6)));   
		
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(11),CardData.alias().get(11)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));    
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(8), CardData.alias().get(8)));    
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));    
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));    
		
		Assert.assertEquals("tie", GameRules.findFlush(playerOne.getHand(), playerTwo.getHand(), HandTypeMarker.FLUSH));
		
	}
	

	@Test
	public void shouldReturnThreeOfAKind() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11), CardData.alias().get(11)));
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));  
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8)));  
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));  
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));  
		
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(12), CardData.alias().get(12)));
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(11),CardData.alias().get(11)));
		
		Assert.assertEquals("black wins. - with three of a kind: Queen's", GameRules.findThreeOfAKind(playerOne.getHand(), playerTwo.getHand()));
		
	}
	
	@Test
	public void shouldReturnTwoPair() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11), CardData.alias().get(11))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(9), CardData.alias().get(9)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));   
		
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));   
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(5), CardData.alias().get(5))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(4), CardData.alias().get(4))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(11),CardData.alias().get(11)));  
		
		Assert.assertEquals("white wins. - with two pair: Jack's and Nine's", GameRules.findTwoPair(playerOne.getHand(), playerTwo.getHand()));
		
	}
	
	@Test
	public void shouldReturnHighestCardIfBothHaveTwoPair() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11), CardData.alias().get(11))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(9), CardData.alias().get(9)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));   
		                                                                                                                     
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(9), CardData.alias().get(9))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(12),CardData.alias().get(12)));  
		
		Assert.assertEquals("black wins. - with high card: Ace", GameRules.findTwoPair(playerOne.getHand(), playerTwo.getHand()));
		
	}

	@Test
	public void shouldReturnPair() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11), CardData.alias().get(11)));  
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(9), CardData.alias().get(9)));    
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8)));    
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));    
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));    
		                                                                                                                      
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(12), CardData.alias().get(12)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(11),CardData.alias().get(11)));   
		
		Assert.assertEquals("black wins. - with a pair: Nine's", GameRules.findPair(playerOne.getHand(), playerTwo.getHand()));
		
	}
	
	@Test
	public void shouldReturnHighestCardIfBothHavePair() {
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(9), CardData.alias().get(9)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(12), CardData.alias().get(12)));   
		                                                                                                                     
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(12), CardData.alias().get(12))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(11),CardData.alias().get(11)));  
		
		Assert.assertEquals("black wins. - with high card: King", GameRules.findPair(playerOne.getHand(), playerTwo.getHand()));
		
	}

	@Test
	public void shouldReturnTieIfBothHavePairAndSameHighestCard() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11), CardData.alias().get(11)));
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(9), CardData.alias().get(9)));  
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(12), CardData.alias().get(12)));  
		playerOne.addCardToHand(new Card(CardData.suit().get(0), null, CardData.value().get(7), CardData.alias().get(7)));  
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));  
		                                                                                                                    
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(7), CardData.alias().get(7)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(12), CardData.alias().get(12)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(9), CardData.alias().get(9)));  
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11),CardData.alias().get(11))); 
		
		Assert.assertEquals("tie", GameRules.findPair(playerOne.getHand(), playerTwo.getHand()));
		
	}
	
	@Test
	public void shouldReturnHighestCard() {
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(11), CardData.alias().get(11))); 
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(12), CardData.alias().get(12)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(8), CardData.alias().get(8)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerOne.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(6), CardData.alias().get(6)));   
		                                                                                                                     
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(7), CardData.alias().get(7)));   
		playerTwo.addCardToHand(new Card(CardData.suit().get(3), null, CardData.value().get(4), CardData.alias().get(4)));   
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(10), CardData.alias().get(10))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(1), null, CardData.value().get(12), CardData.alias().get(12))); 
		playerTwo.addCardToHand(new Card(CardData.suit().get(2), null, CardData.value().get(11),CardData.alias().get(11)));  
		
		Assert.assertEquals("black wins. - with high card: Queen", GameRules.findHighestCard(playerOne.getHand(), playerTwo.getHand()));
		
	}
	
}








