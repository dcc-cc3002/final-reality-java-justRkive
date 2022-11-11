package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Knife;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCharacterTest {
  private Engineer engineer;
  private BlackMage blackMage;
  private Knight knight;
  private Thief thief;
  private WhiteMage whiteMage;
  private Enemy enemy;
  
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  List<GameCharacter> party = new ArrayList<GameCharacter>();
  String[] names = {"Engineer person", "BlackMage person", "Knight person",
        "Thief person", "WhiteMage person", "Bad person"};
  int[] MaxHps = {10, 11, 11, 10, 6, 15};
  int[] defenses = {5, 6, 15, 7, 11, 5};
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    engineer = new Engineer(names[0], MaxHps[0], defenses[0], testQueue);
    party.add(engineer);
    blackMage = new BlackMage(names[1], MaxHps[1], defenses[1], 20, testQueue);
    party.add(blackMage);
    knight = new Knight(names[2], MaxHps[2], defenses[2], testQueue);
    party.add(knight);
    thief = new Thief(names[3], MaxHps[3], defenses[3], testQueue);
    party.add(thief);
    whiteMage = new WhiteMage(names[4], MaxHps[4], defenses[4], 19, testQueue);
    party.add(whiteMage);
    enemy = new Enemy(names[5], 100, MaxHps[5], defenses[5], testQueue, 6);
    party.add(enemy);
  
  }
  
  @Test
  void getNameTest() {
    String[] expectNames = {"Engineer person", "BlackMage person", "Knight person",
          "Thief person", "WhiteMage person", "Bad person"};
    for (int i = 0; i < 6; i++) {
      assertEquals(expectNames[i], party.get(i).getName());
    }
    
  }
  
  @Test
  void getCurrentHpTest() throws InvalidStatValueException {
    int[] expectHps = {10, 11, 11, 10, 6, 15};
    for (int i = 0; i < 6; i++) {
      // Hp inicial: maxHp
      assertEquals(expectHps[i], party.get(i).getCurrentHp());
      // Set Hp en i
      party.get(i).setCurrentHp(i);
      assertEquals(i, party.get(i).getCurrentHp());
    }
  }
  
  @Test
  void getMaxHpTest() throws InvalidStatValueException {
    int[] expectMaxHps = {10, 11, 11, 10, 6, 15};
    for (int i = 0; i < 6; i++) {
      assertEquals(expectMaxHps[i], party.get(i).getMaxHp());
    }
  
  }
  
  @Test
  void getDefenseTest() {
    int[] expectDef = {5, 6, 15, 7, 11, 5};
    for (int i = 0; i < 6; i++) {
      assertEquals(expectDef[i], party.get(i).getDefense());
    }
  }
  
  @Test
  void setCurrentHpTest() throws InvalidStatValueException {
    int[] expectHps = {6, 8, 10, 7, 1, 14};
    for (int i = 0; i < 6; i++) {
      party.get(i).setCurrentHp(expectHps[i]);
      assertEquals(expectHps[i], party.get(i).getCurrentHp());
    }
    
    
  }
}