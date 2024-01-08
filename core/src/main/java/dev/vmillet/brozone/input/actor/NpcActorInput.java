package dev.vmillet.brozone.input.actor;

import dev.vmillet.brozone.Brozone;

public class NpcActorInput implements ActorInput {


    @Override
    public void update(Brozone game) {

    }

    @Override
    public boolean isUp() {
        return false;
    }

    @Override
    public boolean isDown() {
        return false;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public boolean isShoot() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
