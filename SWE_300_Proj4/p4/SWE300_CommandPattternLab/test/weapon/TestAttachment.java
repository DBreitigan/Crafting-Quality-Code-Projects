package weapon;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAttachment 
{
	/**
	 * Tests updating the location
	 */
	@Test
	public void testCurrentRange()
	{
		Weapon pistol = new Pistol();
		pistol.updateLocation(2);
		assertEquals(2, pistol.getCurrentLocation());
	}

	/**
	 * Tests that our pistol works with a scope, with a scope and a stabilizer,
	 * also with a scope and a power booster.
	 */
	@Test
	public void testPistol() 
	{
		Weapon pistol = new Pistol();
		pistol.updateLocation(2);
		/**
		 * Test with no attachment
		 */
		assertEquals(11, pistol.calculateDamage());
		pistol = new Scope(pistol);
		//pistol.addAttachment(scope);
		/**
		 * Test with scope
		 */
		assertEquals(21, pistol.calculateDamage());
		/**
		 * Test with scope and stabilizer
		 */
		pistol = new Stabilizer(pistol);
		//pistol.addAttachment(s);
		assertEquals(286, pistol.calculateDamage());
		/**
		 * Make sure we can remove an attachment on a pistol
		 */
		//pistol.removeAttachment(1);
		assertEquals(2, pistol.getNumberOfAttachments());
		/**
		 * Test with scope and power booster
		 */
		pistol = new PowerBooster(pistol);
		//pistol.addAttachment(pb);
		assertEquals(42, pistol.calculateDamage());
		//pistol.removeAttachment(1);
		/**
		 * Test with double scopes
		 */
		//pistol.addAttachment(scope);
		assertEquals(40, pistol.calculateDamage());
	}
	
	/**
	 * Tests that our plasma cannon works with a stabilizer, with a stabilizer 
	 * and a scope, and a stabilizer and a power booster
	 */
	@Test
	public void testPlasmaCannon()
	{
		Weapon pc = new PlasmaCannon();
		pc.updateLocation(2);
		/**
		 * Test with no attachment
		 */
		assertEquals(50, pc.calculateDamage());
		Attachment stabilizer = new Stabilizer(pc);
		//pc.addAttachment(stabilizer);
		/**
		 * Test with stabilizer
		 */
		assertEquals(62, pc.calculateDamage());
		/**
		 * Test for stabilizer and scope
		 */
		Attachment scope = new Scope(pc);
		//pc.addAttachment(scope);
		assertEquals(117, pc.calculateDamage());
		/**
		 * Check that we can remove an attachment from a plasma cannon
		 */
		//pc.removeAttachment(1);
		assertEquals(1, pc.getNumberOfAttachments());
		/**
		 * Test with stabilizer and power booster
		 */
		Attachment pb = new PowerBooster(pc);
		//pc.addAttachment(pb);
		assertEquals(124, pc.calculateDamage());
		//pc.removeAttachment(1);
		/**
		 * Test with double stabilizers
		 */
		//pc.addAttachment(stabilizer);
		assertEquals(77, pc.calculateDamage());
	}
	
	/**
	 * Tests that our chain gun works with a power booster, a power booster and a scope,
	 * and a power booster and a stabilizer
	 */
	@Test
	public void testChainGun()
	{
		Weapon cg = new ChainGun();
		cg.updateLocation(2);
		/**
		 * Test with no attachment
		 */
		assertEquals(1, cg.calculateDamage());
		Attachment powerBooster = new PowerBooster(cg);
		//cg.addAttachment(powerBooster);
		/**
		 * Test with power booster
		 */
		assertEquals(2, cg.calculateDamage());
		Attachment s = new Scope(cg);
		//cg.addAttachment(s);
		/**
		 * Test with power booster and scope
		 */
		assertEquals(3, cg.calculateDamage());
		/**
		 * Make sure we can remove an attachment
		 */
		//cg.removeAttachment(1);
		assertEquals(1, cg.getNumberOfAttachments());
		/**
		 * Test with double power boosters
		 */
		//cg.addAttachment(powerBooster);
		assertEquals(4, cg.calculateDamage());
		//cg.removeAttachment(1);
		/**
		 * Make sure we can remove the scope correctly
		 */
		assertEquals(2, cg.calculateDamage());
		Attachment s1 = new Stabilizer(cg);
		//cg.addAttachment(s1);
		/**
		 * Test for stabilizer and power booster, since damage doesn't 
		 * change when stabilizer is on, test to see that it has both
		 * attachments equipped.
		 */
		assertEquals(2, cg.calculateDamage());
		assertEquals(2, cg.getNumberOfAttachments());
	}
	
	/**
	 * A test that makes sure that a weapon cannot have more than two 
	 * attachments.
	 */
	@Test
	public void twoAttachmentsMax()
	{
		Weapon p = new Pistol();
		p = new Scope(p);
		p = new Stabilizer(p);
		p = new PowerBooster(p);
		assertEquals(2, p.getNumberOfAttachments());
	}
	
}
