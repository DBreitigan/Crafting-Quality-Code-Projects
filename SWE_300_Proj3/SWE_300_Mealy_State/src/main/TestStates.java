package main;

import static org.junit.Assert.*;

import org.junit.Test;

//Class to test all the states
public class TestStates {


	@Test
	public void testStartStateDigit()
	{
		StateData data = new StateData("502.2");
		assertEquals(5.0, data.v, .0001);
		assertTrue(data.state instanceof IntegerState);
	}
	
	@Test
	public void testStartStateMinus()
	{
		StateData data = new StateData("-502.2");
		assertEquals(-1, data.s);
		assertTrue(data.state instanceof IntegerState);
	}
	
	@Test
	public void testStartStateDecimal()
	{
		StateData data = new StateData(".5022");
		assertEquals(.1, data.p, .0001);
		assertTrue(data.state instanceof DecimalState);
	}
	
	@Test
	public void testStartStatePlus()
	{
		StateData data = new StateData("+5022");
		assertTrue(data.state instanceof IntegerState);
	}
	
	@Test
	public void testStartStateOther()
	{
		StateData data = new StateData("&5022");
		assertEquals(data.state , null);
	}
	
	@Test
	public void testIntegerStateDigit()
	{
		StateData data = new StateData("502.2");
		data.state.checkState(data);
		assertEquals(data.v, 50, .0001);
		assertTrue(data.state instanceof IntegerState);
	}
	
	@Test
	public void testIntegerStateDecimal()
	{
		StateData data = new StateData("5.022");
		data.state.checkState(data);
		assertEquals(.1, data.p, .0001);
		assertTrue(data.state instanceof DecimalState);
	}
	
	@Test
	public void testIntegerStateOther()
	{
		StateData data = new StateData("5&022");
		data.state.checkState(data);
		assertEquals(data.state , null);
	}
	
	@Test
	public void testIntegerStateEnd()
	{
		StateData data = new StateData("5");
		data.state.checkState(data);
		assertTrue(data.state instanceof EndState);
	}
	
	@Test
	public void testDecimalStateDigit()
	{
		StateData data = new StateData(".222");
		data.state.checkState(data);
		assertEquals(data.v, .2, .0001);
		assertTrue(data.state instanceof DecimalState);
	}
	
	@Test
	public void testDecimalStateOther()
	{
		StateData data = new StateData(".&022");
		data.state.checkState(data);
		assertEquals(data.state , null);
	}
	
	@Test
	public void testDecimalStateEnd()
	{
		StateData data = new StateData(".");
		data.state.checkState(data);
		assertTrue(data.state instanceof EndState);
	}
}
