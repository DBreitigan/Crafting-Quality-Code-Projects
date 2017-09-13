

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInputVerifiers 
{

	@Test
	public void testDigitInputVerifier() 
	{
		InputVerifier digit = new DigitInputVerifier();
		assertTrue(digit.meetsCriteria('0'));
		assertTrue(digit.meetsCriteria('9'));
		assertFalse(digit.meetsCriteria('/'));
		assertFalse(digit.meetsCriteria(':'));
	}

	@Test
	public void testPlusInputVerifier()
	{
		InputVerifier plus = new PlusInputVerifier();
		assertTrue(plus.meetsCriteria('+'));
		assertFalse(plus.meetsCriteria('-'));
	}
	
	@Test
	public void testMinusInputVerifier()
	{
		InputVerifier minus = new MinusInputVerifier();
		assertTrue(minus.meetsCriteria('-'));
		assertFalse(minus.meetsCriteria('+'));
	}
	
	@Test
	public void testPeriodInputVerifier()
	{
		InputVerifier period = new PeriodInputVerifier();
		assertTrue(period.meetsCriteria('.'));
		assertFalse(period.meetsCriteria('5'));
	}
}
