package cl.uchile.dcc.finalreality.model.weapon;

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
  
}
