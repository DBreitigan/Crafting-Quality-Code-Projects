package lifeform;
import exceptions.DirectionException;
import gameplay.SimpleTimer;
import gameplay.TimeObserver;
import weapon.Weapon;
/**
 * Keeps track of the information associated with a simple life form.
 * Also provides the functionality related to the life form
 * @author Jake Moore
 */
public abstract class LifeForm implements TimeObserver
{
	/**
	 * Instance Variables
	 */
	protected String myName;
	protected int currentLifePoints;
	protected int attack;
	protected int observerTime;
	protected Weapon weapon;
	protected char currentDirection = 'n';
	protected int maxSpeed = 0;
	protected String directionString = "North";
	protected int row;
	protected int col;
	
	/**
	 * Create an instance
	 * @param name of the life form
	 * @param points the current starting life points of the life form
	 */
	/*public LifeForm(String name, int points)
	{
		myName = name;
		currentLifePoints = points;
	}*/
	
	/**
	 * @return the name of the life form
	 */
	public String getName()
	{
		return myName;
	}
	
	/**
	 * @return the amount of current life points the life form has.
	 */
	public int getCurrentLifePoints()
	{
		return currentLifePoints;
	}
	
	/**
	 * Getter for max Speed
	 * @return maxSpeed
	 */
	public int getMaxSpeed()
	{
		return maxSpeed;
	}
	
	/**
	 * Getter for direction
	 * @return directionString
	 */
	public String getDirection()
	{
		return directionString;
	}
	
	/**
	 * Getter for currentDirection
	 * @return currentDirection
	 */
	public char getDirectionChar()
	{
		return currentDirection;
	}
	
	/**
	 * Getter for current attack points
	 * @return the damage of the attack
	 */
	public int getCurrentAttack()
	{
		if(currentLifePoints == 0)
		{
			attack = 0;
		}
		return attack;
	}
	
	/**
	 * Getter for weapon
	 * @return weapon
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}
	
	/**
	 * Getter for row
	 * @return row
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * Getter for col
	 * @return col
	 */
	public int getCol()
	{
		return col;
	}
	
	/**
	 * Setter for location
	 * @param row
	 * @param column
	 */
	public void storeLocation(int row, int column)
	{
		this.row = row;
		this.col = column;
	}
	
	/**
	 * toString method for LifeForm
	 */
	public String toString()
	{
		return "Current Direction: " + directionString + "\nCurrent Weapon: " + weapon + "\nCurrent Life: " + currentLifePoints;
	}
	
	/**
	 * Method that causes damage to a LifeForm 
	 * @param damage
	 */
	public void takeHit(int damage)
	{
		currentLifePoints = currentLifePoints - damage;
		
		if(currentLifePoints <= 0)
		{
			currentLifePoints = 0;
		}
	}
	
	/**
	 * Attacking a victim
	 * @param victim
	 * @param distance
	 */
	public void attack(LifeForm victim, int distance)
	{
		if((weapon == null)||(weapon.getCurrentAmmo() == 0))
		{
			victim.takeHit(attack);
		}
		if(weapon != null)
		{
			weapon.fire(victim, distance);
		}
	}
	
	/**
	 * Updates the time for the observer
	 * @param time
	 * @param round
	 */
	public void updateTime(int time)
	{
		observerTime = time;
	}
	
	/**
	 * Add weapon
	 * @param gun
	 */
	public void addWeapon(Weapon gun)
	{
		if(weapon != null)
		{
			System.out.println("You already have a weapon. Drop the existing weapon to pick up a weapon.");
		}
		else
		{
			weapon = gun;
		}
	}
	
	/**
	 * Drop a weapon
	 */
	public void dropWeapon()
	{
		weapon = null;
	}
	
	/**
	 * Changes the direction of lifeform
	 * @param direction
	 * @throws DirectionException
	 */
	public void changeDirection(char direction) throws DirectionException
	{
		if(direction == 'n')
		{
			currentDirection = 'n';
			directionString = "North";
		}
		else
		if(direction == 's')
		{
			currentDirection = 's';	
			directionString = "South";
		}
		else
		if(direction == 'e')
		{
			currentDirection = 'e';
			directionString = "East";
		}
		else
		if(direction == 'w')
		{
			currentDirection = 'w';
			directionString = "West";
		}
		else
		{
			throw new DirectionException();
		}
	}
	
}
