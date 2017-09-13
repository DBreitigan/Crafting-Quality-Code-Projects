package main;

//Integer State for Horner
public class IntegerState implements MealyState{

	@Override
	public StateData checkState(StateData data) {
		
		if(data.c >= '0' && data.c <= '9')
		{
			data.v = (10 * data.v) + (data.c - '0');

			data.nextState("Integer");
		}
		else if(data.c == '.')
		{
			data.p = 0.1;
			data.nextState("Decimal");
		}
		else if(data.c == '\0')
		{
			data.nextState("End");
		}
		else{
			data.nextState("Other");
		}
		
		return null;
	}

}
