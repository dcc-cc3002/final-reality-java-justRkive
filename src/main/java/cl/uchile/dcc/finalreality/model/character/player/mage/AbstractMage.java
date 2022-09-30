package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractMage extends AbstractPlayerCharacter {
    /**
     * Creates a new character.
     * This constructor is <b>protected</b>, because it'll only be used by subclasses.
     *
     * @param name       the character's name
     * @param maxHp      the character's max hp
     * @param defense    the character's defense
     * @param turnsQueue the queue with the characters waiting for their turn
     */
    protected AbstractMage(@NotNull String name, int maxHp, int defense,
                           @NotNull BlockingQueue<GameCharacter> turnsQueue)
            throws InvalidStatValueException {
        super(name, maxHp, defense, turnsQueue);
    }
}
