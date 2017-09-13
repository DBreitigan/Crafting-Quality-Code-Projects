package main;

//Start State for Horner
public class StartState implements MealyState{

	@Override
	public StateData checkState(StateData data) {
		
		if(data.c >= '0' && data.c <= '9')
		{
			data.v = data.c - '0';
			data.nextState("Integer");
		}
		else if(data.c == '-')
		{
			data.s = -1;
			data.nextState("Integer");
		}
		else if(data.c == '+')
		{
			data.nextState("Integer");
		}
		else if(data.c == '.')
		{
			data.p = 0.1;
			data.nextState("Decimal");
		}
		else{
			data.nextState("Other");
		}
		
		return null;
	}
}
