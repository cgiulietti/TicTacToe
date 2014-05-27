package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Game.TicTacToeLogic;

public class TicTacToeTest {

	public TicTacToeLogic game;
	
    @Before
    public void setUp() throws Exception {
        game = new TicTacToeLogic();
    }

    @Test
    public void testPlayer1Wins() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(true,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(game.PLAYER1,game.getWinner());
    	
    }

    @Test
    public void testPlayer2Wins() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(true,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(game.PLAYER2,game.getWinner());
    	
    }
    
    @Test
    public void testTiedGame() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
    	assertEquals(true,game.makeMoveAndCheckIfOver(2, 0));
    	assertNull(game.getWinner());
    	
    }
    
}
