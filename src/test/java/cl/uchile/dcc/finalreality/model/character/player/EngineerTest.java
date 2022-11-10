package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
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

public class EngineerTest {
  private Engineer engineer0;
  private Engineer engineer1;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  List<Weapon> weapons = new ArrayList<Weapon>();
  
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    engineer0 = new Engineer("Engineer person", 10, 5, testQueue);
    engineer1 = new Engineer("Steve", 20, 7, testQueue);
  
    Axe axe0 = new Axe("Hacha fea", 13, 300);
    weapons.add(axe0);
    Bow bow0 = new Bow("Arco", 9, 105);
    weapons.add(bow0);
    Knife knife0 = new Knife("Cuchillo", 7, 30);
    Staff staff0 = new Staff("Baston", 10, 37);
    Sword sword0 = new Sword("Espadita", 15, 250);
  }
  
  @Test
  void testToString() {
    String expectStrEng = "Engineer{maxHp=10, defense=5, name='Engineer person'}";
    assertEquals(expectStrEng, engineer0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectEng0 = new Engineer("Engineer person", 10, 5, testQueue);
    var expectThief = new Thief("Thief person", 10, 7, testQueue);
    assertEquals(expectEng0, engineer0);
    assertEquals(engineer0, engineer0);
    assertNotEquals(expectThief, expectEng0);
    assertNotEquals(expectEng0, engineer1);
    assertEquals(expectEng0.hashCode(), engineer0.hashCode());
    assertNotEquals(expectEng0.hashCode(), engineer1.hashCode());
  }
  @Test
  void equipTest() {
    for (int i = 0; i < 2; i++) {
      engineer0.equip(weapons.get(i));
      assertEquals(weapons.get(i), engineer0.getEquippedWeapon());
    }
  }
  
  @Test
  void getEquippedWeaponTest() {
    // Before equiping a weapon, it is null
    assertEquals(null, engineer0.getEquippedWeapon());
  }
  
}
