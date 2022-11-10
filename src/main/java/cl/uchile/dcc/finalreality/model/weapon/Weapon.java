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
  public String getName();
  
  public int getDamage();
  
  public int getWeight();
  
  public void equipToKnight(Knight knight);
  
  public void equipToEngineer(Engineer engineer);
  
  public void equipToThief(Thief thief);
  
  public void equipToBlackMage(BlackMage blackMage);
  
  public void equipToWhiteMage(WhiteMage whiteMage);
  
}
