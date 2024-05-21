package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and Katia
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Axe;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Bow;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Knife;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Staff;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Sword;

/**
 * A {@link GameCharacter} that can equip a weapon.
 */
public interface PlayerCharacter extends GameCharacter {
  /**
   * Equips a weapon to the character.
   */
  void equip(Weapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();
  
  /**
   * Equips an axe weapon to the character.
   */
  public void equipAxe(Axe axe);
  
  /**
   * Equips a bow weapon to the character.
   */
  public void equipBow(Bow bow);
  
  /**
   * Equips a knife weapon to the character.
   */
  public void equipKnife(Knife knife);
  
  /**
   * Equips a staff weapon to the character.
   */
  public void equipStaff(Staff staff);
  
  /**
   * Equips a sword weapon to the character.
   */
  public void equipSword(Sword sword);
  
}
