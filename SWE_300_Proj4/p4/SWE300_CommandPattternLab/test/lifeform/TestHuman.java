package lifeform;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the human class
 * @author Jake Moore
 */
public class TestHuman 
{
	/**
	 * Tests creating a human and giving it armor
	 */
	@Test
	public void testInitialization() 
	{
		Human bob = new Human("bob", 40, 10);
		assertEquals(10, bob.getArmorPoints());
	}
	
	/**
	 * Tests armor less than zero case
	 */
	@Test
	public void testLessThanZero()
	{
		Human bob = new Human("bob", 40, -5);
		assertEquals(0, bob.getArmorPoints());
	}
	
	/*
	 * Start section for observer pattern tests 
	 */
	
	/**
	 * Tests simple default attack 
	 */
	@Test
	public void testSimpleAttack()
	{
		Human grapes = new Human("ahfdhfjnwe", 40, 0);
		assertEquals(5, grapes.getCurrentAttack());
	}
	
	/**
	 * Test taking a hit without armor
	 */
	@Test
	public void testHitNoArmor()
	{
		Human victim = new Human("Earl", 40, 0);
		Human attacker = new Human("Tyler", 40, 0);
		int defaultAttack = attacker.getCurrentAttack();
		victim.takeHit(defaultAttack);
		assertEquals(35, victim.getCurrentLifePoints());
	}
	
	/**
	 * Test taking a hit with armor
	 */
	@Test
	public void testHitWithArmor()
	{
		Human victim = new Human("Leroy Jenkins", 40, 5);
		Human attacker = new Human("Fallout 5 confirmed", 40, 0);
		int defaultAttack = attacker.getCurrentAttack();
		victim.takeHit(defaultAttack);
		assertEquals(40, victim.getCurrentLifePoints());
		
	}
	
	/**
	 * More testing with armor
	 */
	@Test
	public void testHitWithArmorAgain()
	{
		Human victim = new Human("Jesus", 40, 3);
		Human attacker = new Human("Satan", 40, 0);
		int defaultAttack = attacker.getCurrentAttack();
		victim.takeHit(defaultAttack);
		assertEquals(38, victim.getCurrentLifePoints());
	}
	
	/**
	 * Test More armor
	 */
	@Test
	public void testMoreArmor()
	{
		Human victim = new Human("Claptrap", 40, 10);
		Human attacker = new Human("Atlas", 40, 0);
		int defaultAttack = attacker.getCurrentAttack();
		victim.takeHit(defaultAttack);
		assertEquals(40, victim.getCurrentLifePoints());
	}
	

}
