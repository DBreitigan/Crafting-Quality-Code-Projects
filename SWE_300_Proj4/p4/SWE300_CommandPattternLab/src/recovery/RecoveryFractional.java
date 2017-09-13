package recovery;

public class RecoveryFractional implements RecoveryBehavior
{
	/**
	 * Instance Variables
	 */
	protected double percentRecovery;
	
	/**
	 * Constructor
	 * @param percent
	 */
	public RecoveryFractional(double percent)
	{
		percentRecovery = percent;
	}
	
	public int calculateRecovery(int currentLife, int maxLife)
	{
		double r = percentRecovery * currentLife;
		int recovery = (int)r;
		if(currentLife%10 != 0)
		{
			while(recovery%10 != 0)
			{
				recovery++;
			}
		}
		int newLife = recovery + currentLife;
		if(currentLife == 0)
		{
			newLife = 0;
		}
		if(newLife >= maxLife)
		{
			newLife = maxLife;
		}
		
		return newLife;
		
	}
}
