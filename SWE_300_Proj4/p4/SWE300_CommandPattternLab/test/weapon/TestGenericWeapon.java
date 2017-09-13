package weapon;
import static org.junit.Assert.*;
import org.junit.Test;
import gameplay.SimpleTimer;
import gameplay.Timer;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestGenericWeapon 
{

	/**
	 * test GenericWeapons ability to initialize, fire, reload, and ranges.
	 */
	@Test
	public void testGenericWeapon() 
	{
		LifeForm victim = new MockLifeForm("victim", 20);
		Weapon gun = new MockWeapon();
		gun.fire(victim, 10);
		assertEquals(19, victim.getCurrentLifePoints());
		assertEquals(9, gun.getCurrentAmmo());
		gun.reload();
		assertEquals(10, gun.getCurrentAmmo());	
		gun.updateLocation(11);
		gun.fire(victim, 11);
		assertEquals(19, victim.getCurrentLifePoints());
		gun.updateLocation(9);;	
	}
	
	/**
	 * test that GenericWeapons only fire the amount they can per round
	 * this is not working yet it will stop once it reaches its fire rate and won't start on next round
	 */
	@Test
	public void testGenericWeaponFireRate()
	{
		Timer t = new SimpleTimer(1000);
		LifeForm victim = new MockLifeForm("victim", 20);
		Weapon gun = new MockWeapon();
		t.addTimeObserver(gun);
		assertEquals(0, t.getRound());
		gun.fire(victim, 10);
		gun.fire(victim, 10);
		assertEquals(18, victim.getCurrentLifePoints());
		gun.fire(victim, 10);
		assertEquals(17, victim.getCurrentLifePoints());
		t.timeChanged();
		assertEquals(1, t.getRound());
		gun.fire(victim, 10);
		assertEquals(16, victim.getCurrentLifePoints());
	}

}
