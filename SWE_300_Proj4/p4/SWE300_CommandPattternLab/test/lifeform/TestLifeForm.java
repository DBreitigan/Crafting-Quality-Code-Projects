package lifeform;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import weapon.MockWeapon;
import weapon.Pistol;
import weapon.Weapon;
import environment.Environment;
import exceptions.DirectionException;
import exceptions.EnvironmentOutOfBoundsException;
import exceptions.MovementException;
import exceptions.MyNewException;
import exceptions.WorldInstanceException;


/**
 * Tests functionality provided by the LifeForm Class
 * @author Jake Moore
 */
public class TestLifeForm 
{
	/*
	 * Start of Command Pattern tests
	 */
	
	/**
	 * Tests the initial current direction and speed
	 */
	@Test
	public void testInitializeDirectionSpeed()
	{
		//LifeForm l = LifeForm;
		//assertEquals(0, l.maxSpeed);
	}
	
	/**
	 * Tests max speed is initialized correctly
	 * @throws MyNewException 
	 */
	@Test
	public void testAlienHumanMaxSpeed() throws MyNewException
	{
		Human bernie = new Human("bernie", 20, 20);
		Alien hillary = new Alien("hill", 20);
		assertEquals(3, bernie.getMaxSpeed());
		assertEquals(2, hillary.getMaxSpeed());
	}
	
	/**
	 * Tests that default direction is north
	 */
	@Test
	public void testDefaultDirection()
	{
		LifeForm life = new MockLifeForm("ksjHFKDSF", 20);
		assertEquals("North", life.getDirection());
		assertEquals('n', life.getDirectionChar());
	}
	
	/**
	 * Tests changing direction
	 * @throws DirectionException 
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws MovementException 
	 */
	@Test
	public void testChangeDirectionAndMovement() throws DirectionException, MovementException, EnvironmentOutOfBoundsException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm turdSandwich = new MockLifeForm("Hillary", 20);
		turdSandwich.changeDirection('n');
		assertEquals("North", turdSandwich.getDirection());
		turdSandwich.changeDirection('s');
		assertEquals("South", turdSandwich.getDirection());
		turdSandwich.changeDirection('e');
		assertEquals("East", turdSandwich.getDirection());
		turdSandwich.changeDirection('w');
		assertEquals("West", turdSandwich.getDirection());
		
	}
	
	
	/*
	 * Start of decorator pattern tests
	 */
	
	/**
	 * Clears environment for every test
	 * @throws WorldInstanceException 
	 */
	@Before
	public void clearEnvironment() throws WorldInstanceException
	{
		Environment.removeWorldInstance();
		Environment.createWorldInstance(5,5);
		Environment e = Environment.getWorldInstance();
		e.clearEnv();
	}
	
	/**
	 * Test add/drop weapon
	 */
	@Test
	public void testAddDrop()
	{
		LifeForm weaponHolder = new MockLifeForm("Dummy", 30);
		Weapon mock = new MockWeapon();
		Weapon mock2 = new MockWeapon();
		weaponHolder.addWeapon(mock);
		weaponHolder.addWeapon(mock2);
		assertEquals(mock, weaponHolder.getWeapon());
		weaponHolder.dropWeapon();
		assertNull(weaponHolder.getWeapon());
	}
	
	/**
	 * Test attacking another lifeform
	 */
	@Test
	public void testAttackingWithWeapon()
	{
		LifeForm steve = new MockLifeForm("steve", 80);
		LifeForm victim = new MockLifeForm("victim", 80);
		Weapon pistol = new Pistol();
		steve.addWeapon(pistol);
		steve.attack(victim, 2);
		assertEquals(69, victim.getCurrentLifePoints());
	}
	
	/**
	 * Test with no weapon
	 */
	@Test
	public void testAttackWithNoWeapon()
	{
		LifeForm steve = new MockLifeForm("steve", 80);
		LifeForm victim = new MockLifeForm("victim", 400);
		steve.attack(victim, 2);
		assertEquals(200, victim.getCurrentLifePoints());
	}
	
	/**
	 * Testing the new range function
	 * @throws EnvironmentOutOfBoundsException 
	 */
	@Test 
	public void testRange() throws EnvironmentOutOfBoundsException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm steve = new MockLifeForm("steve", 80);
		LifeForm victim = new MockLifeForm("victim", 400);
		steve.attack(victim, e.calculateDistance(0,0,0,2));
		assertEquals(200, victim.getCurrentLifePoints());
		steve.addWeapon(new Pistol());
		steve.attack(victim, e.calculateDistance(0,0,0,1));
		assertEquals(190, victim.getCurrentLifePoints());
	}
	
	/**
	 * When a LifeForm is created, it should know its name and how many life points it has.
	 */
	@Test
	public void testInitialization() 
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getCurrentLifePoints());
	}
	
	/*
	 * Beginning of Observer Tests
	 */
	
	/**
	 * Tests that the lifeform knows how much attack it possesses
	 */
	public void testGetAttack()
	{
		LifeForm prettyFlacko = new MockLifeForm("Pretty Flacko", 40);
		assertEquals(200, prettyFlacko.getCurrentAttack());
	}
	
	/**
	 * Tests that a life form can do damage to another life form
	 */
	@Test
	public void testTakeHit()
	{
		LifeForm attacker = new MockLifeForm("Attacker", 600);
		int defaultAttack = attacker.getCurrentAttack();
		LifeForm victim = new MockLifeForm("Victim", 600);
		victim.takeHit(defaultAttack);
		assertEquals(400, victim.getCurrentLifePoints());
	}
	
	/**
	 * Tests a dead Life form cant take hit
	 */
	@Test
	public void testDeadLifeFormCantTakeHit()
	{
		LifeForm attacker = new MockLifeForm("Attacker", 600);
		int defaultAttack = attacker.getCurrentAttack();
		LifeForm victim = new MockLifeForm("Victim", 0);
		victim.takeHit(defaultAttack);
		assertEquals(0, victim.getCurrentLifePoints());
	}
	
	/**
	 * Tests dead life form cant attack
	 */
	@Test
	public void testDeadLifeFormCantAttack()
	{
		LifeForm attacker = new MockLifeForm("Attacker", 0);
		int defaultAttack = attacker.getCurrentAttack();
		LifeForm victim = new MockLifeForm("Victim", 200);
		victim.takeHit(defaultAttack);
		assertEquals(200, victim.getCurrentLifePoints());
		
	}
}
