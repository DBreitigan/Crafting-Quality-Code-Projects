package weapon;

import lifeform.LifeForm;

/**
 * Power Booster attachment
 * @author Jake Moore Sam Selkregg Cade Reed
 *
 */
public class PowerBooster extends Attachment 
{
	int currentDam;
	int currentAmmo;
	int currentRange;
	int maxAmmo;
	
	/**
	 * Power Booster constructor
	 * @param weapon
	 */
	public PowerBooster(Weapon weapon)
	{
		if(numberOfAttachments <= 2)
		{
			newWeapon = weapon;
			currentDam = newWeapon.calculateDamage();
			currentAmmo = newWeapon.getCurrentAmmo();
			currentRange = newWeapon.getCurrentLocation();
			maxAmmo = newWeapon.getMaxAmmo();
			numberOfAttachments++;
		}
		else
		{
			numberOfAttachments = 2;
		}
	}

	
	public int calculateDamage()
	{	
		if(numberOfAttachments < 2)
		{
			float powerBoosterDam;
			{	
				float x = (float)currentAmmo/(float)maxAmmo;
				float y = 1 + x;
				float z = currentDam * y;
				powerBoosterDam = z;
			}
			if(numberOfAttachments == 1)
			{
				currentDam = (int)powerBoosterDam;
			}
			else
			{
				currentDam = currentDam + (int)powerBoosterDam;
			}
			
		}
		return currentDam;
	}

	public int getMaxRange()
	{
		return newWeapon.getMaxRange();
	}
	
	public int getCurrentDam()
	{
		return newWeapon.calculateDamage();
	}
	
	public int getCurrentRange()
	{
		return newWeapon.getCurrentLocation();
	}
	
	public int getCurrentAmmo()
	{
		return newWeapon.getCurrentAmmo();
	}
	
	public int getMaxAmmo()
	{
		return newWeapon.getMaxAmmo();
	}
	/**
	 * Getter for newWeapon
	 * @return newWeapon
	 */
	public Weapon getNewWeapon()
	{
		return newWeapon;
	}


	@Override
	public void fire(LifeForm victim, int distance) 
	{
		calculateDamage();
		
	}


	@Override
	public void reload() 
	{
		currentAmmo = newWeapon.getMaxAmmo();
	}


	@Override
	public void modifyMaxRange(int newRange) 
	{
		
		
	}

	@Override
	public int getCurrentLocation() 
	{
		return getCurrentRange();
	}


	@Override
	public void updateLocation(int range) 
	{
		currentRange = range;
		
	}


	@Override
	public void updateTime(int time) 
	{
		
	}


	@Override
	public int getNumberOfAttachments() 
	{
		// TODO Auto-generated method stub
		return newWeapon.getNumberOfAttachments();
	}

}
