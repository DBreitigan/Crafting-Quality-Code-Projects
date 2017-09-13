package environment;
import weapon.Weapon;
import lifeform.LifeForm;

/**
 * A cell that can hold a LifeForm
 * @author Jake Moore
 */
public class Cell 
{
	/**
	 * Instance Variables
	 */
	private LifeForm life;
	private Weapon weapon;
	
	
	/**
	 * @return the LifeForm in this Cell
	 */
	public LifeForm getLifeForm()
	{
		return life;
	}
	
	/**
	 * Getter for Weapon
	 * @return weapon
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}
	
	/**
	 * Tries to add the LifeForm to the Cell. Will not add if a LifeForm is already present.
	 * @return true if the LifeForm was added to the Cell, false otherwise.
	 * @param entity
	 */
	public boolean addLifeForm(LifeForm entity)
	{	
		boolean successful;
		
		if(life == null)
		{
			life = entity;
			successful = true;
		}
		else
		{
			successful = false;
		}
		
		return successful;
	}
	
	/**
	 * Removes the life form from the cell
	 */
	public void removeLifeForm()
	{
		life = null;
	}
	
	/**
	 * Adds a weapon to the cell
	 * @param newWeapon
	 * @return successful
	 */
	public boolean addWeapon(Weapon newWeapon)
	{
		boolean successful;
		
		if(weapon == null)
		{
			weapon = newWeapon;
			successful = true;
		}
		else
		{
			successful = false;
		}
		
		return successful;
	}
	
	/**
	 * Removes weapon from cell
	 */
	public void removeWeapon()
	{
		weapon = null;
	}
}
