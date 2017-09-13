package exceptions;

/**
 * Array out of bounds exception
 * @author Jake Moore
 */
public class EnvironmentOutOfBoundsException extends Exception
{
	String message = "EnvironmentOutOfBoundsException: Location entered is outside of the bounds of Environment";
	
	public EnvironmentOutOfBoundsException()
	{
		System.out.println(message);
	}
}
