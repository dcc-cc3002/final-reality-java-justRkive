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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    /**
     * Main method to run the code.
     * @param args
     * @throws InvalidStatValueException
     */

    public static void main(String[] args) throws InvalidStatValueException {
        /**
         * We instantiatiate all the characters
         */
        BlockingQueue<GameCharacter> mainQueue = new LinkedBlockingQueue<>();
        Random rng = new Random();
        List<GameCharacter> party = new ArrayList<GameCharacter>();
        PlayerCharacter engineer = new Engineer("Engineer", 10, 5, mainQueue);
        party.add(engineer);
        PlayerCharacter blackMage = new BlackMage("BlackMage", 11, 6, 20, mainQueue);
        party.add(blackMage);
        PlayerCharacter knight = new Knight("Knight", 11, 15, mainQueue);
        party.add(knight);
        PlayerCharacter thief = new Thief("Thief", 10, 7, mainQueue);
        party.add(thief);
        PlayerCharacter whiteMage = new WhiteMage("WhiteMage", 6, 11, 19, mainQueue);
        party.add(whiteMage);
        GameCharacter enemy = new Enemy("Bad person", 100, 15, 5, mainQueue);
        party.add(enemy);

        /**
         * toString and equals
         */
        System.out.println("Demostrating toString");
        for (int i = 0; i < 6; i++) {
            System.out.println(party.get(i).toString());
        }
        System.out.println("----");
        System.out.println("Demostrating equals");
        for (int i = 0; i < 5; i++) {
            System.out.println(party.get(i).equals(party.get(i)));
            System.out.println(party.get(i).equals(party.get(i+1)));
        }




    }
}
