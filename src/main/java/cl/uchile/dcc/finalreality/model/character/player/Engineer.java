/*
 * "Final Reality" (c) by R8V and Katia
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
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
 * A {@link PlayerCharacter} that can equip {@code Axe}s and {@code Bow}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Katia
 */
public class Engineer extends AbstractPlayerCharacter {


  /**
   * Creates a new engineer.
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
  public Engineer(final @NotNull String name, final int maxHp, final int defense,
      final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public String toString() {
    return "Engineer{maxHp=%d, defense=%d, name='%s'}".formatted(maxHp, defense, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Engineer.class, name, maxHp, defense);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Engineer that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }
  
  @Override
  public void equip(Weapon weapon) {
    weapon.equipToEngineer(this);
  }
  
  @Override
  public void equipAxe(Axe axe) {
    this.equippedWeapon = axe;
  }
  
  @Override
  public void equipBow(Bow bow) {
    this.equippedWeapon = bow;
  }
  
  @Override
  public void equipKnife(Knife knife) {
  
  }
  
  @Override
  public void equipStaff(Staff staff) {
  
  }
  
  @Override
  public void equipSword(Sword sword) {
  
  }
}
