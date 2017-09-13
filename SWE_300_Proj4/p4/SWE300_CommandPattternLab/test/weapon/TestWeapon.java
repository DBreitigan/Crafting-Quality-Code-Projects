package weapon;
import static org.junit.Assert.*;
import gameplay.SimpleTimer;
import gameplay.Timer;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import org.junit.Test;
/**
 * @author Jake Moore Sam Selkregg Cade Reed
 * Weapon test class
 */
public class TestWeapon 
{
	/**
	 * Tests Pistol
	 */
	@Test
	public void testPistolDam() 
	{	
		Weapon pistol = new Pistol();
		pistol.updateLocation(2);
		assertEquals(11, pistol.calculateDamage());
		pistol.updateLocation(40);
		assertEquals(0, pistol.calculateDamage());
		pistol.updateLocation(20);
		assertEquals(4, pistol.calculateDamage());
	}
	
	/**
	 * Tests Plasma Cannon
	 */
	@Test
	public void testPlasmaDam()
	{
		LifeForm dummy = new MockLifeForm("dummy", 9999999);
		Weapon plasmaCannon = new PlasmaCannon();
		plasmaCannon.updateLocation(2);
		assertEquals(50, plasmaCannon.calculateDamage());
		plasmaCannon.fire(dummy, 2);
		assertEquals(37, plasmaCannon.calculateDamage());
		plasmaCannon.updateLocation(40);
		assertEquals(0, plasmaCannon.calculateDamage());
	}
	
	/**
	 * Test Chain Gun
	 */
	@Test
	public void testChainGun()
	{
		Weapon chainGun = new ChainGun();
		chainGun.updateLocation(2);
		assertEquals(1, chainGun.calculateDamage());
		chainGun.updateLocation(30);
		assertEquals(15, chainGun.calculateDamage());
		chainGun.updateLocation(40);
		assertEquals(0, chainGun.calculateDamage());
	}
	
	/**
	 * Tests firing the pistol
	 */
	@Test
	public void testFirePistol()
	{
		LifeForm stan = new MockLifeForm("stan", 40);
		LifeForm cartman = new MockLifeForm("cartman", 40);
		Weapon pistol = new Pistol();
		stan.addWeapon(pistol);
		pistol.fire(cartman, 2);
		assertEquals(29, cartman.getCurrentLifePoints());
	}
	
	/**
	 * Tests firing the plasma cannon
	 */
	@Test
	public void testFirePlasmaCannon()
	{
		LifeForm satan = new MockLifeForm("Satan", 200);
		LifeForm kenny = new MockLifeForm("Kenny", 40);
		Weapon plasmaCannon = new PlasmaCannon();
		satan.addWeapon(plasmaCannon);
		plasmaCannon.fire(kenny,2);
		assertEquals(0, kenny.getCurrentLifePoints());
	}
	
	/**
	 * Test firing chain gun
	 */
	@Test
	public void testFireChainGun()
	{
		LifeForm thug = new MockLifeForm("thug", 20);
		LifeForm victim = new MockLifeForm("victim", 20);
		Weapon chainGun = new ChainGun();
		thug.addWeapon(chainGun);
		chainGun.fire(victim, 2);
		assertEquals(19, victim.getCurrentLifePoints());
	}
	
	/** 
	 * these test will not work anymore due to fire rate unless the time is updated to them
	 */
	/*
	@Test
	public void testReload()
	{
		//initializing all weapons
		Weapon pistol = new Pistol(2);
		Weapon covenantCarbine = new PlasmaCannon(2);
		Weapon chainGun = new ChainGun(2);
		assertEquals(10, pistol.getCurrentAmmo());
		assertEquals(4, covenantCarbine.getCurrentAmmo());
		assertEquals(40, chainGun.getCurrentAmmo());
		LifeForm grunt = new MockLifeForm("grunt", 1000000);
		
		//testing pistol reload
		pistol.fire(grunt);
		pistol.fire(grunt);
		pistol.fire(grunt);
		assertEquals(8, pistol.getCurrentAmmo());
		for(int i = 0; i < 7; i++)
		{
			pistol.fire(grunt);
		}
		assertEquals(0, pistol.getCurrentAmmo());
		pistol.reload();
		assertEquals(10, pistol.getCurrentAmmo());
		
		//testing plasma gun reload
		covenantCarbine.fire(grunt);
		covenantCarbine.fire(grunt);
		assertEquals(2, covenantCarbine.getCurrentAmmo());
		covenantCarbine.fire(grunt);
		covenantCarbine.fire(grunt);
		assertEquals(0, covenantCarbine.getCurrentAmmo());
		covenantCarbine.reload();
		assertEquals(4, covenantCarbine.getCurrentAmmo());
		
		//testing chain gun reload
		chainGun.fire(grunt);
		chainGun.fire(grunt);
		assertEquals(38, chainGun.getCurrentAmmo());
		for(int i = 0; i < 38; i++)
		{
			chainGun.fire(grunt);
		}
		assertEquals(0, chainGun.getCurrentAmmo());
		chainGun.reload();
		assertEquals(40, chainGun.getCurrentAmmo());
	}*/
	
	/**
	 * Tests rate of fire
	 */
	@Test
	public void testRateOfFire()
	{
		Timer t = new SimpleTimer(1000);
		LifeForm target = new MockLifeForm("target", 9999999);
		Weapon pistol = new Pistol();
		t.addTimeObserver(pistol);
		pistol.fire(target, 2);
		pistol.fire(target, 2);
		t.timeChanged();
		pistol.fire(target, 2);
		pistol.fire(target, 2);
		pistol.fire(target, 2);
	}
	

}
