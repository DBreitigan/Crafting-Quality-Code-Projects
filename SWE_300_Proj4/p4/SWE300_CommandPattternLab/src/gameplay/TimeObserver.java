package gameplay;
import lifeform.LifeForm;

/**
 * Interface made to observe the time clock
 * @author Jake Moore
 */
public interface TimeObserver
{
	/**
	 * Updates the time 
	 * @param time
	 */
	public void updateTime(int time);
}
