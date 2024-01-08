package dev.vmillet.brozone.input.actor;

import dev.vmillet.brozone.Brozone;

/**
 * This interface implemented by input classed allow the possibility to
 * make a difference between a npc character and the player character while they
 * have the same mechanisms
 */
public interface ActorInput {
    void update(Brozone game);

    boolean isUp();

    boolean isDown();

    boolean isLeft();

    boolean isRight();

    boolean isShoot();

    boolean isPlayer();
}
