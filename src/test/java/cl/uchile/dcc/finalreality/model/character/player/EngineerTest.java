package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EngineerTest {
  private Engineer engineer0;
  private Engineer engineer1;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    engineer0 = new Engineer("Engineer person", 10, 5, testQueue);
    engineer1 = new Engineer("Steve", 20, 7, testQueue);
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
}
