package mru.test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Animal;

class AnimalTest {

	@Test
	void getMaterialTest() {
		Animal animal= new Animal("5473884231","Horse","Leego",143.00,6,"6","Cotton","Medium");
		String expectedValue="M";
		assertEquals(expectedValue, animal.getSize());
	}
	
	@Test
	void getSizeTest() {
		Animal animal= new Animal("5473884231","Horse","Leego",143.00,6,"6","Cotton","Medium");
		String expectedValue="5473884231";
		assertEquals(expectedValue, animal.getSN());
	}
	
	@Test
	void toStringFigureTest() {
		Animal animal= new Animal("2473684239","Bear","Leego",176.0,1,"5","Cotton","Large");
		String expectedValue="Category: Animal,  Serial Number: 2473684239, Name: Bear, Brand: Leego. Price: 176.0, Availiable Count: 1, Age Appropriate: +5, Material: Cotton, Size: L";
		assertEquals(expectedValue,animal.toString());
	}
	
	@Test
	void formatAnimalTest() {
		Animal animal= new Animal("2473684239","Bear","Leego",176.0,1,"5","Cotton","Large");
		String expectedValue="2473684239;Bear;Leego;176.0;1;5;Cotton;L";
		assertEquals(expectedValue, animal.format());
		
	}
	

}
