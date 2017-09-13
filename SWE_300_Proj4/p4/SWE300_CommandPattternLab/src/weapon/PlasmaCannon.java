package weapon;

import lifeform.LifeForm;

/**
 * Plasma cannon class that implements weapon
 * @author Jake Moore Sam Selkregg Cade Reed
 */
public class PlasmaCannon extends GenericWeapon
{

	/**
	 * Constructor
	 * @param distance
	 */
	public PlasmaCannon()
	{
		baseDam = 50;
		maxRange = 20;
		maxShots = 1;
		maxAmmo = 4;
		currentShots = 0;
		currentAmmo = maxAmmo;
	}
	
	/**
	 * Calculates damage
	 * @return currentDam
	 */
	public int calculateDamage()
	{
		float dam;
		{
			float x = (float)currentAmmo/(float)maxAmmo;
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
