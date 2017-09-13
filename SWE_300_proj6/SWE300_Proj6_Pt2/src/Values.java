/**
 * Class that holds intermediate value
 */
public class Values 
{
	private int firstVal;
	private int moddedVal;
	
	public Values()
	{
		this.firstVal = 0;
		this.moddedVal = 0;
	}

	public Values(int firstVal, int moddedVal)
	{
		this.firstVal = firstVal;
		this.moddedVal = moddedVal;
	}
	
	public int getFirstVal() 
	{
		return firstVal;
	}

	public void setFirstVal(int firstVal) 
	{
		this.firstVal = firstVal;
	}

	public int getModdedVal() 
	{
		return moddedVal;
	}

	public void setModdedVal(int moddedVal) 
	{
		this.moddedVal = moddedVal;
	}
}
