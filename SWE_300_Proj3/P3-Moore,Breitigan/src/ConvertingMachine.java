import exceptions.EnumIndexException;

/**
 * A finite state machine that parses a string containing a real number. Will
 * throw NumberFormatExcaption if the string doesn't not contain a legal
 * representation of a real number. Note: we are not dealing with scientific
 * notation
 *
 * @author Merlin
 *
 */
public class ConvertingMachine
{
	//Array of possible Edge's we could traverse
	private final Edge[] machine =
	{
			new Edge(State.START, new DigitInputVerifier(),
					new ValueIsDigitAction(), State.INTEGER),
			new Edge(State.START, new MinusInputVerifier(), new NegateAction(),
					State.INTEGER),
			new Edge(State.START, new PlusInputVerifier(), new NoAction(),
					State.INTEGER),
			new Edge(State.START, new PeriodInputVerifier(),
					new StartFraction(), State.DECIMAL),
			new Edge(State.INTEGER, new DigitInputVerifier(),
					new ContinuingIntegerAction(), State.INTEGER),
			new Edge(State.INTEGER, new PeriodInputVerifier(),
					new StartFraction(), State.DECIMAL),
			new Edge(State.DECIMAL, new DigitInputVerifier(),
					new ContinuingFractionAction(), State.DECIMAL)
	};

	//Takes the input of a string and uses the Edge to turn it 
	//into a number. If an invalid character is seen, throws
	//NumberFormatException
	public double parse(String text)
	{
		InterimResult result = new InterimResult(0.0, 1, 0.0);
		Edge edge = machine[0];
	
		boolean firstPass = true;
		
		while(text.length() > 0)
		{			
			if(firstPass == true)
			{
				firstPass = false;
				edge = searchForEdge(State.START, text.charAt(0));
			}
			else
			{
				edge = searchForEdge(edge.nextState, text.charAt(0));
			}
			
			if(edge == null)
			{
				throw new NumberFormatException();
			}
			else
			{
				Action action = edge.getAction();
				result = action.execute(result, text.charAt(0));
			}
			
			text = text.substring(1);
		}
				
		return result.getV() * result.getS();
	}

	//Searches for the next edge to traverse
	private Edge searchForEdge(State currentState, char ch)
	{
		InputVerifier verifier;
		for(int i = 0; i < machine.length; i++)
		{
			verifier = machine[i].getInputVerifier();
			if((verifier.meetsCriteria(ch))&&(currentState == machine[i].getCurrentState()))
			{
				return machine[i];
			}
		}
		return null;
		
	}

	//Edge class to handle our current state, our inputVerifier to check if the 
	//Input is correct, an Action if state and Input Verifier match, and the next
	//state
	private class Edge
	{
		State currentState;
		InputVerifier inputVerifier;
		Action action;
		State nextState;

		public Edge(State currentState, InputVerifier inputVerifier,
				Action action, State nextState)
		{
			this.currentState = currentState;
			this.inputVerifier = inputVerifier;
			this.action = action;
			this.nextState = nextState;
		}

		public State getCurrentState()
		{
			return currentState;
		}
		
		public InputVerifier getInputVerifier()
		{
			return inputVerifier;
		}
		
		public Action getAction(){
			return action;
		}
	}

	//Enumerator of states
	private enum State
	{
		START, INTEGER, DECIMAL, END;
	}

	//Gets state based on the number
	public State getState(int i) throws EnumIndexException
	{
		if(i == 0)
			return State.START;
		if(i == 1)
			return State.INTEGER;
		if(i == 2)
			return State.DECIMAL;
		if(i == 3)
			return State.END;
		else
			throw new EnumIndexException();
	}
}
