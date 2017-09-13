
/**
 * Multiplies implemented number by 3
 * @author Jake
 *
 */
public class MultiplyBy3Behavior implements MathBehavior {

	@Override
	public Values doMath(Values in) 
	{
		int m = in.getModdedVal();
		m = m * 3;
		in.setModdedVal(m);
		return in;
	}

}
