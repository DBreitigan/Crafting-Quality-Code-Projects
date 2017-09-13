package environment;
import exceptions.EnvironmentOutOfBoundsException;

import exceptions.WorldInstanceException;
import weapon.Weapon;
import lifeform.LifeForm;

/**
 * Environment to hold all of the cells
 * @author Jake Moore
 */
public class Environment 
{
	/**
	 * Instance Variables
	 */
	private Cell[][] cells;
	private static Environment battlefield;
	private int maxRow;
	private int maxCol;
	
	/**
	 * Constructor with singleton method
	 * @param row
	 * @param column
	 */
	private Environment(int row, int column)
	{
		cells = new Cell[row][column];
		maxRow = row;
		maxCol = column;
		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				cells[i][j] = new Cell();
			}
		}
	}
	
	/**
	 * Clears the environment for new tests
	 * uses singleton
	 */
	/*public void clearEnv()
	{
		for(int i = 0; i < cells.length; i++)
		{
			for(int j = 0; j < cells[0].length; j++)
			{
				cells[i][j].removeLifeForm();
				cells[i][j].removeWeapon();
			}
		}
	}*/
	
	/**
	 * Creates the battlefield instance with singleton pattern
	 * @param row
	 * @param column
	 * @throws WorldInstanceException 
	 */
	public static synchronized void createWorldInstance(int row, int column) throws WorldInstanceException
	{
		if(battlefield == null)
		{
			battlefield = new Environment(row, column);
		}
		else
		{
			throw new WorldInstanceException();
		}
	}
	
	/**
	 * Removes the world instance
	 */
	public static synchronized void removeWorldInstance()
	{
		battlefield = null;
	}
	
	/**
	 * Singleton pattern for get instance of class
	 * @return battlefield
	 */
	public static synchronized Environment getWorldInstance()
	{
		return battlefield;
	}
	
	/**
	 * Getter for cell
	 * @param row
	 * @param column
	 * @return cell
	 */
	public Cell getCell(int row, int column)
	{
		return cells[row][column];
	}
	
	/**
	 * Returns the LifeForm stored in the cell
	 * @param row
	 * @param column
	 * @return the name of the life form in the cell
	 * @throws EnvironmentOutOfBoundsException 
	 */
	public LifeForm getLifeForm(int row, int column) throws EnvironmentOutOfBoundsException
	{
		if((row > cells.length) || (column > cells[0].length))
		{
			throw new EnvironmentOutOfBoundsException();
		}
		
		return cells[row][column].getLifeForm();
	}
	
	/**
	 * Returns the weapon stored in the cell
	 * @param row
	 * @param column
	 * @return the weapon in the cell
	 * @throws EnvironmentOutOfBoundsException 
	 */
	public Weapon getWeapon(int row, int column) throws EnvironmentOutOfBoundsException
	{
		if((row > cells.length) || (column > cells[0].length))
		{
			throw new EnvironmentOutOfBoundsException();
		}
		
		return cells[row][column].getWeapon();
	}
	
	/**
	 * Adds a lifeform to a specified cell
	 * @param row
	 * @param column
	 * @param entity
	 * @return boolean determining whether or not it was succesfully added
	 * @throws EnvironmentOutOfBoundsException 
	 */
	public boolean addLifeForm(int row, int column, LifeForm entity) throws EnvironmentOutOfBoundsException
	{
		boolean successful;
		
		if((row > cells.length) || (column > cells[0].length))
		{
			successful = false;
			throw new EnvironmentOutOfBoundsException();
		}
		
		if(cells[row][column].getLifeForm() == null)
		{
			cells[row][column].addLifeForm(entity);
			successful = true;
			entity.storeLocation(row, column);
		}
		else
		{
			successful = false;
		}
		
		return successful;
	}
	
	/**
	 * Removes a lifeForm
	 * @param row
	 * @param column
	 * @return LifeForm that was removed
	 * @throws EnvironmentOutOfBoundsException 
	 */
	public LifeForm removeLifeForm(int row, int column) throws EnvironmentOutOfBoundsException
	{
		if((row > cells.length) || (column > cells[0].length))
		{
			throw new EnvironmentOutOfBoundsException();
		}
		
		LifeForm c = cells[row][column].getLifeForm();
		cells[row][column].removeLifeForm();
		return c;
	}
	
	/**
	 * Adds a weapon
	 * @param row
	 * @param column
	 * @param weapon
	 * @return successful
	 * @throws EnvironmentOutOfBoundsException 
	 */
	public boolean addWeapon(int row, int column, Weapon weapon) throws EnvironmentOutOfBoundsException
	{
		boolean successful;
		
		if((row > cells.length) || (column > cells[0].length))
		{
			successful = false;
			throw new EnvironmentOutOfBoundsException();
		}
		
		if(cells[row][column].getWeapon() == null)
		{
			cells[row][column].addWeapon(weapon);
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
	 * @param row
	 * @param column
	 * @return the weapon removed
	 * @throws EnvironmentOutOfBoundsException 
	 */
	public Weapon removeWeapon(int row, int column) throws EnvironmentOutOfBoundsException
	{
		if((row > cells.length) || (column > cells[0].length))
		{
			throw new EnvironmentOutOfBoundsException();
		}
		
		Weapon w = cells[row][column].getWeapon();
		cells[row][column].removeWeapon();
		return w;
	}

	/**
	 * Calculates the distance between cells
	 * @param row1
	 * @param column1
	 * @param row2
	 * @param column2
	 * @return distance
	 * @throws EnvironmentOutOfBoundsException 
	 */
	public int calculateDistance(int row1, int column1, int row2, int column2) throws EnvironmentOutOfBoundsException
	{
		int distance;
		row1 = row1 + 1;
		row2 = row2 + 1;
		column1 = column1 + 1;
		column2 = column2 + 1;
		int columnLength = 5 * (row2 - row1);
		int rowLength = 5 * (column2 - column1);
		
		if((row1 > cells.length)||(row2 > cells.length)||(column1 > cells[0].length)||(column2 > cells[0].length))
		{
			throw new EnvironmentOutOfBoundsException();
		}
		
		if(row1 == row2)
		{
			distance = rowLength;
		}
		else
		if(column1 == column2)
		{
			distance = columnLength;
		}
		else//if((column1 != column2) && (row1 != row2))
		{
			int rowSquared = (rowLength) * (rowLength);
			int colSquared = (columnLength) * (columnLength);
			distance = (int)Math.sqrt(rowSquared + colSquared);
		}
		
		return distance;
	}
	
	/**
	 * Moves the lifeform
	 * @param life
	 * @throws MovementException 
	 * @throws EnvironmentOutOfBoundsException 
	 */
	public void move(LifeForm life) throws EnvironmentOutOfBoundsException
	{
		northMovement(life);
		southMovement(life);
		eastMovement(life);
		westMovement(life);
	}

	private void westMovement(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		if(life.getDirectionChar() == 'w')
		{
			moveWest(life);
		}
	}

	private void moveWest(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		boolean westIsEmpty = getLifeForm(life.getRow(), life.getCol() - life.getMaxSpeed()) == null;
		boolean westInBounds = life.getCol() - life.getMaxSpeed() >= 0;
		if(westIsEmpty&&westInBounds)
		{
			removeLifeForm(life.getRow(), life.getCol());
			addLifeForm(life.getRow(), life.getCol() - life.getMaxSpeed(), life);
		}
		else
		if(!westIsEmpty||!westInBounds)
		{
			findOpenPosWest(life);
		}
	}

	private void findOpenPosWest(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		for(int i  = life.getCol() - life.getMaxSpeed(); i <= life.getCol(); i++)
		{
			if(cells[life.getRow()][i].getLifeForm() == null)
			{
				removeLifeForm(life.getRow(), life.getCol());
				addLifeForm(life.getRow(), i, life);
				break;
			}
		}
	}

	private void eastMovement(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		if(life.getDirectionChar() == 'e')	//east movement
		{
			moveEast(life);
		}
	}

	private void moveEast(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		boolean eastIsEmpty = getLifeForm(life.getRow(), life.getCol() + life.getMaxSpeed()) == null;
		boolean eastInBounds = life.getCol() + life.getMaxSpeed() <= maxCol;
		if(eastIsEmpty&&eastInBounds)
		{
			removeLifeForm(life.getRow(), life.getCol());
			addLifeForm(life.getRow(), life.getCol()  + life.getMaxSpeed(), life);
		}
		else
		if(!eastIsEmpty||!eastInBounds)
		{
			findOpenPosEast(life);
		}
	}

	private void findOpenPosEast(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		for(int i  = life.getCol() + life.getMaxSpeed(); i >= life.getCol(); i--)
		{
			if(cells[life.getRow()][i].getLifeForm() == null)
			{
				removeLifeForm(life.getRow(), life.getCol());
				addLifeForm(life.getRow(), i, life);
				break;
			}
		}
	}

	private void southMovement(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		if(life.getDirectionChar() == 's')	//south movement
		{
			moveSouth(life);
		}
	}

	private void moveSouth(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		boolean southIsEmpty = getLifeForm(life.getRow() + life.getMaxSpeed(), life.getCol()) == null;
		boolean southInBounds = life.getRow() + life.getMaxSpeed() <= maxRow;
		if(southIsEmpty&&southInBounds)
		{
			removeLifeForm(life.getRow(), life.getCol());
			addLifeForm(life.getRow() + life.getMaxSpeed(), life.getCol(), life);
		}
		else
		if(!southIsEmpty||!southInBounds)
		{
			findOpenPosSouth(life);
		}
	}

	private void findOpenPosSouth(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		for(int i  = life.getRow() + life.getMaxSpeed(); i >= life.getRow(); i--)
		{
			if(cells[i][life.getCol()].getLifeForm() == null)
			{
				removeLifeForm(life.getRow(), life.getCol());
				addLifeForm(i, life.getCol(), life);
				break;
			}
		}
	}

	private void northMovement(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		if(life.getDirectionChar() == 'n')	//north movement
		{
			moveNorth(life);
		}
	}

	private void moveNorth(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		boolean northIsEmpty = getLifeForm(life.getRow() - life.getMaxSpeed(), life.getCol()) == null;
		boolean northInBounds = life.getRow() - life.getMaxSpeed() >= 0;
		if(northIsEmpty&&northInBounds)
		{
			removeLifeForm(life.getRow(), life.getCol());
			addLifeForm(life.getRow() - life.getMaxSpeed(), life.getCol(), life);
		}
		else
		if(!northIsEmpty||!northInBounds)
		{
			findOpenPosNorth(life);
		}
	
	}

	private void findOpenPosNorth(LifeForm life) throws EnvironmentOutOfBoundsException 
	{
		for(int i  = life.getRow() - life.getMaxSpeed(); i <= life.getRow(); i++)
		{
			if(cells[i][life.getCol()].getLifeForm() == null)
			{
				removeLifeForm(life.getRow(), life.getCol());
				addLifeForm(i, life.getCol(), life);
				break;
			}
		}
	}
	
}
