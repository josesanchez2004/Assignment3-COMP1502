package mru.tsc.model;
/**
 * Toy class is an abstract super class that contains the generalized traits of all Toys(boardgames, puzzles, animals, and figures). It also contains 2 abstract methods called format() and toString().
 * @author Jose Sanchez and Krithik Jaisanker
 *
 */
public abstract class Toy {

private String SN;
private String name;
private String brand; 
private double price; 
private int availableCount;
private String ageAppropriate;

/**
 * Toy is the super class constructor, it takes in parameters and assigns them to its private fields.
 * @param SN
 * @param name
 * @param brand
 * @param price
 * @param availableCount
 * @param ageAppropriate
 */
public Toy(String SN, String name,String brand, double price, int availableCount, String ageAppropriate) {
	
	this.SN=SN;
	this.name=name;
	this.brand=brand; 
	this.price=price; 
	this.availableCount=availableCount;
	this.ageAppropriate=ageAppropriate;
	
}
/**
 * getSN returns the SN (serial number) of the Toy
 * @return SN
 */
public String getSN() {
	return SN;
}

/**
 *  getName returns the name of the Toy
 * @return name
 */
public String getName() {
	return name; 
}

/**
 * getBrand returns the brand of the Toy
 * @return
 */
public String getBrand() {
	return brand;
}
/**
 * getPrice returns the price of the Toy
 * @return price
 */
public double getPrice() {
	return price;
}
/**
 * setAvailableCount sets the available count of the Toy
 * @param availableCount
 */
public void setAvailableCount(int availableCount) {
	this.availableCount=availableCount;
}
/**
 * getAvailableCount returns the available count of the Toy
 * @return availableCount
 */
public int getAvailableCount() {
	return availableCount;
}
/**
 * getAgeAppropriate returns the appropriate age of the Toy
 * @return ageAppropriate
 */
public String getAgeAppropriate() {
	return ageAppropriate; 
}

/**
 * toString is an abstract method that is overridden in all other subclasses
 */
public abstract String toString();

/**
 * format is an abstract method that is overridden in all other subclasses
 */
public abstract String format();

}
