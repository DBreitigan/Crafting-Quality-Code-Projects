package recovery;

/**
 * Recovers a specific amount of lifePoints
 * @author Jake Moore
 */
public class RecoveryLinear implements RecoveryBehavior
{
	/**
	 * Instance Variables
	 */
	protected int recoveryStep;
	
	/**
	 * Constructor for the amount of points recovered
	 * @param step
	 */
	public RecoveryLinear(int step)
	{
		recoveryStep = step;
	}
	
	/**
	 * calculates the amount of points recovered 
	 * @param currentLife
	 * @param maxLife
	 * @return the current life after the recovery
	 */
	public int calculateRecovery(int currentLife, int maxLife)
	{
		int newLife = currentLife + recoveryStep;
		
		if(newLife >= maxLife)
		{
			newLife = maxLife;
		}
		
		if(currentLife == 0)
		{
			newLife = 0;
		}
		
		return newLife;
	}
}
