package dev.vmillet.brozone.controls;

import dev.vmillet.brozone.Brozone;

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
