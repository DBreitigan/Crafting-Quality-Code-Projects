package ui;
import weapon.Weapon;

/**
 * Reload Command
 * @author Group 5
 */
public class Reload implements Command
{
	/**
	 * declare instance variables
	 */
	private Weapon weapon;
	
	/**
	 * Reload Command constructor gathers weapon for execute method
	 * @param w the weapon to be reloaded
	 */
	public Reload(Weapon w)
	{
		weapon = w;
	}
	
	/**
	 * reloads the weapon
	 */
	public void execute()
	{
		weapon.reload();
	}
}
