package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KnightTest {
  private Knight knight0;
  private Knight knight2;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    knight0 = new Knight("Knight person", 11, 15, testQueue);
    knight2 = new Knight("John", 15, 18, testQueue);
  }
  
  @Test
  void testToString() {
    String expectStrKnigh = "Knight{maxHp=11, defense=15, name='Knight person'}";
    assertEquals(expectStrKnigh, knight0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectKnigh = new Knight("Knight person", 11, 15, testQueue);
    assertEquals(expectKnigh, knight0);
    assertNotEquals(expectKnigh, knight2);
    assertEquals(expectKnigh.hashCode(), knight0.hashCode());
    assertNotEquals(expectKnigh.hashCode(), knight2.hashCode());
  }
}
