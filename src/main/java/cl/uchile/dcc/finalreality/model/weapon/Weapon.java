package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;

/**
 * This represents the behaviour of a weapon to be equipped by a playable
 * character.
 *
 * @author Katia
 */
public interface Weapon {
  
  /**
   * Returns this weapon's name.
   */
  public String getName();
  
  /**
   * Returns this weapon's damage.
   */
  public int getDamage();
  
  /**
   * Returns this weapon's weight.
   */
  public int getWeight();
  
  /**
   * Equips weapon to Knight.
   */
  public void equipToKnight(Knight knight);
  
  /**
   * Equips weapon to Engineer.
   */
  public void equipToEngineer(Engineer engineer);
  
  /**
   * Equips weapon to Thief.
   */
  public void equipToThief(Thief thief);
  
  /**
   * Equips weapon to Black Mage.
   */
  public void equipToBlackMage(BlackMage blackMage);
  
  /**
   * Equips weapon to White Mage.
   */
  public void equipToWhiteMage(WhiteMage whiteMage);
  
}
