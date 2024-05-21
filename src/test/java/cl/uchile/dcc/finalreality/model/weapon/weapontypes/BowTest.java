package cl.uchile.dcc.finalreality.model.weapon.weapontypes;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BowTest {
  private Bow bow0;
  private Bow bow1;
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    bow0 = new Bow("Arco", 9, 105);
    bow1 = new Bow("Arquito", 7, 96);
    
  }
  
  @Test
  void testToString() {
    String expectStr = "Bow{name='Arco', damage=9, weight=105}";
    assertEquals(expectStr, bow0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectKife = new Knife("Cuchillo", 7, 30);
    var expectBow = new Bow("Arco", 9, 105);
    assertEquals(bow0, bow0);
    assertEquals(expectBow, bow0);
    assertNotEquals(expectBow, bow1);
    assertNotEquals(expectKife, bow0);
    assertEquals(expectBow.hashCode(), bow0.hashCode());
    assertNotEquals(expectBow.hashCode(), bow1.hashCode());
  }
}
