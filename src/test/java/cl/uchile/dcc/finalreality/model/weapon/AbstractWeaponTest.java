package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.weapon.weapontypes.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractWeaponTest {
  List<Weapon> weapons = new ArrayList<Weapon>();
  String[] names = {"Hacha fea", "Arco", "Cuchillo", "Varita mágica", "Espadita"};
  int[] damages = {13, 9, 7, 10, 15};
  int[] weights = {300, 105, 30, 37, 250};
  
  
  @BeforeEach
  void setUp() {
    Axe axe0 = new Axe(names[0], damages[0], weights[0]);
    weapons.add(axe0);
    Bow bow0 = new Bow(names[1], damages[1], weights[1]);
    weapons.add(bow0);
    Knife knife0 = new Knife(names[2], damages[2], weights[2]);
    weapons.add(knife0);
    Staff staff0 = new Staff(names[3], damages[3], weights[3]);
    weapons.add(staff0);
    Sword sword0 = new Sword(names[4], damages[4], weights[4]);
    weapons.add(sword0);
  }
  
  @Test
  void getNameTest() {
    String[] expectNames = {"Hacha fea", "Arco", "Cuchillo", "Varita mágica", "Espadita"};
    for (int i = 0; i < 5; i++) {
      assertEquals(expectNames[i], weapons.get(i).getName());
    }
  }
  
  @Test
  void getDamageTest() {
    int[] expectDamages = {13, 9, 7, 10, 15};
    for (int i = 0; i < 5; i++) {
      assertEquals(expectDamages[i], weapons.get(i).getDamage());
    }
  }
  
  @Test
  void getWeightTest() {
    int[] expectWeights = {300, 105, 30, 37, 250};
    for (int i = 0; i < 5; i++) {
      assertEquals(expectWeights[i], weapons.get(i).getWeight());
    }
  
  }
}