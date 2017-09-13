/**
 * Move command implementation for command pattern.
 * @author - Group 5
 */
package ui;

import environment.Environment;
import exceptions.EnvironmentOutOfBoundsException;
import exceptions.MovementException;
import lifeform.LifeForm;

public class Move implements Command
{
	/**
	 * declare instance variables
	 */
	LifeForm life;
	Environment e = Environment.getWorldInstance();
	
	/**
	 * Constructor gathers life form for execute method
	 * @param l life form to move
	 */
	public Move(LifeForm l)
	{
		life = l;
	}
	
	/**
	 * Executes the move command
	 */
	public void execute()
	{
		try
		{
			e.move(life);
		}
		catch (MovementException e) 
		{
			System.out.println("Movement Exception");
		}
		catch (EnvironmentOutOfBoundsException e) 
		{
			System.out.println("Out of bounds Exception");
		}
	}
}
