/**
 * Behavior for add
 * @author Jake Moore
 */
public class AddBehavior implements MathBehavior
{
	@Override
	public Values doMath(Values in)
	{
		int m = in.getModdedVal();
		m = m + 1;
		in.setModdedVal(m);
		return in;
	}
}
