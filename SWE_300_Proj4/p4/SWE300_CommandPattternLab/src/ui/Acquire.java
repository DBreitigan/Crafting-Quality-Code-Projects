/**
 * Acquire weapon command for a LifeForm
 * @author Group 5 - Sam Selkregg (updated 10/24/16)
 */
package ui;

import exceptions.MyNewException;
import lifeform.LifeForm;
import weapon.Weapon;

public class Acquire implements Command
{
	/**
	 * Declare instance variables
	 */
	private LifeForm life;
	private Weapon weapon;
	
	/**
	 * Constructor for acquiring a weapon
	 * @param gary the LifeForm picking up a weapon
	 * @param w the weapon being picked up
	 */
	public Acquire(LifeForm gary, Weapon w)
	{
		life = gary;
		weapon = w;
	}
	
	/**
	 * Adds the weapon to the LifeForm
	 */
	public void execute()
	{
		life.addWeapon(weapon);
	}
}

