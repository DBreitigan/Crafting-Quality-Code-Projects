package exceptions;
import lifeform.Alien;

/**
 * Exception class for throwing exceptions
 * @author Jake Moore
 */
public class MyNewException extends Exception
{	
	public MyNewException(String message)
	{
		super(message);
	}
}
