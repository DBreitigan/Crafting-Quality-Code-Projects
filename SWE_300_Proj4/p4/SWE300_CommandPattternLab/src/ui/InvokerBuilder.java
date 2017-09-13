/***************************************************************************
 * IGNORE THIS CLASS FOR NOW
 **************************************************************************/

package ui;

import lifeform.*;
import weapon.*;
import ui.*;

/**
 * This creates all of the objects needed to have the invoker run and 
 * interact with the GUI. It acts as a user interface Factory.
 * @author Matthew Frutsche
 */

public class InvokerBuilder
{	
	private LifeForm lifeform;
	private LifeForm lifeform2;
	private Weapon weapon;
	private int distance;
	private char direction;
	
	public InvokerBuilder()
	{
		/**
		 * This method sets all of the commands up and then assigns them to specific buttons
		 */
		
		Invoker remote = new Invoker();
				
		Command Reload = new Reload(weapon);
		Command Acquire = new Acquire(lifeform, weapon);
		Command Drop = new Drop(lifeform);
		Command Attack = new Attack(lifeform, lifeform2, distance);
		Command Turn = new Turn(lifeform, direction);
		Command Move = new Move(lifeform);
		
	}
}

