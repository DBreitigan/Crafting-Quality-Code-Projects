
/**
 * Add by 6
 * @author Jake
 *
 */
public class AddBy6Behavior implements MathBehavior
{

	@Override
	public Values doMath(Values in) 
	{
		int m = in.getModdedVal();
		m = m + 6;
		in.setModdedVal(m);
		return in;
	}

}
