package mru.tsc.model;
/**
 * Figure is a subclass of the Toy class, it is inheriting the Toy traits. This class contains its own characteristics.
 * @author Jose Sanchez and Krithik Jaisanker 
 *
 */
public class Figure extends Toy {

	private String classficiation; 
	/**
	 *  this is the constructor for the Figure class, it assigns the generalized traits as well as specific traits.
	 * @param SN
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param classification
	 */
	public Figure(String SN, String name, String brand, double price, int availableCount, String ageAppropriate,String classification) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.classficiation=classification.substring(0,1).toUpperCase();
		
	}
	/**
	 * getClassification returns the classification of the Figure Toy
	 * @return classification 
	 */
	public String getClassification() {
		return classficiation;
	}
	/**
	 * the toString method for Figure class, converts information into readable human form. 
	 */
	public String toString() {
		return "Category: Figure, "+ " Serial Number: "+getSN()+", Name: "+getName()+", Brand: "+getBrand()+". Price: "+getPrice()+", Availiable Count: "+getAvailableCount()+", Age Appropriate: "+"+"+getAgeAppropriate()+", Classification: "+getClassification();
		
	}
	/**
	 * the format method for Figure class, formats the information in the proper way for the txt.file.
	 */
	public String format() {
		return getSN()+";"+getName()+";"+getBrand()+";"+getPrice()+";"+getAvailableCount()+";"+getAgeAppropriate()+";"+getClassification();
		}
}
