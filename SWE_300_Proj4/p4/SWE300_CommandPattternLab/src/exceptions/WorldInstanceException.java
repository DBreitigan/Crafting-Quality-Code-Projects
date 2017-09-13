package exceptions;

public class WorldInstanceException extends Exception
{
	String message = "A World Instance already exists";
	
	public WorldInstanceException()
	{
		System.out.println(message);
	}
}
