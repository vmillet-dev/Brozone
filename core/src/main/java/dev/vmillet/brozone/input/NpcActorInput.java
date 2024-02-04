package dev.vmillet.brozone.input;

import dev.vmillet.brozone.Brozone;

public class NpcActorInput implements ActorInput {


    @Override
    public void update(Brozone game) {

    }

    @Override
    public boolean isJumping() {
        return false;
    }

    @Override
    public boolean isCrouching() {
        return false;
    }

    @Override
    public boolean isMovingLeft() {
        return false;
    }

    @Override
    public boolean isMovingRight() {
        return false;
    }

    @Override
    public boolean isShooting() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
