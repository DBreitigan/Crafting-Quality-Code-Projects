
public class NegateAction implements Action
{
	public NegateAction()
	{
		
	}
	
	public InterimResult execute(InterimResult x, char c)
	{
		x.setS(-1);
		return x;
	}
}
