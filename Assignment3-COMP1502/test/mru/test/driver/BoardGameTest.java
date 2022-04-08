package mru.test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.BoardGame;

class BoardGameTest {

	@Test
	void getMinNumOfPlayersTest() {
		BoardGame game= new BoardGame("7565853438","Ama","Board Gamers",59.99,6,"8",1,8,"Michael King, John Smith");
		int expectedValue=1;
		assertEquals(expectedValue, game.getMinNumOfPlayers());
		
	}
	@Test 
	void getMaxNumOfPlayersTest() {
		BoardGame game= new BoardGame("7565853438","Ama","Board Gamers",59.99,6,"8",2,4,"Michael King, John Smith");
		int expectedValue=4;
		assertEquals(expectedValue, game.getMaxNumOfPlayers());
	}
	@Test
	void getDesignerTest() {
		BoardGame game= new BoardGame("7565853438","Ama","Board Gamers",59.99,6,"8",2,4,"Jose Sanchez, Sanchez Jose");
		String expectedValue= "Jose Sanchez, Sanchez Jose";
		assertEquals(expectedValue,game.getDesigner());
	}
	
	
	@Test
	void formatBoardGameTest() {
		BoardGame game= new BoardGame("7565853438","Ama","Board Gamers",59.99,6,"8",2,4,"Michael King, John Smith");
		String expectedValue="7565853438;Ama;Board Gamers;59.99;6;8;2-4;Michael King, John Smith";
		assertEquals(expectedValue, game.format());
	}
	
	@Test
	void toStringBoardGameTest() {
		BoardGame game= new BoardGame("7565853438","Ama","Board Gamers",59.99,6,"8",2,4,"Michael King, John Smith");
		String expectedValue="Category: BoardGame,  Serial Number: 7565853438, Name: Ama, Brand: Board Gamers. Price: 59.99, Availiable Count: 6, Age Appropriate: +8, Minimum Number Of Players: 2, Maximum Number Of Players: 4, Designer(s): Michael King, John Smith";
		assertEquals(expectedValue, game.toString());
		
	}
}
