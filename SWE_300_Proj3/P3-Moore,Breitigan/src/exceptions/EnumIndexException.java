package exceptions;

public class EnumIndexException extends Exception
{
	public EnumIndexException()
	{
		System.out.println("Enum index does not exist");
	}
}
