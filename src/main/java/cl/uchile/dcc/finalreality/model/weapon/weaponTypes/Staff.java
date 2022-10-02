package cl.uchile.dcc.finalreality.model.weapon.weaponTypes;

import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;

import java.util.Objects;

public class Staff extends AbstractWeapon {
    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     *
     * @param name
     * @param damage
     * @param weight
     */
    public Staff(final String name, final int damage, final int weight) {
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
//        && type == weapon.type;
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


