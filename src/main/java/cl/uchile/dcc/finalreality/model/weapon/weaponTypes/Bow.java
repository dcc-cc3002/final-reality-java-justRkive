package cl.uchile.dcc.finalreality.model.weapon.weaponTypes;

import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;

public class Bow extends Weapon {
    /**
     * Creates a weapon with a name, a base damage, speed, and it's type.
     *
     * @param name
     * @param damage
     * @param weight
     * @param type
     */
    public Bow(String name, int damage, int weight, WeaponType type) {
        super(name, damage, weight, type);
    }
}
