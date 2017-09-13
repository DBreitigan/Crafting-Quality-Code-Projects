/**
 * Reads from an input buffer, increments and writes to an output buffer unless
 * it is number 0. In that case, it just writes increasing integers to the
 * output buffer
 * 
 * @author Merlin
 *
 */
public class Modifier extends Thread
{
	private Integer myNum;
	private Buffer inBuffer;
	private Buffer outBuffer;
	private MathBehavior behavior;
	private Semaphore receiveSem;
	private Semaphore sendSem;
	/**
	 * Create an incrementer
	 * 
	 * @param myNum
	 *            ignored unless it is zero
	 * @param inBuffer
	 *            the buffer to read from
	 * @param outBuffer
	 *            the buffer to write to
	 * @param semaphores2 
	 * @param Inputsemap 
	 */
	public Modifier(Integer myNum, Buffer inBuffer, Buffer outBuffer, MathBehavior behavior, Semaphore receiveSem, Semaphore sendSem)
	{
		this.myNum = myNum;
		this.inBuffer = inBuffer;
		this.outBuffer = outBuffer;
		this.behavior = behavior;
		this.receiveSem = receiveSem;
		this.sendSem = sendSem;
	}
	/**
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		for (int i = 0; i < Starter1.NUMBER_OF_TRIALS; i++)
		{
				try {
					this.receiveSem.release();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Values inputtedValue = inBuffer.read(i);
				outBuffer.write(behavior.doMath(inputtedValue), i);
				
				this.sendSem.take();
		}
	}
}