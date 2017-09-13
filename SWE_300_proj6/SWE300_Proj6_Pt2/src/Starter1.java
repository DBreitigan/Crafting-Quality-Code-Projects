import java.lang.reflect.InvocationTargetException;
/**
 * @author Merlin
 *
 * 
 */
public class Starter1
{
	/**
	 * The number of iterations each behavior should do
	 */
	public static final int NUMBER_OF_BUFFERS = 5;
	public static final int NUMBER_OF_TRIALS = 10000;
	private String[] behaviors =
	{"MultiplyBy3Behavior", "AddBy6Behavior", "DivideBy3Behavior", "SubFirstNumberBehavior"};
	private Buffer buffer;
	/**
	 * spawn off all of the behaviors giving them appropriate input and output
	 * buffers
	 * 
	 * 
	 * @throws ClassNotFoundException
	 *             shouldn't
	 * @throws NoSuchMethodException
	 *             shouldn't
	 * @throws SecurityException
	 *             shouldn't
	 * @throws InstantiationException
	 *             shouldn't
	 * @throws IllegalAccessException
	 *             shouldn't
	 * @throws IllegalArgumentException
	 *             shouldn't
	 * @throws InvocationTargetException
	 *             shouldn't
	 * @throws InterruptedException
	 *             shouldn't
	 */
	public Starter1() throws ClassNotFoundException, NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InterruptedException
	{
		doOperation();
	}
	
	private synchronized void doOperation() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			InterruptedException {
		
		Thread threads[] = new Thread[behaviors.length];
		
		Buffer[] buffers = new Buffer[NUMBER_OF_BUFFERS];
		
		Semaphore[] semaphores = new Semaphore[NUMBER_OF_BUFFERS];
		
		for(int i = 0; i < NUMBER_OF_BUFFERS; i++)
		{
			semaphores[i] = new Semaphore();
			buffers[i] = new Buffer(NUMBER_OF_TRIALS);
			
			if (i == 0)
			{
				buffers[i].initializeBuffer();
			}
		}
				
		//buffer.write(1, 1);
		for (int i = 0; i < behaviors.length; i++)
		{
			Class<?> behavior = Class.forName(behaviors[i]);
			if(i == 0)
			{
				semaphores[i].take();
			}
			if(i == behaviors.length - 1)
			{
				threads[i] = new Modifier(i, buffers[i], buffers[i + 1], (MathBehavior) behavior.getConstructor().newInstance(), semaphores[i], semaphores[0]);
			}
			else
			{
				threads[i] = new Modifier(i, buffers[i], buffers[i + 1], (MathBehavior) behavior.getConstructor().newInstance(), semaphores[i], semaphores[i + 1]);
			}
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++)
		{
			threads[i].join();
		}
		//ConstantChecker checker = new ConstantChecker(buffer, NUMBER_OF_TRIALS
				//* (behaviors.length ) + 1);
		ConstantChecker checker = new ConstantChecker(buffers[NUMBER_OF_BUFFERS - 1], 2, NUMBER_OF_TRIALS);
		checker.check();
	}
	/**
	 * @param args
	 *            none
	 * @throws InvocationTargetException
	 *             shouldn't
	 * @throws IllegalArgumentException
	 *             shouldn't
	 * @throws IllegalAccessException
	 *             shouldn't
	 * @throws InstantiationException
	 *             shouldn't
	 * @throws SecurityException
	 *             shouldn't
	 * @throws NoSuchMethodException
	 *             shouldn't
	 * @throws ClassNotFoundException
	 *             shouldn't
	 * @throws InterruptedException
	 *             shouldn't
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InterruptedException
	{
		new Starter1();
	}
}