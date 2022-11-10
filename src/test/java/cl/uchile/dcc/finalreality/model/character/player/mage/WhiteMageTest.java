package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WhiteMageTest {
  private WhiteMage wmage0;
  private WhiteMage wmage1;
  Staff staff0;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    wmage0 = new WhiteMage("WhiteMage person", 13, 8, 22, testQueue);
    wmage1 = new WhiteMage("Dave", 15, 3, 19, testQueue);
    staff0 = new Staff("Baston", 10, 37);
  
  }
  
  @Test
  void testToString() {
    String expectWMage = "WhiteMage{maxHp=13, defense=8, maxMp=22, name='WhiteMage person'}";
    assertEquals(expectWMage, wmage0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectWMage = new WhiteMage("WhiteMage person", 13, 8, 22, testQueue);
    var expectBMage = new BlackMage("BlackMage person", 11, 6, 20, testQueue);
    assertEquals(expectWMage, wmage0);
    assertEquals(wmage0, wmage0);
    assertNotEquals(expectBMage, wmage0);
    assertNotEquals(expectWMage, wmage1);
    assertEquals(expectWMage.hashCode(), wmage0.hashCode());
    assertNotEquals(expectWMage.hashCode(), wmage1.hashCode());
  }
  
  @Test
  void equipTest() {
    wmage0.equip(staff0);
    assertEquals(staff0, wmage0.getEquippedWeapon());
  }
  
  @Test
  void getEquippedWeaponTest() {
    // Before equiping a weapon, it is null
    assertEquals(null, wmage0.getEquippedWeapon());
  }
}
