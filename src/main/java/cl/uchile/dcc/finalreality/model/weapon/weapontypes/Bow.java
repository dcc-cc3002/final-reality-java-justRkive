package cl.uchile.dcc.finalreality.model.weapon.weapontypes;

import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;
import java.util.Objects;

/**
 * A weapon of bow type that can be equipped by certain {@code PlayerCharacter}s.
 *
 * @author Katia
 */
public class Bow extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   *
   * @param name   The weapon's name.
   * @param damage The weapon's damage.
   * @param weight The weapon's weight.
   */
  public Bow(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Bow weapon)) {
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
    return "Bow{name='%s', damage=%d, weight=%d}"
          .formatted(name, damage, weight);
  }
  
  @Override
  public void equipToKnight(Knight knight) {
  }
  
  @Override
  public void equipToEngineer(Engineer engineer) {
    engineer.equipBow(this);
  }
  
  @Override
  public void equipToThief(Thief thief) {
    thief.equipBow(this);
  }
  
  @Override
  public void equipToBlackMage(BlackMage blackMage) {
  
  }
  
  @Override
  public void equipToWhiteMage(WhiteMage whiteMage) {
  
  }
}
