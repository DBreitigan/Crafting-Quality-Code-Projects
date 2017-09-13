package recover;
import static org.junit.Assert.*;
import org.junit.Test;
import recovery.RecoveryLinear;

/**
 * Testing linear recovery
 * @author Jake Moore
 */
public class TestRecoveryLinear 
{
	
	/**
	 * Tests recovery for a fixed amount of LifePoints
	 */
	@Test
	public void testNoRecoveryWhenNotHurt() 
	{
		RecoveryLinear r1 = new RecoveryLinear(3);
		int maxLifePts = 30;
		int result = r1.calculateRecovery(maxLifePts, maxLifePts);
		assertEquals(maxLifePts, result);
	}
	
	/**
	 * More recovery tests to make sure it works when points recovered does not hit the max value
	 */
	@Test
	public void testRecoveryNotHitMaxValue()
	{
		RecoveryLinear r1 = new RecoveryLinear(3);
		int result = r1.calculateRecovery(30, 40);
		assertEquals(33, result);
	}
	
	/**
	 * Test when it only hurts a little
	 */
	@Test
	public void testSmallHurt()
	{
		RecoveryLinear r1 = new RecoveryLinear(10);
		assertEquals(40, r1.calculateRecovery(33, 40));
	}
	
	/**
	 * Makes sure an alien doesnt recover if its life points are zero
	 */
	@Test
	public void testDead()
	{
		RecoveryLinear r1 = new RecoveryLinear(10);
		assertEquals(0, r1.calculateRecovery(0, 40));
	}
	
	/**
	 * Tests when the alien gains the same amount of life points as its max life points
	 */
	@Test
	public void testBorder()
	{
		RecoveryLinear r1 = new RecoveryLinear(10);
		assertEquals(40, r1.calculateRecovery(30, 40));
	}
}
