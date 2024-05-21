package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {
  Engineer engineer;
  BlackMage blackMage;
  WhiteMage whiteMage;
  Knight knight;
  Thief thief;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  List<PlayerCharacter> party = new ArrayList<PlayerCharacter>();

  @BeforeEach
  void setUp() throws InvalidStatValueException {
    Axe axe0 = new Axe("Hacha fea", 13, 50);
    Sword sword0 = new Sword("Espadita", 15, 40);
    Bow bow0 = new Bow("Arco", 9, 30);
    Knife knife0 = new Knife("Cuchillo", 7, 20);
    Staff staff0 = new Staff("Baston", 10, 10);
    
    engineer = new Engineer("Engineer with bow", 10, 5, testQueue);
    engineer.equip(bow0);
    party.add(engineer);
    
    blackMage = new BlackMage("BlackMage with knife", 11, 6, 20, testQueue);
    blackMage.equip(knife0);
    party.add(blackMage);
    
    knight = new Knight("Knight with axe", 11, 15, testQueue);
    knight.equip(axe0);
    party.add(knight);
    
    thief = new Thief("Thief with sword", 10, 7, testQueue);
    thief.equip(sword0);
    party.add(thief);
    
    whiteMage = new WhiteMage("WhiteMage with staff", 6, 11, 19, testQueue);
    whiteMage.equip(staff0);
    party.add(whiteMage);
  }
  
  
  @Test
  void waitTurnTest() throws InvalidStatValueException, InterruptedException {
    List<PlayerCharacter> expected = new ArrayList<PlayerCharacter>();
    expected.add(whiteMage);
    expected.add(blackMage);
    expected.add(engineer);
    expected.add(thief);
    expected.add(knight);
    
    List<PlayerCharacter> testedOrder = new ArrayList<PlayerCharacter>();
    for (int i = 0; i < 5; i++) {
      party.get(i).waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!testQueue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      testedOrder.add((PlayerCharacter) testQueue.poll());
    }
  
    for (int i = 0; i < 5; i++) {
      assertEquals(expected.get(i), testedOrder.get(i));
    }
    
  }
}