package mru.test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Figure;

class FigureTest {

	@Test
	void getClassifcationtest() {
		Figure figure= new Figure("1841754232","Spider-Man", "Toy Factory",15.99,4,"3","action");
		String expectedValue="Spider-Man";
		assertEquals(expectedValue,figure.getName());
	}
	
	@Test
	void toStringFigureTest() {
		Figure figure= new Figure("1897654231","G.I. Joe", "Toy Factory",54.25,5,"3","action");
		String expectedValue= "Category: Figure,  Serial Number: 1897654231, Name: G.I. Joe, Brand: Toy Factory. Price: 54.25, Availiable Count: 5, Age Appropriate: +3, Classification: A";
		assertEquals(expectedValue, figure.toString());
	}
	
	@Test
	void formatFigureTest() {
		Figure figure= new Figure("1897654231","G.I. Joe", "Toy Factory",54.25,5,"3","action");
		String expectedValue="1897654231;G.I. Joe;Toy Factory;54.25;5;3;A";
		assertEquals(expectedValue, figure.format());
		
	}

}
