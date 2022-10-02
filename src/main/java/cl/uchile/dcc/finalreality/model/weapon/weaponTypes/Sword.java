package cl.uchile.dcc.finalreality.model.weapon.weaponTypes;

import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;

import java.util.Objects;

public class Sword extends Weapon {
    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     *
     * @param name
     * @param damage
     * @param weight
     */
    public Sword(String name, int damage, int weight) {
        super(name, damage, weight);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Weapon weapon)) {
            return false;
        }
        return hashCode() == weapon.hashCode()
                && damage == this.damage
                && weight == this.weight
                && name.equals(this.name);
//        && type == weapon.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Weapon.class, name, damage, weight);
    }

    @Override
    public String toString() {
        return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
                .formatted(name, damage, weight);
    }
}
