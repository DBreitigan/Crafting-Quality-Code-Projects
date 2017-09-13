package exceptions;
/**
 * Direction Exception Class
 * @author Jake Moore
 */
public class DirectionException extends Exception
{
	String message = "Must enter a directional character.";
	
	public DirectionException()
	{
		System.out.println(message);
	}
}
