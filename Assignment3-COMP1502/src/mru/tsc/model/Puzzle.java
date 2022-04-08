package mru.tsc.model;
/**
 * Puzzle is a subclass of the Toy class, it is inheriting the Toy traits. This class contains its own characteristics.
 * @author Jose Sanchez and Krithik Jaisanker 
 *
 */
public class Puzzle extends Toy {

	private String puzzleType;
	
	/**
	 * this is the constructor for the Puzzle class, it assigns the generalized traits as well as specific traits.
	 * @param SN
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param puzzleType
	 */
	public Puzzle(String SN, String name, String brand, double price, int availableCount, String ageAppropriate, String puzzleType) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.puzzleType=puzzleType;
	}
	/**
	 * returns the puzzleType for the Toy 
	 * @return puzzleType
	 */
	public String getPuzzleType() {
		return puzzleType;
		
	}
	
	/**
	 * the toString method for Puzzle class, converts information into readable human form. 
	 */
	public String toString() {
		return "Category: Puzzle, "+ " Serial Number: "+getSN()+", Name: "+getName()+", Brand: "+getBrand()+", Price: "+getPrice()+", Availiable Count: "+getAvailableCount()+", Age Appropriate: "+"+"+getAgeAppropriate()+", Puzzle-Type: "+getPuzzleType();
		
	}
	/**
	 * the format method for Puzzle class, formats the information in the proper way for the txt.file.
	 */
	public String format() {
		return getSN()+";"+getName()+";"+getBrand()+";"+getPrice()+";"+getAvailableCount()+";"+getAgeAppropriate()+";"+getPuzzleType();
		}

}

