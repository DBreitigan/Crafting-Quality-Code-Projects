package lifeform;

public class MockLifeForm extends LifeForm
{
	public MockLifeForm(String name, int points)
	{
		myName = name;
		currentLifePoints = points;
		attack = 200;
		maxSpeed = 3;
	}
}
