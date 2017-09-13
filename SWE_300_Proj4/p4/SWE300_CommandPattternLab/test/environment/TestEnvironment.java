package environment;
import static org.junit.Assert.*;

import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import org.junit.Before;
import org.junit.Test;
import weapon.MockWeapon;
import weapon.Weapon;
import environment.Environment;
import exceptions.DirectionException;
import exceptions.EnvironmentOutOfBoundsException;
import exceptions.WorldInstanceException;
/**
 * Class that tests the environment
 * @author Jake Moore
 */
public class TestEnvironment 
{
	/*
	 * Start of Command/Facade pattern
	 */
	
	/**
	 * Tests for movement north
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws DirectionException 
	 * @throws MovementException 
	 */
	@Test
	public void testNorthMovement() throws EnvironmentOutOfBoundsException, DirectionException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm giantDouche = new MockLifeForm("Trump", 30);
		e.addLifeForm(4, 0, giantDouche);
		giantDouche.changeDirection('n');
		e.move(giantDouche);
		assertEquals(0, giantDouche.getCol());
		assertEquals(1, giantDouche.getRow());
		
	}
	
	/**
	 * Tests south movement
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws MovementException 
	 * @throws DirectionException 
	 */
	@Test
	public void testSouthMovement() throws EnvironmentOutOfBoundsException, DirectionException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm giantDouche = new MockLifeForm("Trump", 30);
		e.addLifeForm(0, 0, giantDouche);
		giantDouche.changeDirection('s');
		e.move(giantDouche);
		assertEquals(0, giantDouche.getCol());
		assertEquals(3, giantDouche.getRow());
	}
	
	/**
	 * Tests eastern movement
	 * @throws DirectionException
	 * @throws EnvironmentOutOfBoundsException
	 * @throws MovementException
	 */
	@Test
	public void testEastMovement() throws DirectionException, EnvironmentOutOfBoundsException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm giantDouche = new MockLifeForm("Trump", 30);
		e.addLifeForm(0, 0, giantDouche);
		giantDouche.changeDirection('e');
		e.move(giantDouche);
		assertEquals(3, giantDouche.getCol());
		assertEquals(0, giantDouche.getRow());
	}
	
	/**
	 * Tests western movement
	 * @throws EnvironmentOutOfBoundsException
	 * @throws DirectionException
	 * @throws MovementException
	 */
	@Test
	public void testWestMovement() throws EnvironmentOutOfBoundsException, DirectionException //MovementException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm giantDouche = new MockLifeForm("Trump", 30);
		e.addLifeForm(4, 4, giantDouche);
		giantDouche.changeDirection('w');
		e.move(giantDouche);
		assertEquals(1, giantDouche.getCol());
		assertEquals(4, giantDouche.getRow());
	}
	
	/**
	 * Tests Northern direction border cases
	 * @throws DirectionException
	 * @throws EnvironmentOutOfBoundsException
	 * @throws MovementException
	 */
	//@Test (expected = MovementException.class)
	public void testNorthBorderCase() throws DirectionException, EnvironmentOutOfBoundsException //MovementException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm theFWord = new MockLifeForm("ldSKJFKDSJFSAF", 30);
		LifeForm obstacle = new MockLifeForm("obstacle", 30);
		e.addLifeForm(1, 0, obstacle);
		e.addLifeForm(4, 0, theFWord);
		theFWord.changeDirection('n');
		e.move(theFWord);
		assertEquals(2, theFWord.getRow());
	}
	
	/**
	 * Tests southern direction border cases
	 * @throws DirectionException
	 * @throws EnvironmentOutOfBoundsException
	 * @throws MovementException
	 */
	public void testSouthBorderCase() throws DirectionException, EnvironmentOutOfBoundsException //MovementException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm theFWord = new MockLifeForm("ldSKJFKDSJFSAF", 30);
		LifeForm obstacle = new MockLifeForm("obstacle", 30);
		e.addLifeForm(4, 0, obstacle);
		e.addLifeForm(1, 0, theFWord);
		theFWord.changeDirection('s');
		e.move(theFWord);
		assertEquals(3, theFWord.getRow());
	}
	
	/**
	 * Tests the east direction border cases
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws DirectionException 
	 * @throws MovementException 
	 */
	//@Test (expected = MovementException.class)
	public void testEastBorderCase() throws EnvironmentOutOfBoundsException, DirectionException //MovementException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm theFWord = new MockLifeForm("ldSKJFKDSJFSAF", 30);
		LifeForm obstacle = new MockLifeForm("obstacle", 30);
		e.addLifeForm(0, 4, obstacle);
		e.addLifeForm(0, 1, theFWord);
		theFWord.changeDirection('e');
		e.move(theFWord);
		assertEquals(3, theFWord.getCol());
	}
	
	/**
	 * Tests western direction border cases
	 * @throws DirectionException
	 * @throws EnvironmentOutOfBoundsException
	 * @throws MovementException
	 */
	//@Test (expected = MovementException.class)
	public void testWestBorderCase() throws DirectionException, EnvironmentOutOfBoundsException //MovementException
	{
		Environment e = Environment.getWorldInstance();
		LifeForm theFWord = new MockLifeForm("ldSKJFKDSJFSAF", 30);
		LifeForm obstacle = new MockLifeForm("obstacle", 30);
		e.addLifeForm(0, 1, obstacle);
		e.addLifeForm(0, 4, theFWord);
		theFWord.changeDirection('w');
		e.move(theFWord);
		assertEquals(2, theFWord.getCol());
	}
	
	
	@Before
	public void before() throws WorldInstanceException
	{
		Environment.removeWorldInstance();
		Environment.createWorldInstance(5, 5);
	}
	
	/**
	 * Tests the method getLifeForm() to see if it returns the proper life form in the selected cell
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws WorldInstanceException 
	 */
	@Test
	public void testBasicEnvironment() throws EnvironmentOutOfBoundsException, WorldInstanceException 
	{
		//Environment.createWorldInstance(5,5);
		Environment e = Environment.getWorldInstance();
		assertNull(e.getLifeForm(0,0));
	}
	
	/**
	 * Tests adding and removing LifeForms
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws WorldInstanceException 
	 */
	@Test
	public void testAddLifeForm() throws EnvironmentOutOfBoundsException, WorldInstanceException
	{
		//Environment.createWorldInstance(5,5);
		Environment e = Environment.getWorldInstance();
		LifeForm bob = new MockLifeForm("bob", 40);
		assertTrue(e.addLifeForm(1,2,bob));
		assertEquals(bob, e.getLifeForm(1,2));
		assertEquals(bob, e.removeLifeForm(1,2));
	}
	
	/**
	 * Tests adding a border case
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws WorldInstanceException 
	 */
	@Test
	public void testBorderCase() throws EnvironmentOutOfBoundsException, WorldInstanceException
	{
		//Environment.createWorldInstance(5,5);
		Environment e = Environment.getWorldInstance();
		LifeForm bob = new MockLifeForm("bob", 40);
		assertTrue(e.addLifeForm(1,2,bob));
		assertEquals(bob, e.getLifeForm(1,2));
		assertEquals(bob, e.removeLifeForm(1,2));
	}
	
	/**
	 * Tests add and removing a weapon
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws WorldInstanceException 
	 */
	@Test
	public void testAddRemoveWeapon() throws EnvironmentOutOfBoundsException, WorldInstanceException
	{
		//Environment.createWorldInstance(5,5);
		Environment e = Environment.getWorldInstance();
		Weapon pistol = new MockWeapon();
		assertTrue(e.addWeapon(3, 3, pistol));
		assertEquals(pistol, e.getWeapon(3, 3));
		assertEquals(pistol, e.removeWeapon(3, 3));
		assertNull(e.getWeapon(3,3));
	}
	
	/**
	 * Tests environment exception is thrown
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws WorldInstanceException 
	 */
	/*@Test (expected = EnvironmentOutOfBoundsException.class)
	public void testException() throws EnvironmentOutOfBoundsException, WorldInstanceException
	{
		//Environment.createWorldInstance(5,5);
		Environment e = Environment.getWorldInstance();
		Weapon pistol = new MockWeapon();
		LifeForm bob = new MockLifeForm("bob", 20);
		e.addWeapon(7, 7, pistol);
		e.addLifeForm(7, 7, bob);
		e.calculateDistance(7, 7, 7, 7);
	}*/
	
	/**
	 * Tests the distance between two lifeforms
	 * @throws EnvironmentOutOfBoundsException 
	 * @throws WorldInstanceException 
	 */
	@Test
	public void testDistance() throws EnvironmentOutOfBoundsException, WorldInstanceException
	{
		//Environment.createWorldInstance(5, 5);
		Environment e = Environment.getWorldInstance();
		Weapon pistol = new MockWeapon();
		LifeForm a = new MockLifeForm("sdahjglkdjs", 30);
		LifeForm b = new MockLifeForm("afijsdoifhsda", 30);
		LifeForm c = new MockLifeForm("owijfidhflfd", 30);
		e.addLifeForm(0, 0, a);
		e.addLifeForm(0,2,b);
		e.addLifeForm(3,2,c);
		assertEquals(10, e.calculateDistance(0, 0, 0, 2));
		assertEquals(18, e.calculateDistance(0, 0, 3, 2));
	}
}
