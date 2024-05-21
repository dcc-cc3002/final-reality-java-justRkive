package cl.uchile.dcc.finalreality.model.weapon.weapontypes;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StaffTest {
  private Staff staff0;
  private Staff staff1;
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    staff0 = new Staff("Varita mágica", 10, 37);
    staff1 = new Staff("Varita", 15, 45);
    
  }
  
  @Test
  void testToString() {
    String expectStr = "Staff{name='Varita mágica', damage=10, weight=37}";
    assertEquals(expectStr, staff0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectSword = new Sword("Excálibur", 15, 250);
    var expectStaff = new Staff("Varita mágica", 10, 37);
    assertEquals(staff0, staff0);
    assertEquals(expectStaff, staff0);
    assertNotEquals(expectStaff, staff1);
    assertNotEquals(expectSword, staff0);
    assertEquals(expectStaff.hashCode(), staff0.hashCode());
    assertNotEquals(expectStaff.hashCode(), staff1.hashCode());
  }
}
