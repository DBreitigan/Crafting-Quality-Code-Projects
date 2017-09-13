package recover;
import lifeform.Alien;
import lifeform.LifeForm;
import static org.junit.Assert.*;
import org.junit.Test;
import recovery.RecoveryNone;

/**
 * 
 * @author Jake Moore
 */
public class TestRecoveryNone 
{
	
	/**
	 * Makes sure no life points gained on damaged alien
	 */
	@Test
	public void testRecoveryNoChange() 
	{
		RecoveryNone r1 = new RecoveryNone();
		assertEquals(30, r1.calculateRecovery(30, 40));
	}

}
