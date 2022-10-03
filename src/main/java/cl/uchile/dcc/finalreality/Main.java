package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Axe;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Bow;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Knife;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Staff;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Sword;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Main class to run program.
 */
public class Main {
  /**
   * Main method to run the code.
   *
   * @param args The command line arguments.
   * @throws InvalidStatValueException Throws a Java exeption.
   */
  public static void main(String[] args) throws InvalidStatValueException, InterruptedException {
    BlockingQueue<GameCharacter> mainQueue = new LinkedBlockingQueue<>();
    Random rng = new Random();
    
    // We create all the characters in order to test their constructors
    List<PlayerCharacter> party = new ArrayList<PlayerCharacter>();
    PlayerCharacter engineer = new Engineer("Engineer person", 10, 5, mainQueue);
    party.add(engineer);
    BlackMage blackMage = new BlackMage("BlackMage person", 11, 6, 20, mainQueue);
    party.add(blackMage);
    PlayerCharacter knight = new Knight("Knight person", 11, 15, mainQueue);
    party.add(knight);
    PlayerCharacter thief = new Thief("Thief person", 10, 7, mainQueue);
    party.add(thief);
    WhiteMage whiteMage = new WhiteMage("WhiteMage person", 6, 11, 19, mainQueue);
    party.add(whiteMage);
   
    // We create another list with all the characters including enemy
    List<GameCharacter> characters = new ArrayList<GameCharacter>(party);
    GameCharacter enemy = new Enemy("Bad person", 100, 15, 5, mainQueue, 6);
    characters.add(enemy);
  
    // We create all the weapon types in order to test their constructors
    List<Weapon> weapons = new ArrayList<Weapon>();
    Axe axe0 = new Axe("Hacha fea", 13, 300);
    weapons.add(axe0);
    Bow bow0 = new Bow("Arco", 9, 105);
    weapons.add(bow0);
    Knife knife0 = new Knife("Cuchillo", 7, 30);
    weapons.add(knife0);
    Staff staff0 = new Staff("Varita mágica", 10, 37);
    weapons.add(staff0);
    Sword sword0 = new Sword("Espadita", 15, 250);
    weapons.add(sword0);
  
    System.out.println(party.toString());
    System.out.println(characters.toString());
    System.out.println(weapons.toString());
    
    System.out.println("(1) Testing toString functionality for every character and weapon created");
    for (int i = 0; i < 6; i++) {
      System.out.println(characters.get(i).toString());
    }
    System.out.println("---");
    for (int i = 0; i < 5; i++) {
      System.out.println(weapons.get(i).toString());
    }
    
    System.out.println("---------------------------------------");
  
    System.out.println("(2) Testing equals and hascode functionality");
    System.out.println("CHARACTERS ---");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + characters.get(i).getClass().getSimpleName());
      System.out.println("equals True Case:");
      System.out.println(characters.get(i).equals(characters.get(i)));
      System.out.println("---");
      System.out.println("hashCode True Case:");
      System.out.println(characters.get(i).hashCode() == characters.get(i).hashCode());
      System.out.println("---");
      System.out.println("equals False Case:");
      if (i < 5) {
        System.out.println(characters.get(i).equals(characters.get(i + 1)));
      } else {
        System.out.println(characters.get(i).equals(characters.get(0)));
      }
    }
    System.out.println("---");
    System.out.println("WEAPONS---");
    for (int i = 0; i < 5; i++) {
      System.out.println(i + ". Testing for " + weapons.get(i).getClass().getSimpleName());
      System.out.println("equals True Case:");
      System.out.println(weapons.get(i).equals(weapons.get(i)));
      System.out.println("---");
      System.out.println("hashCode True Case:");
      System.out.println(weapons.get(i).hashCode() == weapons.get(i).hashCode());
      System.out.println("---");
      System.out.println("equals False Case:");
      if (i < 4) {
        System.out.println(weapons.get(i).equals(weapons.get(i + 1)));
      } else {
        System.out.println(weapons.get(i).equals(weapons.get(0)));
      }
    }
  
    System.out.println("---------------------------------------");
  
    System.out.println("(3) Testing getName() for every character and weapon");
    System.out.println("CHARACTERS ---");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + characters.get(i).getClass().getSimpleName());
      System.out.println("Name is: " + characters.get(i).getName());
    }
    System.out.println("---");
    System.out.println("WEAPONS---");
    for (int i = 0; i < 5; i++) {
      System.out.println(i + ". Testing for " + weapons.get(i).getClass().getSimpleName());
      System.out.println("Name is: " + weapons.get(i).getName());
    }
    
    System.out.println("---------------------------------------");
    
    System.out.println("(4) Testing getMaxHp() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + characters.get(i).getClass().getSimpleName());
      System.out.println("Max Hp is: " + characters.get(i).getMaxHp());
    }
    
    System.out.println("---------------------------------------");
    
    System.out.println("(5) Testing getCurrentHp() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + characters.get(i).getClass().getSimpleName());
      System.out.println("Current Hp is: " + characters.get(i).getCurrentHp());
    }
    
    System.out.println("---------------------------------------");
    
    System.out.println("(6) Testing setCurrentHp() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + characters.get(i).getClass().getSimpleName());
      characters.get(i).setCurrentHp(5);
      System.out.println("CurrentHp was set at 5");
      System.out.println("Current Hp is: " + characters.get(i).getCurrentHp());
    }
    
    System.out.println("---------------------------------------");
    
    System.out.println("(7) Testing getDefense() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + characters.get(i).getClass().getSimpleName());
      System.out.println("Defense is: " + characters.get(i).getDefense());
    }
    
    System.out.println("---------------------------------------");
    
    System.out.println("(8) Testing equip() for every player character");
    for (int i = 0; i < 5; i++) {
      System.out.println(i + ". Testing for " + characters.get(i).getClass().getSimpleName());
      party.get(i).equip(weapons.get(i));
    }
  
    System.out.println("---------------------------------------");
  
    System.out.println("(9) Testing getEquippedWeapon() for every player character");
    for (int i = 0; i < 5; i++) {
      System.out.println(i + ". Testing for " + characters.get(i).getClass().getSimpleName());
      System.out.println("The equipped weapon is: " + party.get(i).getEquippedWeapon());
      
    }
  
    System.out.println("---------------------------------------");
  
    System.out.println("(10) Testing waitTurn() for every character");
    for (int i = 0; i < 6; i++) {
      characters.get(i).waitTurn();
    }
    // Waits for 10 seconds to ensure that all characters have finished waiting
    Thread.sleep(20000);
    System.out.println("Characters in queue:");
    while (!mainQueue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(mainQueue.poll().toString());
    }
  
    System.out.println("---------------------------------------");
    
    System.out.println("(11) Testing addToQueue() for every character");
    for (int i = 0; i < 6; i++) {
      characters.get(i).addToQueue();
    }
    Enemy enemy2 = new Enemy("Ugly person", 98, 13, 4, mainQueue, 6);
    System.out.println("Characters in queue:");
    while (!mainQueue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(mainQueue.poll().toString());
    }
    
    System.out.println("-------------");
    
    System.out.println("(12) Testing getMaxMp() for both mages");
    System.out.println("1. Testing for " + blackMage.getClass().getSimpleName());
    System.out.println("Max Mp is: " + blackMage.getMaxMp());
    System.out.println("2. Testing for " + whiteMage.getClass().getSimpleName());
    System.out.println("Max Mp is: " + whiteMage.getMaxMp());
  
    System.out.println("-------------");
  
    System.out.println("(13) Testing getCurrentMp() for both mages");
    System.out.println("1. Testing for " + blackMage.getClass().getSimpleName());
    System.out.println("Max Mp is: " + blackMage.getCurrentMp());
    System.out.println("2. Testing for " + whiteMage.getClass().getSimpleName());
    System.out.println("Max Mp is: " + whiteMage.getCurrentMp());
  
    System.out.println("-------------");
  
    System.out.println("(14) Testing setCurrentMp() for both mages");
    System.out.println("1. Testing for " + blackMage.getClass().getSimpleName());
    blackMage.setCurrentHp(6);
    System.out.println("CurrentMp was set at 6");
    System.out.println("Current Mp is: " + blackMage.getCurrentMp());
    System.out.println("2. Testing for " + whiteMage.getClass().getSimpleName());
    blackMage.setCurrentHp(7);
    System.out.println("CurrentMp was set at 7");
    System.out.println("Current Mp is: " + whiteMage.getCurrentMp());
  
    System.out.println("-------------");
  
    System.out.println("(15) Testing getDamage()");
    for (int i = 0; i < 5; i++) {
      System.out.println(i + ". Testing for " + weapons.get(i).getClass().getSimpleName());
      System.out.println("Damge is: " + weapons.get(i).getDamage());
    }
  
    System.out.println("(16) Testing getWeight()");
    for (int i = 0; i < 5; i++) {
      System.out.println(i + ". Testing for " + weapons.get(i).getClass().getSimpleName());
      System.out.println("Weight is: " + weapons.get(i).getWeight());
    }
  
  
  }
}
