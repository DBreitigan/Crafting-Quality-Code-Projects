
public class MinusInputVerifier implements InputVerifier 
{
	public MinusInputVerifier()
	{
		
	}
	
	public boolean meetsCriteria(char c)
	{
		if(c == 45)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
