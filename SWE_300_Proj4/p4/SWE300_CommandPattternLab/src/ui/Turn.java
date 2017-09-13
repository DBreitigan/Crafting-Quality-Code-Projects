/**
 * Turn command for the command pattern.
 * @author Group 5 - Sam Selkregg (updated 10/24/16)
 */
package ui;

import lifeform.LifeForm;
import environment.Environment;
import exceptions.DirectionException;

public class Turn implements Command
{
	/**
	 * instance variables
	 */
	private LifeForm life;
	private char direction;
	
	/**
	 * Constructor for the turn method.
	 * @param gary the lifeform that is turning
	 * @param direction that we will be turning
	 */
	public Turn(LifeForm gary, char direction)
	{
		life = gary;
		this.direction = direction;
	}
	
	/**
	 * executes the turn command
	 */
	public void execute()
	{
		try
		{
			life.changeDirection(direction);
		}
		catch (DirectionException life)
		{
			System.out.println("Direction Exception");
		}
		
	}
}

