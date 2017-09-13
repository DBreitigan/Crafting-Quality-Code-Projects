package recovery;
import lifeform.LifeForm;

/**
 * No recovery happens
 * @author Jake Moore
 */
public class RecoveryNone implements RecoveryBehavior
{
	/**
	 * Constructor method
	 */
	public RecoveryNone()
	{
	}
	
	/**
	 * calculates the recovery 
	 * @param currentLife
	 * @param maxLife
	 * @return the life points after the recovery
	 */
	public int calculateRecovery(int currentLife, int maxLife)
	{
		int lifeRecovered = 0;
		return currentLife + lifeRecovered;
	}
}
