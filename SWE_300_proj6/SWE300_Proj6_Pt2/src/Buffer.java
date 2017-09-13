/**
 * a data store between two threads
 * 
 * @author Merlin
 *
 */
public class Buffer
{
	private Values[] x;
	
	//Create buffer and initialize the array of values it stores
	public Buffer(int size)
	{
		x = new Values[size];
		
		for(int i = 0; i < size; i++)
		{
			x[i] = new Values();
		}
		
	}
	/**
	 * write an int into this buffer
	 * 
	 * @param x
	 *            the int we should store
	 */
	public void write(Values x, int index)
	{
		synchronized(this)
		{
			this.x[index] = x;
		}
	}
	/**
	 * @return the next int in the buffer
	 */
	public Values read(int index)
	{
		synchronized(this)
		{
			return x[index];
		}
	}
	
	public void initializeBuffer()
	{
		
		for(int i = 0; i < x.length; i++)
		{
			int rand = (int)(1000 * Math.random() + 1);	
			x[i].setFirstVal(rand);
			x[i].setModdedVal(rand);
		}
	}
}
