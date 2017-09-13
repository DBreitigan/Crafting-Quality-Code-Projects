package gameplay;
import java.util.ArrayList;
import lifeform.LifeForm;

/**
 * Simple timer that keeps track of what round it is
 * @author Jake Moore
 */
public class SimpleTimer extends Thread implements Timer
{
	/**
	 * Instance Variables
	 */
	private int round;
	private ArrayList<TimeObserver> theObservers = new ArrayList<TimeObserver>();
	private int numberOfObservers;
	private int currentTime;
	
	/**
	 * Constructor
	 * @param time
	 */
	public SimpleTimer(int time)
	{
		currentTime = time;
	}
	
	/**
	 * Adding the time observer to the Timer
	 * @param observer
	 */
	public void addTimeObserver(TimeObserver observer)
	{
		theObservers.add(observer);
		numberOfObservers++;
	}
	
	/**
	 * Remove time observer from the timer
	 * @param observer
	 */
	public void removeTimeObserver(TimeObserver observer)
	{
		theObservers.remove(observer);
		numberOfObservers--;
	}
	
	/**
	 * getter for round
	 * @return round
	 */
	public int getRound()
	{
		return round;
	}
	/**
	 * keeps track of what round the game is in
	 */
	public void timeChanged()
	{
		round++;
		for(int i = 0; i < numberOfObservers; i++)
		{
			TimeObserver observer =  theObservers.get(i);
			observer.updateTime(round);
		}
	}
	
	/**
	 * Starts the timer
	 */
	public void run()
	{
		try
		{
			for(int i = 0; i < 50; i++)
			{
				Thread.sleep(currentTime);
				timeChanged();
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("InterruptedException thrown. Ya done Goofed!");
		}
	}
	
}
