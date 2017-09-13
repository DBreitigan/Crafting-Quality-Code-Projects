package lifeform;
import exceptions.MyNewException;
import gameplay.SimpleTimer;
import gameplay.TimeObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

/**
 * Alien Class
 * @author Jake Moore
 */
public class Alien extends LifeForm implements TimeObserver
{
	/**
	 * Instance Variables
	 */
	protected int maxLifePoints;
	protected RecoveryBehavior recoveryBehavior;
	protected int recoveryRound;

	/**
	 * Constructor for alien
	 * @param name
	 * @param life
	 * @param rb
	 */
	/*public Alien(String name, int life)
	{
		myName = name;
		maxLifePoints = life;	
	}*/
	
	/**
	 * The first constructor
	 * @param name
	 * @param life
	 * @throws MyNewException
	 */
	public Alien(String name, int life) throws MyNewException
	{
		this(name, life, 1, new RecoveryNone());
	}
	/**
	 * Constructor with recovery behavior
	 * @param name
	 * @param life
	 * @param recovery
	 * @param recoveryType
	 * @throws MyNewException
	 */
	public Alien(String name, int life, int recovery, RecoveryBehavior recoveryType) throws MyNewException
	{
		if(recovery < 0)
		{
			throw new MyNewException("recoveryRound cannot be less than zero");
		}
		if(recovery == 0)
		{
			recovery = 1;
			recoveryType = new RecoveryNone();
		}
		if(life > 0)
		{
			currentLifePoints = life;
			maxLifePoints = life;
		}
		recoveryRound = recovery;
		attack = 10;
		myName = name;
		recoveryBehavior = recoveryType;
		maxSpeed = 2;
	}
	
	/**
	 * Sets the current life points
	 * @param life
	 */
	public void setCurrentLifePoints(int life)
	{
		currentLifePoints = life;
	}
	
	/**
	 * recover method
	 */
	protected void recover()
	{
		currentLifePoints = recoveryBehavior.calculateRecovery(currentLifePoints, maxLifePoints);
	}
	
	/**
	 * Updating the time so alien can keep track of what round it is in
	 * @param time
	 * @param round
	 */
	public void updateTime(int time)
	{
		if(time%recoveryRound == 0)
		{
			recover();
		}
	}
}

