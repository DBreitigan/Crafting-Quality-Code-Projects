package lifeform;
import lifeform.LifeForm;

/**
 * Human subclass of lifeform
 * @author Jake Moore
 */
public class Human extends LifeForm
{
	/**
	 * Instance Variables
	 */
	protected int armorPoints;
	
	/**
	 * Constructor for human
	 * @param armor
	 * @param name
	 * @param life
	 */
	public Human(String name, int life, int armor)
	{
		if(armor < 0)
		{
			armor = 0;
		}
		
		armorPoints = armor;
		currentLifePoints = life;
		myName = name;
		attack = 5;
		maxSpeed = 3;
	}
	
	/**
	 * Gets the number of armor points
	 * @return armor
	 */
	public int getArmorPoints()
	{
		return armorPoints;
	}
	
	/**
	 * Setter for armor points
	 * @param armor
	 */
	public void setArmorPoints(int armor)
	{
		if(armor < 0)
		{
			armor = 0;
		}
		armorPoints = armor;
	}
	
	public void takeHit(int damage)
	{
		int healthArmor = armorPoints + currentLifePoints;
		if(currentLifePoints <= 0)
		{
			damage = 0;
			currentLifePoints = 0;
		}
		//if the damage dealt is less than the armor points, there is no damage done
		if(armorPoints < damage)
		{
			currentLifePoints = healthArmor - damage;
		}
	}
}
