import lifeform.TestHuman;
import lifeform.TestLifeForm;
import lifeform.TestAlien;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import recover.TestRecoveryFractional;
import recover.TestRecoveryNone;
import recover.TestRecoveryLinear;
import weapon.TestAttachment;
import weapon.TestGenericWeapon;
import weapon.TestWeapon;
import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;


/**
 * Runs all the tests in this project
 * @author Jake Moore
 */
@RunWith(Suite.class)
@Suite.SuiteClasses
({
	TestLifeForm.class, TestCell.class, TestEnvironment.class, TestHuman.class, TestAlien.class, TestRecoveryNone.class, TestRecoveryLinear.class, TestRecoveryFractional.class, TestSimpleTimer.class, TestWeapon.class, TestAttachment.class, TestGenericWeapon.class
})

public class AllGameTests 
{
}
