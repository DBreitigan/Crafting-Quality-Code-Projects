package lifeform;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import exceptions.MyNewException;
import gameplay.SimpleTimer;
import gameplay.Timer;
import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;

/**
 * Class to test the alien class
 * @author Jake Moore
 */
public class TestAlien 
{
	
	/**
	 * Tests the constructor
	 * @throws MyNewException 
	 */
	@Test
	public void testConstructor() throws MyNewException 
	{
		Alien steve = new Alien("Steve", 40);
	}

	/**
	 * Testing recovery behavior in the constructor
	 * @throws MyNewException 
	 */
	@Test
	public void testRecoveryBehaviorConstructor() throws MyNewException
	{
		RecoveryBehavior r1 = new RecoveryLinear(10);
		Alien dorito = new Alien("Dorito", 40, 2, r1);
	}
	
	/**
	 * More recovery behavior testing
	 * @throws MyNewException 
	 */
	@Test
	public void testRecoveryBehaviorFractional() throws MyNewException
	{
		RecoveryBehavior r1 = new RecoveryFractional(.13);
		Alien mechanist = new Alien("mechanist", 40, 2, r1);
	}
	
	/*
	 * Beginning of Tests for observer pattern
	 */
	
	/**
	 * Checks that alien has a default attack of 10
	 * @throws MyNewException 
	 */
	@Test
	public void testDefaultAttack() throws MyNewException
	{
		Alien attacker = new Alien("Kendrick", 40);
		Alien victim = new Alien("Kanye West", 40);
		int defaultAttack = attacker.getCurrentAttack();
		victim.takeHit(defaultAttack);
		assertEquals(30, victim.getCurrentLifePoints());
	}
	
	/**
	 * Tests the updated alien constructor
	 * @throws MyNewException 
	 */
	@Test (expected = MyNewException.class)
	public void testUpdatedAlienConstructor() throws MyNewException
	{
		ExpectedException t = ExpectedException.none();
		Alien crookedClinton = new Alien("Hillary Rhodam Clinton", 2000, -1, new RecoveryNone());
		t.expect(MyNewException.class);
	}
	
	/**
	 * Combat recovery test
	 * @throws MyNewException 
	 */
	@Test
	public void testCombatRecovery() throws MyNewException
	{
		SimpleTimer t = new SimpleTimer(1000);
		Alien trump = new Alien("Donald", 20, 2, new RecoveryLinear(5));
		t.addTimeObserver(trump);
		trump.takeHit(10);
		t.timeChanged();
		assertEquals(10, trump.getCurrentLifePoints());
		t.timeChanged();
		t.timeChanged();
		assertEquals(15, trump.getCurrentLifePoints());
	}
	
	/**
	 * Tests no recovery when dead
	 */
	@Test
	public void testCombatRecoveryFractional() throws MyNewException
	{
		SimpleTimer t = new SimpleTimer(1000);
		Alien bob = new Alien("bob", 120, 2, new RecoveryFractional(.1));
		t.addTimeObserver(bob);
		bob.takeHit(20);
		t.timeChanged();
		assertEquals(100, bob.getCurrentLifePoints());
		t.timeChanged();
		t.timeChanged();
		assertEquals(110, bob.getCurrentLifePoints());
	}
	
	/**
	 * Tests when recovery rate is zero
	 */
	@Test
	public void testCombatRecoveryNone() throws MyNewException
	{
		SimpleTimer t = new SimpleTimer(1000);
		Alien bob = new Alien("bob", 120, 0, new RecoveryFractional(.1));
		t.addTimeObserver(bob);
		bob.takeHit(20);
		t.timeChanged();
		assertEquals(100, bob.getCurrentLifePoints());
		t.timeChanged();
		t.timeChanged();
		assertEquals(100, bob.getCurrentLifePoints());
	}
}
