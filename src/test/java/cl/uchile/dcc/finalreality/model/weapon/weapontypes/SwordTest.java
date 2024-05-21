package cl.uchile.dcc.finalreality.model.weapon.weapontypes;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SwordTest {
  private Sword sword0;
  private Sword sword1;
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    sword0 = new Sword("Excálibur", 15, 250);
    sword1 = new Sword("Espadita", 28, 301);
    
  }
  
  @Test
  void testToString() {
    String expectStr = "Sword{name='Excálibur', damage=15, weight=250}";
    assertEquals(expectStr, sword0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectSword = new Sword("Excálibur", 15, 250);
    var expectAxe = new Axe("Hacha fea", 13, 300);
    assertEquals(sword0, sword0);
    assertEquals(expectSword, sword0);
    assertNotEquals(expectSword, sword1);
    assertNotEquals(expectAxe, sword0);
    assertEquals(expectSword.hashCode(), sword0.hashCode());
    assertNotEquals(expectSword.hashCode(), sword1.hashCode());
  }
}
