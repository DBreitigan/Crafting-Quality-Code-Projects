package main;

//End State for Horner
public class EndState implements MealyState{

	@Override
	public StateData checkState(StateData data) {
		System.out.println("The Final Number is: " + data.v);
		// TODO Auto-generated method stub
		return null;
	}

}
