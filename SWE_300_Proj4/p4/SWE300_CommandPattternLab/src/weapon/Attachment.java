package weapon;

/**
 * Attachment class to build on the attachments
 * @author Jake Moore Sam Selkregg Cade Reed
 */
public abstract class Attachment implements Weapon
{
	/**
	 * The weapon that gets modified
	 */
	protected Weapon newWeapon;
	protected int numberOfAttachments;
	
	public abstract int calculateDamage();
	
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
	
	public int getNumberOfAttachments()
	{
		return numberOfAttachments;
	}
	/**
	 * Getter for newWeapon
	 * @return newWeapon
	 */
	public Weapon getNewWeapon()
	{
		return newWeapon;
	}
}
