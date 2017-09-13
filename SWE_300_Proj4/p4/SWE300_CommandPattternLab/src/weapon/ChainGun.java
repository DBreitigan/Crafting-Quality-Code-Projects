package weapon;
import lifeform.LifeForm;

/**
 * Chain gun class that implements Weapon
 * @author Jake Moore Sam Selkregg Cade Reed
 */
public class ChainGun extends GenericWeapon
{

	/**
	 * Constructor
	 * @param distance
	 */
	public ChainGun()
	{
		baseDam = 15;
		maxRange = 30;
		maxShots = 4;
		maxAmmo = 40;
		currentShots = 0;
		currentAmmo = maxAmmo;
	}
	
	/**
	 * Calculate Damage
	 * @return currentDam
	 */
	public int calculateDamage()
	{
		float dam;
		{
			float x = (float)currentRange/(float)maxRange;
			float y = (float)baseDam * x;
			if(y < 1)
			{
				y = 1;
			}
			dam = y;
		}
		currentDam = (int)dam;
		if(currentRange > maxRange)
		{
			currentDam = 0;
		}
		return currentDam;
	}

	@Override
	public int getNumberOfAttachments() 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}
