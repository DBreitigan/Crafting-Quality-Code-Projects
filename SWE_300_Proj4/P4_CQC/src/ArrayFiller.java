
/**
 * Class to practice breakpoints by count
 * @author Jake Moore
 */
public class ArrayFiller 
{	
	public void fillArray()
	{
		int[] arrayFilled = new int[10];
		for(int index = 0; index < 10; index++)
		{
			arrayFilled[index] = genRandom();
		}
	}
	
	public int genRandom()
	{
		double dRand = 10 * Math.random();
		return (int)dRand;
	}
}
