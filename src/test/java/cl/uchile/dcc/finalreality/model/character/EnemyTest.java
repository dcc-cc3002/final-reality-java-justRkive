package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemyTest {
  private Enemy enemy0;
  private Enemy enemy1;
  private Enemy enemy2;
  private Enemy enemy3;
  
  List<Enemy> enemies = new ArrayList<Enemy>();
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  Random rng = new Random();
  
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    enemy0 = new Enemy("seokjin", 20, 15, 5, testQueue, 6);
    enemies.add(enemy0);
    enemy1 = new Enemy("namjoon", 50, 13, 4, testQueue, 15);
    enemies.add(enemy1);
    enemy2 = new Enemy("yoongi", 10, 13, 4, testQueue, 9);
    enemies.add(enemy2);
    enemy3 = new Enemy("hobi", 30, 16, 3, testQueue, 6);
    enemies.add(enemy3);
    
  }
  
  
  @Test
  void testEquals() throws InvalidStatValueException {
    var expectedEnemy0 = new Enemy("seokjin", 20, 15, 5, testQueue, 6);
    var expectKnigh = new Knight("Meta Knight", 11, 15, testQueue);
    assertEquals(enemy0, enemy0);
    assertNotEquals(expectKnigh, enemy0);
    assertEquals(expectedEnemy0, enemy0);
    assertNotEquals(expectedEnemy0, enemy1);
    assertNotEquals(expectedEnemy0, expectKnigh);
    assertEquals(expectedEnemy0.hashCode(), enemy0.hashCode());
    assertNotEquals(expectedEnemy0.hashCode(), enemy1.hashCode());
  }
  
  
  @Test
  void testToString() {
    String expectedStr = "Enemy{weight=20, maxHp=15, defense=5, damage=6, name='seokjin'}";
    assertEquals(expectedStr, enemy0.toString());
  }
  
  @Test
  void getWeightTest() {
    assertEquals(20, enemy0.getWeight());
    assertEquals(50, enemy1.getWeight());
  
  }
  
  @Test
  void waitTurnTest() throws InvalidStatValueException, InterruptedException {
    List<Enemy> expected = new ArrayList<Enemy>();
    expected.add(enemy2);
    expected.add(enemy0);
    expected.add(enemy3);
    expected.add(enemy1);
    
    List<Enemy> testedOrder = new ArrayList<Enemy>();
    for (int i = 0; i < 4; i++) {
      enemies.get(i).waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!testQueue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      testedOrder.add((Enemy) testQueue.poll());
    }
    
    for (int i = 0; i < 4; i++) {
      assertEquals(expected.get(i), testedOrder.get(i));
    }
    
  }
}