package gameplay;

/**
 * Creates the timer interface
 * @author Jake Moore
 */
public interface Timer 
{
	public void addTimeObserver(TimeObserver observer);
	public void removeTimeObserver(TimeObserver observer);
	public void timeChanged();
	public int getRound();
}
