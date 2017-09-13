
public class StartFraction implements Action
{
	public StartFraction()
	{
		
	}
	
	public InterimResult execute(InterimResult x, char c)
	{
		x.setP(0.1);
		return x;
	}
}
