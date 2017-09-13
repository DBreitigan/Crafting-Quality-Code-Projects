package weapon;
import lifeform.LifeForm;
import weapon.GenericWeapon;
import weapon.Weapon;
/**
 * Scope Class
 * @author Jake Moore Sam Selkregg Cade Reed
 */
public class Scope extends Attachment
{
	int currentDam;
	int currentAmmo;
	int targetDistance;
	int maxAmmo;
	int maxRange;
	
	/**
	 * Scope Constructor
	 * @param weapon
	 */
	public Scope(Weapon weapon)
	{
		if(numberOfAttachments <= 2)
		{
			newWeapon = weapon;
			currentDam = newWeapon.calculateDamage();
			currentAmmo = newWeapon.getCurrentAmmo();
			targetDistance = newWeapon.getCurrentLocation();
			maxAmmo = newWeapon.getMaxAmmo();
			maxRange = newWeapon.getMaxRange();
			numberOfAttachments++;
		}
	}
	
	/**
	 * Modifies the damage with said attachment
	 * @param newWeapon
	 * @return currentDam
	 */
	public int calculateDamage()
	{	
		if(numberOfAttachments < 2)
		{
			int newMaxRange = maxRange + 10;
			
			if((maxRange < targetDistance) && (targetDistance <= newMaxRange))
			{
				currentDam = currentDam + 5;
			}
			if(targetDistance <= maxRange)
			{
				float scopeDam;
				{
					float w = (float)newMaxRange - (float)targetDistance;
					float x = w/(float)newMaxRange;
					float y = 1 + x;
					float z = (float)currentDam * y;
					scopeDam = z;
				}
				maxRange = newMaxRange;
				if(numberOfAttachments == 1)
				{
					currentDam = (int)scopeDam;
				}
				else
				{
					currentDam = currentDam + (int)scopeDam;
				}
			}
		}
		return currentDam;
	}

	public int getMaxRange()
	{
		return newWeapon.getMaxRange();
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
		targetDistance = range;
		
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

