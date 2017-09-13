package recovery;

/**
 * Interface that helps determine how an Alien recovers health
 * @author Jake Moore
 */
public interface RecoveryBehavior 
{
	/**
	 * Calculates the recovery depending on how the Alien will recover health
	 * @param currentLife
	 * @param maxLife
	 * @return the new lifepoints
	 */
	public int calculateRecovery(int currentLife, int maxLife);
}
