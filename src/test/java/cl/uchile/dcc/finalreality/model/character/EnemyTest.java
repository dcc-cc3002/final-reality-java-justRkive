package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemyTest {
  private Enemy enemy0;
  private Enemy enemy1;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  Random rng = new Random();
  
  
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    enemy0 = new Enemy("Bad person", 100, 15, 5, testQueue, 6);
    enemy1 = new Enemy("Ugly person", 98, 13, 4, testQueue, 6);
  
  }
  
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectedEnemy0 = new Enemy("Bad person", 100, 15, 5, testQueue, 6);
    assertEquals(expectedEnemy0, enemy0);
    assertNotEquals(expectedEnemy0, enemy1);
    assertEquals(expectedEnemy0.hashCode(), enemy0.hashCode());
    assertNotEquals(expectedEnemy0.hashCode(), enemy1.hashCode());
  }
  
  
  @Test
  void testToString() {
    String expectedStr = "Enemy{weight=100, maxHp=15, defense=5, damage=6, name='Bad person'}";
    assertEquals(expectedStr, enemy0.toString());
  }
  
  @Test
  void waitTurnTest() {
  
  }
}
