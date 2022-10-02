package cl.uchile.dcc.finalreality.model.weapon;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Katia
 */
public abstract class AbstractWeapon {

  protected final String name;
  protected final int damage;
  protected final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  private int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }


}
