
public class ContinuingFractionAction implements Action
{
	public ContinuingFractionAction()
	{
		
	}
	
	public InterimResult execute(InterimResult x, char c)
	{
		double v = x.getV();
		double p = x.getP();
		v = v + p * (c - '0');
		p = p / 10;
		x.setV(v);
		x.setP(p);
		return x;
	}
}
