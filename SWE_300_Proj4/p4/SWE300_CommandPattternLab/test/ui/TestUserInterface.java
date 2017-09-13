package ui;
import javax.swing.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;

import static org.junit.Assert.*;
import lifeform.Alien;
import lifeform.Human;
import weapon.ChainGun;
import weapon.PlasmaCannon;
import weapon.Pistol;
import exceptions.DirectionException;
import exceptions.EnvironmentOutOfBoundsException;
import exceptions.MyNewException;
import exceptions.WorldInstanceException;
/**
 * A test of the User Interface
 * @author Allen College - Map & Legend part of the user interface
 *
 */
public class TestUserInterface {
	
	/**
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
	 * Map UI Test. Makes sure everything spawns correctly on the map with all the right, ugly images.
	 * @author Allen College
	 */
	@Test
	public void TestUIMap() throws MyNewException, EnvironmentOutOfBoundsException, DirectionException
	{
		UserInterface test = new UserInterface();
		Pistol gun = new Pistol();
		ChainGun gun2 = new ChainGun();
		PlasmaCannon gun3 = new PlasmaCannon();
		Environment e = Environment.getWorldInstance();
		//Initial test of if the base map is made.
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Did the empty map and legend generate?"));
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "UI looks alright?"));
		
		/**
		 * Test #1: Generates the first map design to make sure everything shows up with the correct icon.
		 * -Adds 4 LifeForms to the map. (2 Aliens and 2 Humans)
		 * -2 LifeForms have a weapon equipped.
		 * -Each of the 4 LifeForms have a different direction.
		 */
		Alien steve = new Alien("Steve",40);
		steve.changeDirection('n');
		steve.addWeapon(gun);
		Alien dave = new Alien("Dave", 40);
		dave.changeDirection('e');
		Human bob = new Human("Bob", 40, 10);
		bob.changeDirection('s');
		bob.addWeapon(gun2);
		Human dan = new Human("Dan", 40, 10);
		dan.changeDirection('w');
		
		//Place LifeForms in the environment/map
		e.addLifeForm(0, 0, bob);
		e.addLifeForm(0,2, steve);
		e.addLifeForm(2, 4, dave);
		e.addLifeForm(3,2, dan);
		
		//Update the map to reflect the changes
		test.updateMap(e);
		
		//Checks to make sure Test #1 was a success.
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Does the map contain 2 humans and 2 aliens, and do all of them face a different direction?"));
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Does one alien and one human have a weapon?"));
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Are all of the icons that are displaying correct?"));
		
		/**
		 * Test #2 demonstrates the updateMap method.
		 * -Removes two of the LifeForms.
		 * -Adds 3 different types of guns to the map.
		 * -Successfully updates to reflect any changes done to the the LifeForm and Environment.
		 */
		e.removeLifeForm(0, 2);
		e.removeLifeForm(3, 2);
		///put some weapons on the ground
		e.addWeapon(0, 4, gun3);
		e.addWeapon(0, 1, gun2);
		e.addWeapon(4, 4, gun);
		//Update to reflect changes
		test.updateMap(e);
		
		//Checks to make sure Test #2 was a success.
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Have two LifeForms been removed from the map?"));
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Do the weapons on the ground have the correct icons (Pistol is black, ChainGun is red, Plasma Cannon is purple)?"));
	}
}
