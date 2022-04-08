package mru.tsc.model;
/**
 * Animal is a subclass of the Toy class, it is inheriting the Toy traits. This class contains its own characteristics.
 * @author Jose Sanchez and Krithik Jaisanker 
 *
 */
public class Animal extends Toy {

	private String material;
	private String size;
	/**
	 *  this is the constructor for the Animal class, it assigns the generalized traits as well as specific traits.
	 * @param SN
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param material
	 * @param size
	 */
	public Animal(String SN, String name, String brand, double price, int availableCount, String ageAppropriate, String material, String size ) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.material=material;
		this.size=size.substring(0,1).toUpperCase();
	}
	/**
	 * getMaterial returns the material of the Animal Toy
	 * @return material
	 */
	public String getMaterial() {
		return material; 
	}
	/**
	 * getSize returns the size of the Animal Toy
	 * @return size
	 */
	public String getSize() {
		return size; 
	}
	/**
	 * the toString method for Animal class, converts information into readable human form.
	 */
	public String toString() {
		return "Category: Animal, "+ " Serial Number: "+getSN()+", Name: "+getName()+", Brand: "+getBrand()+". Price: "+getPrice()+", Availiable Count: "+getAvailableCount()+", Age Appropriate: "+"+"+getAgeAppropriate()+", Material: "+getMaterial()+", Size: "+getSize();
	}
	/**
	 * the format method for Animal class, formats the information in the proper way for the txt.file.
	 */
	public String format() {
		return getSN()+";"+getName()+";"+getBrand()+";"+getPrice()+";"+getAvailableCount()+";"+getAgeAppropriate()+";"+getMaterial()+";"+getSize();
		}
	
}
