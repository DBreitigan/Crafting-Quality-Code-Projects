/**
 * Attack command for the command method
 * @author Group 5 - Sam Selkregg (updated 10/24/16)
 */
package ui;

import lifeform.LifeForm;

public class Attack implements Command
{
	/**
	 * Instance Variables
	 */
	private LifeForm wolf;
	private LifeForm sheep;
	private int distance;
	
	/**
	 * Constructor that gathers the information for the execute command
	 * @param w life form that will be attacking
	 * @param s life form that will be attacked
	 * @param distance between the two life forms
	 */
	public Attack(LifeForm w, LifeForm s, int distance)
	{
		wolf = w;
		sheep = s;
		this.distance = distance;
	}
	
	/**
	 * Executes the attack command
	 */
	public void execute()
	{
		wolf.attack(sheep, distance);
	}
}

