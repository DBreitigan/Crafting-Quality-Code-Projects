package ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import environment.Cell;
import environment.Environment;
import lifeform.LifeForm;
import weapon.Pistol;
import weapon.ChainGun;
import weapon.PlasmaCannon;
import lifeform.Human;
import lifeform.Alien;


/**
 * The game's User Interface. Contains a Map of the game, legend for the icons, and player input 
 * commands.
 * @author Allen Crigger - The Terrible Map and Legend UI. 
 * WHAT NEEDS TO BE DONE: Condense the UI code/Make it a bit more legible.....
 */
public class UserInterface extends JFrame implements ActionListener
{
	
	JLabel[][] worldmap = new JLabel[5][5];
		
	/**
	 * Generation on the User Interface itself.
	 * -A North Panel contains the Map and Legend headers.
	 * -A West Panel contains the map itself. A Blank map is put in as a placeholder until the environment is added in.
	 * -A East Panel that contains the legend of icons along with a description about what each one represents.
	 * -A South Panel that can contain User Inputs that can interact with the objects that are displayed on the map.
	 * @author Allen Crigger
	 */
	public UserInterface()
	{	
		setLayout(new BorderLayout());
		JLabel commandLabel;
		
		/**
		 * The North Panel: Contains the headers for the Map & Legend
		 */
		JLabel mapLabel, legendLabel;
		JPanel northPanel = new JPanel(new GridLayout(1,2));
		northPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		legendLabel = new JLabel("Legend", SwingConstants.CENTER);
		northPanel.add(legendLabel);
		mapLabel = new JLabel("Map", SwingConstants.CENTER);
		northPanel.add(mapLabel, SwingConstants.CENTER);
		add("North", northPanel);
		
		/**
		 * The West Panel: Contains the UIs map interface.
		 * -A blank map is initialized until an environment/map update is applied.
		 */
		//West Panel initialization
		JPanel westPanel = new JPanel(new GridLayout(1,1));
		westPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		add("West", westPanel);
		
		//Initialization of a blank map
		JPanel map = new JPanel(new GridLayout(5,5));
		for(int r=0; r<5;r++)
		{
			for(int c=0; c<5; c++)
			{
				worldmap[r][c] = new JLabel(createImage());
		    	map.add(worldmap[r][c]);
			}
		}
		westPanel.add(map);
		
		/**
		 * The East Panel: Contains All of the information for the UI's Legend.
		 * Contains: Legend icons and a description about what each one represents.
		 */
		//East Panel initialization.
		JPanel eastPanel = new JPanel(new GridLayout(1,1));
		eastPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		add("East", eastPanel);
		//Labels used for the Legend.
		JLabel alienIcon, humanIcon, pistolIcon, chaingunIcon, plasmaIcon, directionIcon;
		JLabel HumanLabel, AlienLabel, pistolLabel, chaingunLabel, plasmaLabel, directionLabel;
		//Legend Panel that holds the legend icons/labels in a 4X3 GridFormat
		JPanel legendP = new JPanel(new GridLayout(3,4));
		//Sets the panel background to an ugly cream color
		legendP.setBackground(new Color(236,255,105));
		//Human Icon/Label
		humanIcon = new JLabel(createLegend(1));
		legendP.add(humanIcon);
		HumanLabel = new JLabel("Human", SwingConstants.CENTER);
		legendP.add(HumanLabel);
		//Alien Icon/Label 
		alienIcon = new JLabel(createLegend(2));
		legendP.add(alienIcon);
		AlienLabel = new JLabel("Alien", SwingConstants.CENTER);
		legendP.add(AlienLabel);
		//Direction Label/Icon
		directionIcon = new JLabel(createLegend(3));
		legendP.add(directionIcon);
		directionLabel = new JLabel("Direction (N/S/E/W)", SwingConstants.CENTER);
		legendP.add(directionLabel);
		//Pistol Label/Icon
		pistolIcon = new JLabel(createLegend(4));
		legendP.add(pistolIcon);
		pistolLabel = new JLabel("Pistol", SwingConstants.CENTER);
		legendP.add(pistolLabel);
		//ChainGun Label/Icon
		chaingunIcon = new JLabel(createLegend(5));
		legendP.add(chaingunIcon);
		chaingunLabel = new JLabel("ChainGun", SwingConstants.CENTER);
		legendP.add(chaingunLabel);
		plasmaIcon = new JLabel(createLegend(6));
		//PlasmaGun Label/Icon
		legendP.add(plasmaIcon);
		plasmaLabel = new JLabel("Plasma Cannon", SwingConstants.CENTER);
		legendP.add(plasmaLabel);
		eastPanel.add(legendP);
		
		//Command Panel?
		JPanel southPanel = new JPanel(new GridLayout(1,1));
		add("South", southPanel);
		commandLabel = new JLabel("-----At some point, We can add the commands below the Map & Legend-----", SwingConstants.CENTER);
		southPanel.add(commandLabel);
		
		pack();
		setTitle("Lab 6: Command Pattern - Map & Legend");
		//JFrame becomes visible
		setVisible(true);
		//JFrame is centered to the screen
		setLocationRelativeTo(null);
	}
	
