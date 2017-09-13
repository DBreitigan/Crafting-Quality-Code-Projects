package main;

//Holds the data for our State Machine so we can easily pass around all pieces of data
public class StateData
{
	public int s;
	public float v = 0;
	public double p = 0.0;
	public char c = ' ';
	public MealyState state;
	public String input = " ";
	
	public StateData(String in)
	{
		s = 1;
		v = 0;
		input = in;
			
		if(!input.isEmpty())
		{
			c = input.charAt(0);
		}
		else
		{
			c = '\0';
		}
			
		state = new StartState();
		state.checkState(this);		
	}
	
	//Updates input string and C
	public void NextChar()
	{
		input = input.substring(1);
		if(!input.isEmpty())
		{				
			c = input.charAt(0);
		}
		else
		{
			c = '\0';
		}
		
	}
	
	//Gets the next state
	public void nextState(String next)
	{
		if(!input.isEmpty())
		{
			this.NextChar();
		}
		if(next == "Integer")
		{
			state = new IntegerState();
		}
		else if(next == "Decimal")
		{
			state  = new DecimalState();
		}
		else if (next == "End")
		{
			state = new EndState();
		}
		else
		{
			state = null;
			System.out.println("Invalid characters were inputted.");
		}
		
		//state.checkState(this);
	}
}
