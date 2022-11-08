package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {
  private Engineer engineer;
  private BlackMage blackMage;
  private Knight knight;
  private Thief thief;
  private WhiteMage whiteMage;
  private Enemy enemy;
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  List<PlayerCharacter> party = new ArrayList<PlayerCharacter>();
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
  }
  
  
  @Test
  void equip() {
  }
  
  @Test
  void getEquippedWeapon() {
  }
  
  @Test
  void waitTurn() {
  }
}