package ui;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import ui.*;
import weapon.*;
import lifeform.*;
import environment.*;
import exceptions.WorldInstanceException;

/**
 * This Class is to test the Invoker user interface, aka the UserInterface(Command)
 * @author Matthew Frutsche (some test code borrowed from Allan Crigger)
 */
public class TestInvoker 
{
	/**
	 * (Allan's test)
	 * Environment generation before the test begins.
	 * @throws WorldInstanceException
	 */
	@Before
	public void before() throws WorldInstanceException
	{
		Environment.removeWorldInstance();
		Environment.createWorldInstance(5, 5);
	}
	
	/**
	 * Tests the turning/movement buttons
	 */
	@Test
	public void testTurnButtons()
	{
		//Creating the CommandUI and the game map/world
		Invoker CommandUI = new Invoker();
		UserInterface theWorld = new UserInterface();
		
		//Creating lifeforms for the world
		Human bob = new Human("Bob", 40, 10);
		bob.changeDirection('n');
		Alien spock = new Alien("Spock", 40);
		spock.changeDirection('s');
		
		//Testing Turning
		assertTrue(bob.down.performClick());
		assertEquals('s', bob.getDirectionChar());
		
		assertTrue(spock.left.performClick());
		assertEquals('w', bob.getDirectionChar());
	}
	
	/**
	 * This tests the reload, drop, acquire, and attack buttons
	 * (Many test parts of this were borrowed from Allan for use with the CommandUI tests)
	 */
	@Test
	public void testOtherButtons()
	{
		//Creating the CommandUI and the game map/world
		Invoker CommandUI = new Invoker();
		UserInterface theWorld = new UserInterface();
		Environment environ = Environment.getWorldInstance();
		
		//Creating objects to be used in the world
		Human bob = new Human("Bob", 40, 10);
		Alien spock = new Alien("Spock", 40);
		
		Pistol pistol = new Pistol();
		ChainGun chaingun = new ChainGun();
		PlasmaCannon plasmacannon = new PlasmaCannon();
		
		//Placing lifeforms and weapons within the map
		environ.addLifeForm(2, 4, bob);
		environ.addLifeForm(2, 3, spock);
		
		environ.addWeapon(0, 1, pistol);
		environ.addWeapon(2, 3, chaingun);
	
		//Testing Acquire
		AssertTrue(spock.acquire.performClick());
		assertEquals(chaingun, spock.getWeapon());
		
		//Testing Reload
		pistol.fire(bob, 5);
		assertTrue(spock.reload.performClick());
		assertEquals(40, chaingun.getCurrentAmmo());
		
		//Testing Drop
		assertTrue(spock.drop.performClick());
		assertEquals(null, spock.getWeapon());
		
		//Testing Attack
		assertTrue(spock.attack.performClick());
		assertEquals(5, bob.getArmorPoints());
		assertEquals(40, bob.getCurrentLifePoints());
	}
}
