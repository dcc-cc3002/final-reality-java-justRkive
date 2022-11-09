package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMageTest {
  private BlackMage blackMage;
  private WhiteMage whiteMage;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    blackMage = new BlackMage("BlackMage person", 11, 6, 20, testQueue);
    whiteMage = new WhiteMage("Mago blanco", 15, 7, 15, testQueue);
  }
  
  @Test
  void getCurrentMp() {
    assertEquals(20, blackMage.getCurrentMp());
    assertEquals(15, whiteMage.getCurrentMp());
  
  }
  
  @Test
  void setCurrentMp() throws InvalidStatValueException {
    int expMpBlack = 13;
    int expMpWhite = 14;
    blackMage.setCurrentMp(expMpBlack);
    whiteMage.setCurrentMp(expMpWhite);
    assertEquals(expMpBlack, blackMage.getCurrentMp());
    assertEquals(expMpWhite, whiteMage.getCurrentMp());
  }
  
  @Test
  void getMaxMp() {
    assertEquals(20, blackMage.getMaxMp());
    assertEquals(15, whiteMage.getMaxMp());
  }
}