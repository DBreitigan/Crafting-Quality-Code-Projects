package recover;
import static org.junit.Assert.*;
import org.junit.Test;
import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;

/**
 * Tests fractional Recovery
 * @author Jake Moore
 */
public class TestRecoveryFractional 
{
	/**
	 * Tests to make sure everything works
	 */
	@Test
	public void testBasic() 
	{
		RecoveryBehavior sandwich = new RecoveryFractional(.13);
		assertEquals(113, sandwich.calculateRecovery(100, 200));
	}
	
	/**
	 * Test no recovery when not hurt
	 */
	@Test
	public void testNoRecoveryWhenNotHurt()
	{
		RecoveryBehavior dovahkin = new RecoveryFractional(.13);
		assertEquals(0, dovahkin.calculateRecovery(0, 200));
	}
	
	/**
	 * Tests max life
	 */
	@Test
	public void testMaxtLife()
	{
		RecoveryBehavior blah = new RecoveryFractional(.13);
		assertEquals(200, blah.calculateRecovery(200, 200));
	}
	
	/**
	 * Tests rounding up
	 */
	@Test
	public void testRoundUp()
	{
		RecoveryBehavior r = new RecoveryFractional(.1);
		assertEquals(103, r.calculateRecovery(93, 200));
	}
	
	/**
	 * Tests will not go over max life
	 */
	@Test
	public void testGoOver()
	{
		RecoveryBehavior r = new RecoveryFractional(.5);
		assertEquals(200, r.calculateRecovery(190, 200));
	}

}
