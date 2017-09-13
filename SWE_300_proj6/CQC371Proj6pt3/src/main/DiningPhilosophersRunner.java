package main;

import java.util.concurrent.Semaphore;

/**
 * @author Merlin
 *
 * Created:  Sep 26, 2006
 */
public class DiningPhilosophersRunner
{
	
	private static final int NUMBER_OF_PHILOSOPHERS = 5;
	static Semaphore semaphore = new Semaphore(NUMBER_OF_PHILOSOPHERS - 1);

	/**
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		for (int i=0;i<NUMBER_OF_PHILOSOPHERS;i++)
		{	
			Philosopher p = new Philosopher(i,i,(i+1)%NUMBER_OF_PHILOSOPHERS, semaphore);
			p.start();
		}
	}

}
