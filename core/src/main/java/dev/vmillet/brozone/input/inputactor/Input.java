package dev.vmillet.brozone.input.inputactor;

import dev.vmillet.brozone.Brozone;

public interface Input {
    void update(Brozone game);

    boolean isUp();

    boolean isDown();

    boolean isLeft();

    boolean isRight();

    boolean isShoot();

    boolean isPlayer();
}
