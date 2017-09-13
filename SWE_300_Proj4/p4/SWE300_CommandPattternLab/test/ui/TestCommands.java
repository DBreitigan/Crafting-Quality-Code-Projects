/**
 * Tests the functionality of commands implemented by the command pattern.
 * @author Sam Selkregg
 */
package ui;

import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Before;
import org.junit.Test;

import weapon.GenericWeapon;
import weapon.MockWeapon;
import weapon.Pistol;
import environment.Environment;
import exceptions.DirectionException;
import exceptions.EnvironmentOutOfBoundsException;
import exceptions.MovementException;
import exceptions.WorldInstanceException;

public class TestCommands 
{
	/**
	 * Creates a brand new instance of an environment.
	 * @throws WorldInstanceException
	 */
	@Before
	public void before() throws WorldInstanceException
	{
		Environment.removeWorldInstance();
		Environment.createWorldInstance(5, 5);
	}
	
	/**
	 * Tests if we can properly implement the move command using the Command Pattern.
	 * @throws EnvironmentOutOfBoundsException
	 * @throws DirectionException
	 */
	@Test
	public void testMoveCommand() throws EnvironmentOutOfBoundsException, DirectionException 
	{
		Environment e = Environment.getWorldInstance();
		LifeForm gary = new MockLifeForm("Gary Johnson", 25);
		e.addLifeForm(0, 0, gary);
		gary.changeDirection('s');
		Move m = new Move(gary);
		m.execute();
		assertEquals(3, gary.getRow());
	}
	
	/**
	 * Tests if we can properly reload a weapon with no ammo in its clip using the 
	 * Command Pattern.
	 */
	@Test
	public void testReloadCommand()
	{
		LifeForm ragDoll = new MockLifeForm("I'm Gonn Git Shot", 10);
		Pistol p = new Pistol();
		/**
		 * Loop will run and deplete all ammo in the pistol.
		 */
		int i = 0;
		while(i<10)
		{
			p.fire(ragDoll, 5);
			i++;
		}
		assertEquals(0, p.getCurrentAmmo());
		Reload r = new Reload(p);
		r.execute();
		/**
		 * Checks proper reload.
		 */
		assertEquals(10, p.getCurrentAmmo());
	}
	/**
	 * Next four tests make sure that a player can turn to any direction (N,E,S,W)
	 * using the Command Pattern.
	 */
	/**
	 * Checks that a player can turn North.
	 * @throws EnvironmentOutOfBoundsException
	 */
	@Test
	public void testTurnPlayerNorthCommand() throws EnvironmentOutOfBoundsException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm wentz = new MockLifeForm("Wentzylvania", 10);
		e.addLifeForm(1, 1, wentz);
		Turn t = new Turn(wentz, 'n');
		t.execute();
		assertEquals('n', wentz.getDirectionChar());
	}
	
	/**
	 * Checks that a player can turn South.
	 * @throws EnvironmentOutOfBoundsException
	 */
	@Test
	public void testTurnPlayerSouthCommand() throws EnvironmentOutOfBoundsException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm wentz = new MockLifeForm("Wentzylvania", 10);
		e.addLifeForm(1, 2, wentz);
		Turn t = new Turn(wentz, 's');
		t.execute();
		assertEquals('s', wentz.getDirectionChar());
	}
	
	/**
	 * Checks that a player can turn East.
	 * @throws EnvironmentOutOfBoundsException
	 */
	@Test
	public void testTurnPlayerEastCommand() throws EnvironmentOutOfBoundsException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm wentz = new MockLifeForm("Wentzylvania", 10);
		e.addLifeForm(1, 3, wentz);
		Turn t = new Turn(wentz, 'e');
		t.execute();
		assertEquals('e', wentz.getDirectionChar());
	}
	
	/**
	 * Checks that a player can turn West.
	 * @throws EnvironmentOutOfBoundsException
	 */
	@Test
	public void testTurnPlayerWestCommand() throws EnvironmentOutOfBoundsException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm wentz = new MockLifeForm("Wentzylvania", 10);
		e.addLifeForm(1, 4, wentz);
		Turn t = new Turn(wentz, 'w');
		t.execute();
		assertEquals('w', wentz.getDirectionChar());
	}
	
	/**
	 * Checks to see that a player can properly attack implementing the Command Pattern.
	 */
	@Test
	public void testAttackCommand()
	{
		LifeForm steve = new MockLifeForm("steve", 80);
		LifeForm victim = new MockLifeForm("victim", 400);
		Attack a = new Attack(steve, victim, 2);
		a.execute();
		assertEquals(200, victim.getCurrentLifePoints());
	}
	
	/**
	 * Checks to see that a player can properly drop a weapon
	 * implementing the Command Pattern.
	 */
	@Test
	public void testDropCommand()
	{
		LifeForm mike = new MockLifeForm("Michael Bloomberg", 10);
		GenericWeapon w = new MockWeapon();
		mike.addWeapon(w);
		Drop d = new Drop(mike);
		d.execute();
		assertEquals(null, mike.getWeapon());
		/**
		 *makes sure mike can execute the drop command properly
		 *when he has no weapon
		 */
		d.execute();
		assertEquals(null, mike.getWeapon());
	}
	/**
	 * Checks to see that a player can properly acquire a weapon
	 * implementing the Command Pattern.
	 */
	@Test
	public void testAcquireCommand()
	{
		LifeForm sam = new MockLifeForm("The King of the World", 1000000);
		GenericWeapon w = new MockWeapon();
		GenericWeapon w1 = new MockWeapon();
		Acquire a = new Acquire(sam, w);
		a.execute();
		assertEquals(w, sam.getWeapon());
		/**
		 * Makes sure acquire command works correctly when sam
		 * already has a weapon
		 */
		Acquire a1 = new Acquire(sam, w1);
		a1.execute();
		assertEquals(w, sam.getWeapon());
	}
	
	

}
