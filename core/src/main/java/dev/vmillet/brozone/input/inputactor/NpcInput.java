package dev.vmillet.brozone.input.inputactor;

import dev.vmillet.brozone.Brozone;

public class NpcInput implements Input {


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
