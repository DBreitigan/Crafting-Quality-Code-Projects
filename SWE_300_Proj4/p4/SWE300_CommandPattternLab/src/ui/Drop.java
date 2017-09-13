/**
 * Drop method for the command pattern
 * @author Group 5 - Sam Selkregg (updated 10/24/16)
 */
package ui;

import lifeform.LifeForm;
import weapon.Weapon;

public class Drop implements Command 
{
	/**
	 * declare instance variables
	 */
	private LifeForm life;
	
	/**
	 * constructor that gathers information for the execute method
	 * @param guy the life form dropping the weapon
	 */
	public Drop(LifeForm guy)
	{
		life = guy;
	}
	
	/**
	 * drops the weapon
	 */
	public void execute()
	{
		life.dropWeapon();
	}
}
