
public class DigitInputVerifier implements InputVerifier
{
	public DigitInputVerifier()
	{

	}

	public boolean meetsCriteria(char c)
	{
		if(c >= 48 && c <= 57)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
