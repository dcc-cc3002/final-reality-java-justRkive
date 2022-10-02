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
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
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
  public static void main(String[] args) throws InvalidStatValueException {
    BlockingQueue<GameCharacter> mainQueue = new LinkedBlockingQueue<>();
    Random rng = new Random();
    
    // We create all the characters in order to test their constructors
    List<GameCharacter> party = new ArrayList<GameCharacter>();
    PlayerCharacter engineer = new Engineer("Engineer person", 10, 5, mainQueue);
    party.add(engineer);
    PlayerCharacter blackMage = new BlackMage("BlackMage person", 11, 6, 20, mainQueue);
    party.add(blackMage);
    PlayerCharacter knight = new Knight("Knight person", 11, 15, mainQueue);
    party.add(knight);
    PlayerCharacter thief = new Thief("Thief person", 10, 7, mainQueue);
    party.add(thief);
    PlayerCharacter whiteMage = new WhiteMage("WhiteMage person", 6, 11, 19, mainQueue);
    party.add(whiteMage);
    GameCharacter enemy = new Enemy("Bad person", 100, 15, 5, mainQueue);
    party.add(enemy);
  
    // We create all the weapon types in order to test their constructors
    List<Object> weapons = new ArrayList<Object>();
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

  
    System.out.println("(1) Testing toString functionality for every character and weapon created");
    for (int i = 0; i < 6; i++) {
      System.out.println(party.get(i).toString());
    }
    System.out.println("---");
    for (int i = 0; i < 5; i++) {
      System.out.println(weapons.get(i).toString());
    }
    System.out.println("-------------");
  
    System.out.println("(2) Testing equals and hascode functionality");
    System.out.println("CHARACTERS ---");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + party.get(i).getClass().getSimpleName());
      System.out.println("equals True Case:");
      System.out.println(party.get(i).equals(party.get(i)));
      System.out.println("---");
      System.out.println("hashCode True Case:");
      System.out.println(party.get(i).hashCode() == party.get(i).hashCode());
      System.out.println("---");
      System.out.println("equals False Case:");
      if (i < 5) {
        System.out.println(party.get(i).equals(party.get(i + 1)));
      } else {
        System.out.println(party.get(i).equals(party.get(0)));
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
  
    System.out.println("-------------");
  
    System.out.println("(3) Testing getName() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + party.get(i).getClass().getSimpleName());
      System.out.println("Name is: " + party.get(i).getName());
    }
    System.out.println("-------------");
  
  
    System.out.println("(4) Testing getMaxHp() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + party.get(i).getClass().getSimpleName());
      System.out.println("Max Hp is: " + party.get(i).getMaxHp());
    }
    System.out.println("-------------");
  
  
    System.out.println("(5) Testing getCurrentHp() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + party.get(i).getClass().getSimpleName());
      System.out.println("Current Hp is: " + party.get(i).getCurrentHp());
    }
    System.out.println("-------------");
  
  
    System.out.println("(6) Testing setCurrentHp() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + party.get(i).getClass().getSimpleName());
      party.get(i).setCurrentHp(5);
      System.out.println("CurrentHp was set at 5");
      System.out.println("Current Hp is: " + party.get(i).getCurrentHp());
    }
    System.out.println("-------------");
  
  
    System.out.println("(7) Testing getDefense() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + party.get(i).getClass().getSimpleName());
      System.out.println("Defense is: " + party.get(i).getDefense());
    }
    System.out.println("-------------");
  
  
    System.out.println("(8) Testing equip() for every character");
  
  
  
  
    System.out.println("-------------");

    System.out.println("(3) Testing waitTurn() for every character");
    for (int i = 0; i < 6; i++) {
      System.out.println(i + ". Testing for " + party.get(i).getClass().getSimpleName());
      
    }
  }
}
