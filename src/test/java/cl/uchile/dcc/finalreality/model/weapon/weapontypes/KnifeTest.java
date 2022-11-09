package cl.uchile.dcc.finalreality.model.weapon.weapontypes;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KnifeTest {
  private Knife knife0;
  private Knife knife1;
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    knife0 = new Knife("Cuchillo", 7, 30);
    knife1 = new Knife("Naif", 6, 28);
    
  }
  
  @Test
  void testToString() {
    String expectStr = "Knife{name='Cuchillo', damage=7, weight=30}";
    assertEquals(expectStr, knife0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectKnife = new Knife("Cuchillo", 7, 30);
    var expectStaff = new Staff("Varita mágica", 10, 37);
    assertEquals(knife0, knife0);
    assertEquals(expectKnife, knife0);
    assertNotEquals(expectKnife, knife1);
    assertNotEquals(expectStaff, knife0);
    assertEquals(expectKnife.hashCode(), knife0.hashCode());
    assertNotEquals(expectKnife.hashCode(), knife1.hashCode());
  }
}
