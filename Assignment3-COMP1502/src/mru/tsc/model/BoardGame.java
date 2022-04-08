package mru.tsc.model;
/**
 * BoardGame is a subclass of the Toy class, it is inheriting the Toy traits. This class contains its own characteristics.
 * @author Jose Sanchez and Krithik Jaisanker 
 *
 */
public class BoardGame extends Toy {

	private int minNumOfPlayers;
	private int maxNumOfPlayers;
	private String designer; 
	
	/**
	 * this is the constructor for the BoardGame class, it assigns the generalized traits as well as specific traits.
	 * @param SN
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param minNumOfPlayers
	 * @param maxNumOfPlayers
	 * @param designer
	 */
	public BoardGame(String SN, String name, String brand, double price, int availableCount, String ageAppropriate, int minNumOfPlayers,int maxNumOfPlayers, String designer) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.minNumOfPlayers=minNumOfPlayers;
		this.maxNumOfPlayers=maxNumOfPlayers;
		this.designer=designer;
	}
	/**
	 * getMinNumOfPlayers returns the minimum number of BoardGame players for Toy. 
	 * @return minNumOfPlayers
	 */
	public int getMinNumOfPlayers() {
		return minNumOfPlayers;
	}
	/**
	 * getMaxNumOfPlayers returns the maximum number of BoardGame players for Toy. 
	 * @return maxNumOfPlayers
	 */
	public int getMaxNumOfPlayers() {
		return maxNumOfPlayers;
	}
	
	/**
	 * getDesigner returns the Designer(s) of the BoardGame Toy. 
	 * @return designer
	 */
	public String getDesigner() {
		return designer;
	}
	/**
	 * the toString method for BoardGame class, converts information into readable human form. 
	 */
	public String toString() {
		return "Category: BoardGame, "+ " Serial Number: "+getSN()+", Name: "+getName()+", Brand: "+getBrand()+". Price: "+getPrice()+", Availiable Count: "+getAvailableCount()+", Age Appropriate: "+"+"+getAgeAppropriate()+ ", Minimum Number Of Players: "+getMinNumOfPlayers()+", Maximum Number Of Players: "+getMaxNumOfPlayers()+", Designer(s): "+getDesigner();
		
	}
	
	/**
	 * the format method for BoardGame class, formats the information in the proper way for the txt.file.
	 */
	public String format() {
		return getSN()+";"+getName()+";"+getBrand()+";"+getPrice()+";"+getAvailableCount()+";"+getAgeAppropriate()+";"+getMinNumOfPlayers()+"-"+getMaxNumOfPlayers()+";"+getDesigner();
		}
	

}
