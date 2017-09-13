package weapon;

import lifeform.LifeForm;

/**
 * Generic class for weapon
 * @author Jake Moore Sam Selkregg Cade Reed
 */
public abstract class GenericWeapon implements Weapon
{
	/*
	 * Instance Variables
	 */
	protected int baseDam;
	protected int currentDam;
	protected int maxAmmo;
	protected int currentAmmo;
	protected int maxRange;
	protected int currentRange;
	protected int maxShots;
	protected int currentShots;
	protected int currentRound;
	protected int observerTime;
	//protected Attachment[] attachments = new Attachment[2];
	//protected int numberOfAttachments;
	
	public abstract int calculateDamage();
	
	/**
	 * Getter for currentAmmo
	 * @return currentAmmo
	 */
	public int getCurrentAmmo()
	{
		return currentAmmo;
	}
	
	/**
	 * Getter for maxAmmo
	 */
	public int getMaxAmmo()
	{
		return maxAmmo;
	}
	
	/**
	 * Getter for currentDamage
	 * @return currentDam
	 */
	/*public int getCurrentDam()
	{
		return currentDam;
	}*/
	
	/**
	 * Modifies the current damage
	 * @param newDam
	 */
	/*public void modifyCurrentDam(int newDam)
	{
		currentDam = newDam;
	}*/
	
	/**
	 * Getter for MaxRange
	 * @return maxRange
	 */
	public int getMaxRange()
	{
		return maxRange;
	}
	
	/**
	 * Getter for current location
	 */
	public int getCurrentLocation()
	{
		return currentRange;
	}
	
	/**
	 * Changes max range for the scope
	 * @param range
	 */
	public void modifyMaxRange(int range)
	{
		maxRange = range;
	}
	
	/**
	 * Getter for numberOfAttachments
	 * @return number attachments
	 */
	public int getNumberOfAttachments()
	{
		return 0;
	}
	
	/**
	 * Fire method
	 * @param victim
	 * @param distance
	 */
	public void fire(LifeForm victim, int distance)
	{
		currentRange = distance;
		calculateDamage();
		currentAmmo--;
		if(currentRange <= maxRange)
		{
			currentShots++;
			victim.takeHit(currentDam);
		}
	}
	
	/**
	 * Reload method
	 */
	public void reload()
	{
		currentAmmo = maxAmmo;
	}
	
	/**
	 * Updates the currentRange
	 * @param range
	 */
	public void updateLocation(int range)
	{
		currentRange = range;
	}
	
	/**
	 * Updates the time for the gun
	 * @param round
	 */
	public void updateTime(int round)
	{
		currentRound = round;
		currentShots = 0;
	}
	
	/**
	 * Add attachment method
	 * @param attachment
	 */
	/*public void addAttachment(Attachment attachment)
	{
		if(attachments.length == 0)
		{
			attachments[0] = attachment;
			numberOfAttachments++;
			currentDam = attachment.calculateDamage();
		}
		else if(attachments.length == 1)
		{
			attachments[1] = attachment;
			numberOfAttachments++;
			currentDam = attachment.calculateDamage();
		}
	}*/
	
	/**
	 * Removes attachment
	 * @param location
	 */
	/*public void removeAttachment(int location)
	{
		attachments[location] = null;
		numberOfAttachments--;
	}*/

	/**
	 * Fire method
	 * this is very ugly right now, just trying to get it to work
	 * @param victim
	 */
	/*public void fire(LifeForm victim)
	{
		if(lastRoundFired != observerTime)
		{
			if(shotsFired != fireRate)
			{
				calculateDamage();
				currentAmmo--;
				shotsFired++;
				lastRoundFired = observerTime;
				if(currentRange <= maxRange)
				{
					victim.takeHit(currentDam);
				}
			}
		}
		if(lastRoundFired == observerTime)
		{
			if(shotsFired != fireRate)
			{
				calculateDamage();
				currentAmmo--;
				shotsFired++;
				if(currentRange <= maxRange)
				{
					victim.takeHit(currentDam);
				}
			}

		}
		
	}*/
	
}
