/**
 * @author Merlin
 *
 */
public class ConstantChecker
{
	private Buffer buffer;
	private int value;
	private int NUMBER_OF_TRIALS;
	/**
	 * @param buffer the buffer
	 * @param value the value we expect it to have
	 */
	public ConstantChecker(Buffer buffer, Integer value, Integer NUMBER_OF_TRIALS)
	{
		super();
		this.buffer = buffer;
		this.value = value;
		this.NUMBER_OF_TRIALS = NUMBER_OF_TRIALS;
	}
	/**
	 * 
	 */
	public void check()
	{
		for(int i = 0; i < NUMBER_OF_TRIALS; i++)
		{
			int data = buffer.read(i).getModdedVal();
			if (data != value)
			{
				System.out.println("Buffer error: data " + data);
			} else
			{
				System.out.println("No error: Data " + data + " | init number: " + buffer.read(i).getFirstVal());
			}
			
		}
	}
		
}