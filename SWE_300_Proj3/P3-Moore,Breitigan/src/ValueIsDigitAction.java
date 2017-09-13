import org.omg.PortableServer.POAManagerPackage.State;

public class ValueIsDigitAction implements Action
{
	public ValueIsDigitAction()
	{
		
	}
	
	public InterimResult execute(InterimResult x, char c)
	{
		x.setV(c - '0');
		return x;
	}
}
