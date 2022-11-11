package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThiefTest {
  private Thief thief0;
  private Thief thief1;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  List<Weapon> weapons = new ArrayList<Weapon>();
  List<Weapon> notAllowed = new ArrayList<Weapon>();
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    thief0 = new Thief("Thief person", 10, 7, testQueue);
    thief1 = new Thief("Mark", 18, 3, testQueue);
  
    Axe axe0 = new Axe("Hacha fea", 13, 300);
    notAllowed.add(axe0);
    Bow bow0 = new Bow("Arco", 9, 105);
    weapons.add(bow0);
    Knife knife0 = new Knife("Cuchillo", 7, 30);
    weapons.add(knife0);
    Staff staff0 = new Staff("Baston", 10, 37);
    notAllowed.add(staff0);
    Sword sword0 = new Sword("Espadita", 15, 250);
    weapons.add(sword0);
  }
  
  @Test
  void testToString() {
    String expectStrThief = "Thief{maxHp=10, defense=7, name='Thief person'}";
    assertEquals(expectStrThief, thief0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectThief = new Thief("Thief person", 10, 7, testQueue);
    var expectKnigh = new Knight("Meta Knight", 11, 15, testQueue);
    assertEquals(thief0, thief0);
    assertEquals(expectThief, thief0);
    assertNotEquals(expectKnigh, thief0);
    assertNotEquals(expectThief, thief1);
    assertEquals(expectThief.hashCode(), thief0.hashCode());
    assertNotEquals(expectThief.hashCode(), thief1.hashCode());
  }
  
  @Test
  void equipTest() {
    for (int i = 0; i < 3; i++) {
      thief0.equip(weapons.get(i));
      assertEquals(weapons.get(i), thief0.getEquippedWeapon());
    }
  
    for (int i = 0; i < 2; i++) {
      thief0.equip(notAllowed.get(i));
      assertNotEquals(notAllowed.get(i), thief0.getEquippedWeapon());
    }
  }
  
  @Test
  void getEquippedWeaponTest() {
    // Before equiping a weapon, it is null
    assertEquals(null, thief0.getEquippedWeapon());
  }
}
