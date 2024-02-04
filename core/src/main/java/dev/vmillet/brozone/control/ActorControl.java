package dev.vmillet.brozone.control;

import dev.vmillet.brozone.Brozone;

/**
 * Define all methods that could be triggered by user input. Classes must implement this
 * interface in order to handle multi input devices such as controller or keyboard
 */
public interface ActorControl {
    default void update(Brozone solApplication, boolean enabled) {
        // Intentionally left blank
    }

    boolean isMovingLeft();

    boolean isMovingRight();

    boolean isJumping();

    boolean isCrouching();

    boolean isShooting();

    boolean isPlayer();
}
