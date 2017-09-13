
public class SubFirstNumberBehavior implements MathBehavior
{
	public Values doMath(Values in)
	{
		int firstNum = in.getFirstVal();
		int m = in.getModdedVal();
		m = m - firstNum;
		in.setModdedVal(m);
		return in;
	}
}
