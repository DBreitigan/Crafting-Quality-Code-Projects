
public class ContinuingIntegerAction implements Action
{
	public ContinuingIntegerAction()
	{
		
	}
	
	public InterimResult execute(InterimResult x, char c)
	{
		double v = x.getV();
		x.setV(10 * v + (c - '0'));
		return x;
	}

}
