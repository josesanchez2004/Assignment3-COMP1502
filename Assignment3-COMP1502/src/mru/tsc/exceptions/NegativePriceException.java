package mru.tsc.exceptions;
/**
 * This class is the NegativePriceExecption class, this class is made to handle exceptions for when a user enters a price that is negative when adding a toy. 
 * @author Jose Sanchez and Krithik Jaisanker 
 *
 */
public class NegativePriceException extends Exception {

	/**
	 * this is the constructor for the NegativePriceException class, it concatenates the super message with the passed parameter. 
	 * @param error
	 */
	public NegativePriceException(String error) {
		super("The input price is wrong : "+error);
	}
}
