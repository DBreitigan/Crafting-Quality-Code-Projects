package weapon;

import lifeform.LifeForm;

/**
 * Pistol class that implements the weapon type
 * @author Jake Moore Sam Selkregg Cade Reed
 */
public class Pistol extends GenericWeapon
{
	/**
	 * Constructor
	 * @param distance
	 */
	public Pistol()
	{
		baseDam = 10;
		maxRange = 25;
		maxShots = 2;
		maxAmmo = 10;
		currentShots = 0;
		currentAmmo = maxAmmo;
	}
	
	/**
	 * Calculate damage method
	 * @return currentDam
	 */
	public int calculateDamage()
	{
		float dam;
		{
			int x = maxRange - currentRange + 5;
			float y = (float)x/(float)maxRange;
			float z = (float)baseDam * y;

			if(z < 1)
			{
				z = 1;
			}
			dam = z;
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
