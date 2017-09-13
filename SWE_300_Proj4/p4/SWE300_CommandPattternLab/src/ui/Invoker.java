package ui;
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
import gameplay.*;
	
	
/**
 * This is the UI that implements the commands that each button press
 * will trigger.
 * @author Matthew Frutsche
 */
public class Invoker extends JFrame implements TimeObserver
{	
	protected int obsTime;
	private LifeForm lifeform;
	private LifeForm lifeform2;
	private Weapon weapon;
	private int distance;
	private char direction;
	
	//These are the needed components to create the UI
	JButton textButton;
	JLabel textLabel;
	
	/**
	 * This creates the instance of the Command UI with all of the needed buttons
	 */
	public Invoker()
	{
		//This is where the commands are created and used as the actions
		final Command Reload = new Reload(weapon);
		final Command Acquire = new Acquire(lifeform, weapon);
		final Command Drop = new Drop(lifeform);
		final Command Attack = new Attack(lifeform, lifeform2, distance);
		final Command Turn = new Turn(lifeform, direction);
		final Command Move = new Move(lifeform);
		
		//Sets up the main window
		setLayout(new BorderLayout());
		
		//This section is creating the buttons that will be used
		//and also sets up the actions of the buttons
		////////////////////////////////////////////////////////
		JButton up = new JButton("Move Up");
		up.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Turn.execute();
				Move.execute();
			}
		});
		add("North", up);
		
		JButton down = new JButton("Move Down");
		down.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Turn.execute();
				Move.execute();
			}
		});
		add("South", down);
		
		JButton left = new JButton("Move Left");
		left.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Turn.execute();
				Move.execute();
			}
		});
		add("West", left);
		
		JButton right = new JButton("Move Right");
		right.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Turn.execute();
				Move.execute();
			}
		});
		add("East", right);
		
		JPanel centerPanel = new JPanel(new GridLayout(1,1));
		JButton[][] buttonArray = new JButton[1][1];
		
		buttonArray[0][0] = new JButton("Attack");
		buttonArray[0][0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Attack.execute();
			}
		});
		
		buttonArray[0][1] = new JButton("Acquire");
		buttonArray[0][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Acquire.execute();
			}
		});
		
		buttonArray[1][0] = new JButton("Drop");
		buttonArray[1][0].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				Drop.execute();
			}
		});
		
		buttonArray[1][1] = new JButton("Reload");
		buttonArray[1][1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Reload.execute();
			}
		});
		//This is adding the array of buttons to the center panel grid
		int x;
		for(x = 0; x < 2; x++)
		{
			int y;
			for(y = 0; y < 2; y++)
			{
				centerPanel.add(buttonArray[x][y]);
			}
		}
		
		add("Center", centerPanel);
		/////////////////////////////////////////////////////////////
		
		pack();
		setVisible(true);
	}

	/**
	 * This is the time update method used to keep track of the round
	 * along with environment.
	 */
	@Override
	public void updateTime(int time) 
	{
		obsTime = time;
	}
}


