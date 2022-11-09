package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BlackMageTest {
  private BlackMage bmage0;
  private BlackMage bmage1;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    bmage0 = new BlackMage("BlackMage person", 11, 6, 20, testQueue);
    bmage1 = new BlackMage("Mago", 15, 3, 19, testQueue);
  }
  
  @Test
  void testToString() {
    String expectBMage = "BlackMage{maxHp=11, defense=6, maxMp=20, name='BlackMage person'}";
    assertEquals(expectBMage, bmage0.toString());
  }
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectBMage = new BlackMage("BlackMage person", 11, 6, 20, testQueue);
    var expectWMage = new WhiteMage("WhiteMage person", 13, 8, 22, testQueue);
    assertEquals(expectBMage, bmage0);
    assertEquals(bmage0, bmage0);
    assertNotEquals(expectWMage, bmage0);
    assertNotEquals(expectBMage, bmage1);
    assertEquals(expectBMage.hashCode(), bmage0.hashCode());
    assertNotEquals(expectBMage.hashCode(), bmage1.hashCode());
  }
}
