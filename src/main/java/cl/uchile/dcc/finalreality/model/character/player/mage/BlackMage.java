/*
 * "Final Reality" (c) by R8V and Katia
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Axe;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Bow;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Knife;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Staff;
import cl.uchile.dcc.finalreality.model.weapon.weapontypes.Sword;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Katia
 * @version 2.0
 */
public class BlackMage extends AbstractMage {
  
  /**
   * Creates a new Black Mage.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }
  

  // region : UTILITY METHODS
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense
        && maxMp == that.maxMp;
  }

  @Override
  public String toString() {
    return "BlackMage{maxHp=%d, defense=%d, maxMp=%d, name='%s'}"
        .formatted(maxHp, defense, maxMp, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, name, maxHp, defense, maxMp);
  }
  
  @Override
  public void equip(Weapon weapon) {
    weapon.equipToBlackMage(this);
  }
  
  @Override
  public void equipAxe(Axe axe) {
  
  }
  
  @Override
  public void equipBow(Bow bow) {
  
  }
  
  @Override
  public void equipKnife(Knife knife) {
    this.equippedWeapon = knife;
  }
  
  @Override
  public void equipStaff(Staff staff) {
    this.equippedWeapon = staff;
  }
  
  @Override
  public void equipSword(Sword sword) {
  
  }
  // endregion
}
