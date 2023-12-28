package dev.vmillet.brozone.controls;

import dev.vmillet.brozone.Brozone;

/**
 * Define all methods that could be triggered by user input. Classes must implement this
 * interface in order to handle multi input devices such as controller or keyboard
 */
public interface HeroControl {
    default void update(Brozone solApplication, boolean enabled) {
        // Intentionally left blank
    }

    boolean isLeft();

    boolean isRight();

    boolean isUp();

    boolean isDown();

    boolean isShoot();

    boolean isPlayer();
}
