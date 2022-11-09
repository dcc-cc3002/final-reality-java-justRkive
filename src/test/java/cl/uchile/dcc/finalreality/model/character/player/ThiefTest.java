package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThiefTest {
  private Thief thief0;
  private Thief thief1;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    thief0 = new Thief("Thief person", 10, 7, testQueue);
    thief1 = new Thief("Mark", 18, 3, testQueue);
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
}
