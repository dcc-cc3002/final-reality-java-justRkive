package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EngineerTest {
  Engineer engineer0;
  Engineer engineer1;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    engineer0 = new Engineer("Engineer person", 10, 5, testQueue);
    engineer1 = new Engineer("Steve", 20, 7, testQueue);
  }
  
  @Test
  void testToString() {
  }
  
  @Test
  void testHashCode() {
  }
  
  @Test
  void testEquals() {
  }
}
