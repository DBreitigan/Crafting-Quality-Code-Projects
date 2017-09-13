
public class PeriodInputVerifier implements InputVerifier
{
	public PeriodInputVerifier()
	{
		
	}
	
	public boolean meetsCriteria(char c)
	{
		if(c == 46)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
