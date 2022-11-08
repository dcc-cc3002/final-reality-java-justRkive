package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
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

class AbstractCharacterTest {
  BlockingQueue<GameCharacter> testQueue = new LinkedBlockingQueue<>();
  List<PlayerCharacter> party = new ArrayList<PlayerCharacter>();
  
  
  
  
  @BeforeEach
  void setUp() throws InvalidStatValueException {
    PlayerCharacter engineer = new Engineer("Engineer person", 10, 5, testQueue);
    party.add(engineer);
    BlackMage blackMage = new BlackMage("BlackMage person", 11, 6, 20, testQueue);
    party.add(blackMage);
    PlayerCharacter knight = new Knight("Knight person", 11, 15, testQueue);
    party.add(knight);
    PlayerCharacter thief = new Thief("Thief person", 10, 7, testQueue);
    party.add(thief);
    WhiteMage whiteMage = new WhiteMage("WhiteMage person", 6, 11, 19, testQueue);
    party.add(whiteMage);
  }
  
  @AfterEach
  void tearDown() {
  }
  
  @Test
  void addToQueue() {
  }
  
  @Test
  void getName() {
  }
  
  @Test
  void getCurrentHp() {
  }
  
  @Test
  void getMaxHp() {
  }
  
  @Test
  void getDefense() {
  }
  
  @Test
  void setCurrentHp() {
  }
}