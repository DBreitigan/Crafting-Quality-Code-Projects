package main;

//Decimal State for Horner
public class DecimalState implements MealyState{

	@Override
	public StateData checkState(StateData data) {
		
		if(data.c >= '0' && data.c <= '9')
		{
			data.v += data.p * (data.c - '0');
			data.p /= 10;
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
