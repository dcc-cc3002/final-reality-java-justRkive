package cl.uchile.dcc.finalreality.model.weapon.weapontypes;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AxeTest {
  private Axe axe0;
  private Axe axe1;
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    axe0 = new Axe("Hacha fea", 13, 300);
    axe1 = new Axe("Otra hacha", 15, 335);
  
  }
  
  @Test
  void testToString() {
    String expectStr = "Axe{name='Hacha fea', damage=13, weight=300}";
    assertEquals(expectStr, axe0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectAxe = new Axe("Hacha fea", 13, 300);
    var expectBow = new Bow("Arco", 9, 105);
    assertEquals(axe0, axe0);
    assertEquals(expectAxe, axe0);
    assertNotEquals(expectAxe, axe1);
    assertNotEquals(expectBow, axe0);
    assertEquals(expectAxe.hashCode(), axe0.hashCode());
    assertNotEquals(expectAxe.hashCode(), axe1.hashCode());
  }
}
