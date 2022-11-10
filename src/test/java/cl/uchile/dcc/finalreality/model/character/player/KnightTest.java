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

public class KnightTest {
  private Knight knight0;
  private Knight knight2;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  List<Weapon> weapons = new ArrayList<Weapon>();
  
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    knight0 = new Knight("Knight person", 11, 15, testQueue);
    knight2 = new Knight("John", 15, 18, testQueue);
    Axe axe0 = new Axe("Hacha fea", 13, 300);
    weapons.add(axe0);
    Bow bow0 = new Bow("Arco", 9, 105);
    Knife knife0 = new Knife("Cuchillo", 7, 30);
    weapons.add(knife0);
    Staff staff0 = new Staff("Baston", 10, 37);
    Sword sword0 = new Sword("Espadita", 15, 250);
    weapons.add(sword0);
  }
  
  @Test
  void testToString() {
    String expectStrKnigh = "Knight{maxHp=11, defense=15, name='Knight person'}";
    assertEquals(expectStrKnigh, knight0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectKnigh = new Knight("Knight person", 11, 15, testQueue);
    var expectEng0 = new Engineer("Engineer person", 10, 5, testQueue);
    assertEquals(expectKnigh, knight0);
    assertEquals(knight0, knight0);
    assertNotEquals(expectEng0, expectKnigh);
    assertNotEquals(expectKnigh, knight2);
    assertEquals(expectKnigh.hashCode(), knight0.hashCode());
    assertNotEquals(expectKnigh.hashCode(), knight2.hashCode());
  }
  
  @Test
  void equipTest() {
    for (int i = 0; i < 3; i++) {
      knight0.equip(weapons.get(i));
      assertEquals(weapons.get(i), knight0.getEquippedWeapon());
    }
  }
  
  @Test
  void getEquippedWeaponTest() {
    // Before equiping a weapon, it is null
    assertEquals(null, knight0.getEquippedWeapon());
  }
  
}
