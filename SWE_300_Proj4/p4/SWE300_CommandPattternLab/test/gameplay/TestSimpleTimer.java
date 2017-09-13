package gameplay;
import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import org.junit.Test;

/**
 * Test for SimpleTimer class
 * @author Jake Moore
 */
public class TestSimpleTimer
{

	/**
	 * Makes sure you can construct an instance of simple timer
	 */
	@Test
	public void testCreateTimer() 
	{
		Timer t = new SimpleTimer(1000);
	}
	
	/**
	 * Tests adding a time observer to the timer
	 */
	@Test
	public void testAddTimeObserver()
	{
		Timer t = new SimpleTimer(1000);
		LifeForm pikachu = new MockLifeForm("pikachu", 20);
		t.addTimeObserver(pikachu);
	}
	
	/**
	 * Tests removing a time observer from the timer
	 */
	@Test
	public void testRemoveTimeObserver()
	{
		Timer t = new SimpleTimer(1000);
		LifeForm squirtle = new MockLifeForm("Squirtle Squad", 20);
		t.removeTimeObserver(squirtle);
	}
	
	/**
	 * Makes sure time changed works correctly
	 */
	@Test
	public void testTimeChanged()
	{
		Timer t = new SimpleTimer(1000);
		LifeForm tedCruz = new MockLifeForm("Ted Cruz", 600);
		MockSimpleTimerObserver m = new MockSimpleTimerObserver();
		t.addTimeObserver(tedCruz);
		assertEquals(0, t.getRound());
		t.timeChanged();
		assertEquals(1, t.getRound());
	}
	
	/**
	 * Tests that SimpleTimer will update time once every second
	 * @exception InterruptedException
	 */
	@Test
	public void testSimpleTimerAsThread() throws InterruptedException
	{
		SimpleTimer st = new SimpleTimer(1000);
		st.start();
		Thread.sleep(250);
		for(int x = 0; x < 5; x++)
		{
			assertEquals(x, st.getRound());
			Thread.sleep(1000);
		}
	}
	
	/**
	 * Similar to mock life form, a mock time observer
	 * @author Jake Moore
	 */
	class MockSimpleTimerObserver implements TimeObserver
	{
		public int myTime = 0;
		
		public void updateTime(int time)
		{
			myTime = time;
		}
	}

}
