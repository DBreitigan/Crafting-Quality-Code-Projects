package weapon;
import lifeform.LifeForm;
import weapon.GenericWeapon;
/**
 * Stabilizer class
 * @author Jake Moore Sam Selkregg Cade Reed
 */
public class Stabilizer extends Attachment
{
	
	int currentDam;
	int currentAmmo;
	int currentRange;
	int maxAmmo;
	
	/**
	 * Stabilizer constructor
	 * @param weapon
	 */
	public Stabilizer(Weapon weapon)
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
			currentDam = newWeapon.calculateDamage();
		}
	}
	
	/**
	 * Updates the damage with said attachment
	 * @return currentDamage
	 */
	public int calculateDamage()
	{	
		if(numberOfAttachments < 2)
		{
			if(currentAmmo == 0)
			{
				newWeapon.reload();
			}
			float dam;
			{
				float damIncrease = (float)currentDam * 25;
				dam = (float)currentDam + damIncrease;
			}
			if(numberOfAttachments == 1)
			{
				currentDam = (int)dam;
			}
			else
			{
				currentDam = (int)dam;
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
