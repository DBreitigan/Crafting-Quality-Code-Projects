package environment;
import static org.junit.Assert.*;
import lifeform.Alien;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

import weapon.ChainGun;
import weapon.MockWeapon;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;
import environment.Cell;

/**
 * The test cases for the Cell class
 * @author Jake Moore
 */
public class TestCell 
{
	/**
	 * At initialization, the Cell should be empty and not contain a LifeForm
	 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
		assertNull(cell.getWeapon());
	}
	
	/**
	 * Checks to see if we change the LifeForm held by the Cell that getLifeForm properly responds to this change.
	 */
	@Test
	public void testSetLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		LifeForm fred = new MockLifeForm("Fred", 40);
		Cell cell = new Cell();
		//The cell is empty so this should work
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());
		//The cell is not empty so this should fail
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}
	
	/**
	 * Tests remove LifeForm
	 */
	@Test
	public void testRemoveLifeForm()
	{
		LifeForm bob = new MockLifeForm("bob", 40);
		Cell cell = new Cell();
		cell.addLifeForm(bob);
		assertEquals(bob, cell.getLifeForm());
		cell.removeLifeForm();
		assertNull(cell.getLifeForm());
	} 
	
	/**
	 * Tests adding a weapon
	 */
	@Test
	public void testAddWeapon()
	{
		Cell cell = new Cell();
		Weapon pistol = new Pistol();
		Weapon chainGun = new ChainGun();
		boolean success = cell.addWeapon(pistol);
		assertTrue(success);
		assertEquals(pistol, cell.getWeapon());
		success = cell.addWeapon(chainGun);
		assertFalse(success);
		assertEquals(pistol, cell.getWeapon());
	}
	
	/**
	 * Tests removing a weapon
	 */
	@Test
	public void testRemoveWeapon()
	{
		Cell cell = new Cell();
		Weapon mock = new MockWeapon();
		cell.addWeapon(mock);
		assertEquals(mock, cell.getWeapon());
		cell.removeWeapon();
		assertNull(cell.getWeapon());
	}

}
