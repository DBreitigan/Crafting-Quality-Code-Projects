package weapon;

public class MockWeapon extends GenericWeapon 
{
	public MockWeapon()
	{
		baseDam = 1;
		maxRange = 10;
		currentShots = 2;
		maxAmmo = 10;
		currentAmmo = maxAmmo;
	}

	public int calculateDamage() 
	{
		currentDam = baseDam;
		return currentDam;
	}

}