	/**
	 * Updates that map to match any changes that may have been done to any of the LifeForms/Cell on
	 * the map.
	 * @param e the environment used the generate the map
	 */
	public void updateMap(Environment e)
	{
		Cell temp = new Cell();
		for(int r=0; r<5;r++)
		{
			for(int c=0; c<5; c++)
			{
				temp = e.getCell(r, c);
				worldmap[r][c].setIcon(createTile(temp));
			}
		}
	}
	
	/**
	 * This method creates a base tile for each cell of the environment. Used for initialization
	 * of the environment for the first time.
	 * @return A simple image tile of the cell.
	 */
	private ImageIcon createImage()
	{
		BufferedImage tileGen = new BufferedImage(100,100,BufferedImage.TYPE_3BYTE_BGR);
		Graphics drawer = tileGen.getGraphics();
		
		drawer.setColor(new Color(200,200,200));
		drawer.fillRect(0, 0, 100, 100);
		
		return new ImageIcon(tileGen);
	}
	
	/**
	 * This method creates tiles that are needed for the legend panel.
	 * @param i the type of legend icon that is needed.
	 * @return the legend icon tile.
	 * @author Allen Crigger
	 */
	private ImageIcon createLegend(int i)
	{
		BufferedImage legend = new BufferedImage(100,100,BufferedImage.TYPE_3BYTE_BGR);
		Graphics drawer = legend.getGraphics();
		
		//Base Background color
		drawer.setColor(new Color(236,255,105));
		drawer.fillRect(0, 0, 100, 100);
		
		switch(i)
		{
			case 1:
				//Human Icon
				drawer.setColor(new Color(0,0,255));
				drawer.fillOval(40, 40, 20, 20);
				break;
			case 2:
				//Alien Icon
				drawer.setColor(new Color(73,255,17));
				drawer.fillOval(40, 40, 20, 20);
				break;
			case 3:
				//Directional Icon
				drawer.setColor(new Color(0,255,255));
				drawer.fillRect(45, 10, 10, 20);
				drawer.fillRect(45, 70, 10, 20);
				drawer.fillRect(0, 45, 20, 10);
				drawer.fillRect(80, 45, 20, 10);
				break;
			case 4:
				//Pistol Icon
				drawer.setColor(new Color(0,0,0));
				drawer.fillRect(45, 50, 6, 6);
				drawer.fillRect(45, 46, 12, 6);
				break;
			case 5:
				//ChainGun Icon
				drawer.setColor(new Color(255,27,27));
				drawer.fillRect(45, 50, 6, 6);
				drawer.fillRect(45, 46, 12, 6);
				break;
			case 6: 
				//PlasmaCannon Icon
				drawer.setColor(new Color(126,0,172));
				drawer.fillRect(45, 50, 6, 6);
				drawer.fillRect(45, 46, 12, 6);
				break;
		}
		
		return new ImageIcon(legend);
	}
	
