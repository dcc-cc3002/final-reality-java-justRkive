package cl.uchile.dcc.finalreality.model.weapon.weapontypes;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;
import java.util.Objects;

/**
 * A weapon of axe type that can be equipped by certain {@code PlayerCharacter}s.
 *
 * @author Katia
 */
public class Axe extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name   The weapon's name.
   * @param damage The weapon's damage.
   * @param weight The weapon's weight.
   */
  public Axe(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final AbstractWeapon weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
          && damage == this.damage
          && weight == this.weight
          && name.equals(this.name);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(AbstractWeapon.class, name, damage, weight);
  }
  
  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
          .formatted(name, damage, weight);
  }
}
