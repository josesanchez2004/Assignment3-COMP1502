package mru.tsc.exceptions;
/**
 * This class is the minMaxPlayerException class, this class is made to handle exceptions for when a user enters the minimum amount of players allowed in a boardGame and that min amount of players is greater then the max amount of players. 
 * 
 * @author Jose Sanchez and Krithik Jaisanker 
 *
 */
public class minMaxPlayerException extends Exception {
	/**
	 * this is the constructor for the minMaxPlayerException class, it concatenates the super message with the passed parameter. 
	 * @param error
	 */
	public minMaxPlayerException(String error) {
		super("Wrong Input for Minimum and Maximum Players: "+error);
	}
}

