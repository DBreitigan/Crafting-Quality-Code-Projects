package weapon;
import gameplay.TimeObserver;
import lifeform.LifeForm;

/**
 * @author Jake Moore Sam Selkregg Cade Reed
 * Beginning of weapon interface
 */
public interface Weapon extends TimeObserver
{
	//implemented in GenericWeapon
		public void fire(LifeForm victim, int distance);
		public void reload();
		public int getCurrentAmmo();
		public int getMaxAmmo();
		public int getMaxRange();
		public void modifyMaxRange(int newRange);
		//public int getCurrentDam();
		//public void modifyCurrentDam(int dam);
		public int getCurrentLocation();
		public void updateLocation(int range);
		public void updateTime(int time);
		public int getNumberOfAttachments();
		//public void addAttachment(Attachment attachment);
		//public void removeAttachment(int location);
		//implemented in unique weapon
		public int calculateDamage();
}