	/**
	 * This method takes in a cell and creates a 100x100 image icon of it. What the image contains
	 * shape and color-wise, depends on what each cell contains.
	 * @param c the selected cell that the method will create an image of.
	 * @return a tile containing everything within the selected cell in icon form.
	 * @author Allen Crigger
	 */
	private ImageIcon createTile(Cell c)
	{
		LifeForm holder = null;
		BufferedImage tile = new BufferedImage(100,100,BufferedImage.TYPE_3BYTE_BGR);
		Graphics drawer = tile.getGraphics();
		holder = c.getLifeForm();
		
		//Base Background color
		drawer.setColor(new Color(200,200,200));
		drawer.fillRect(0, 0, 100, 100);
		
		if(c.getLifeForm() != null)
		{
			//Creates a small oval, color depends on LifeForm subclass
			if(holder.getClass() == Human.class)
			{
				//If the LifeForm is human, then it's a blue circle
				drawer.setColor(new Color(0,0,255));
				drawer.fillOval(40, 40, 20, 20);
			}
			if (holder.getClass() == Alien.class)
			{
				//If the LifeForm is alien, then it's a green circle
				drawer.setColor(new Color(73,255,17));
				drawer.fillOval(40, 40, 20, 20);
			}
			
			//Creates a small line for direction
			drawer.setColor(new Color(0,255,255));
			switch (holder.getDirection())
			{
				case "North":
					drawer.fillRect(45, 10, 10, 20);
					break;
				case "South":
					drawer.fillRect(45, 70, 10, 20);
					break;
				case "East":
					drawer.fillRect(0, 45, 20, 10);
					break;
				case "West":
					drawer.fillRect(80, 45, 20, 10);
					break;
				default:
					break;
			}
			
			//makes a gun next to the player icon if they have gun
			if(holder.getWeapon() != null)
			{
				//If the held weapon is a Pistol, then the weapon will be Black.
				if(holder.getWeapon().getClass() == Pistol.class)
				{
					drawer.setColor(new Color(0,0,0));
					drawer.fillRect(62, 50, 6, 6);
					drawer.fillRect(62, 46, 12, 6);
				}
				//If the held weapon is a ChainGun, then the weapon will be Red.
				if(holder.getWeapon().getClass() == ChainGun.class)
				{
					drawer.setColor(new Color(255,27,27));
					drawer.fillRect(62, 50, 6, 6);
					drawer.fillRect(62, 46, 12, 6);
				}
				//If the held weapon is a PlasmaCannon, then the weapon will be Purple.
				if(holder.getWeapon().getClass() == PlasmaCannon.class)
				{
					drawer.setColor(new Color(126,0,172));
					drawer.fillRect(62, 50, 6, 6);
					drawer.fillRect(62, 46, 12, 6);
				}
			}
			
		}
		
		//Places a small gun icon on the bottom-left corner if the cell contains a weapon on the ground.
		if(c.getWeapon() != null)
		{
			//If the weapon on the ground is a Pistol, then the color will be Black.
			if(c.getWeapon().getClass() == Pistol.class)
			{
				drawer.setColor(new Color(0,0,0));
				drawer.fillRect(5, 94, 6, 6);
				drawer.fillRect(5, 90, 12, 6);
			}
			//If the weapon on the ground is a ChainGun, then the color will be Red
			if(c.getWeapon().getClass() == ChainGun.class)
			{
				drawer.setColor(new Color(255,27,27));
				drawer.fillRect(5, 94, 6, 6);
				drawer.fillRect(5, 90, 12, 6);
			}
			//If the weapon on the ground is a PlasmaCannon, then the color will be Purple
			if(c.getWeapon().getClass() == PlasmaCannon.class)
			{
				drawer.setColor(new Color(126,0,172));
				drawer.fillRect(5, 94, 6, 6);
				drawer.fillRect(5, 90, 12, 6);
			}
		}
		
		return new ImageIcon(tile);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
