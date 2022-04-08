package mru.test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Puzzle;

class PuzzleTest {

	@Test
	void getPuzzleTypeTest() {
		Puzzle p=new Puzzle("4865567899","Jigsaw","Strong Brain",43.55,100,"14","mechanical");
		String expectedValue="Strong Brain";
	 assertEquals(expectedValue,p.getBrand());
	}
	
	@Test
	void toStringPuzzleTest() {
		Puzzle p=new Puzzle("1234567899","Jigsaw","Strong Brain",39.99,9,"7","mechanical");
		String expectedValue="Category: Puzzle,  Serial Number: 1234567899, Name: Jigsaw, Brand: Strong Brain, Price: 39.99, Availiable Count: 9, Age Appropriate: +7, Puzzle-Type: mechanical";
		assertEquals(expectedValue,p.toString());
	}
	
	@Test
	void formatPuzzleTest() {
		Puzzle p=new Puzzle("1234567899","Jigsaw","Strong Brain",39.99,9,"7","mechanical");
		String expectedValue= "1234567899;Jigsaw;Strong Brain;39.99;9;7;mechanical";
		assertEquals(expectedValue, p.format());
	}

}
