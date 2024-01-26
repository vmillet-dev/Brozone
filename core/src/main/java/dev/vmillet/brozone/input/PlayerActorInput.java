package dev.vmillet.brozone.input;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.control.ActorControl;

public class PlayerActorInput implements ActorInput {
    private final ActorControl uiControl;

    public PlayerActorInput(ActorControl uiControl) {
        this.uiControl = uiControl;
    }

    @Override
    public void update(Brozone game) {

    }

    @Override
    public boolean isJumping() {
        return uiControl.isJumping();
    }

    @Override
    public boolean isCrouching() {
        return uiControl.isCrouching();
    }

    @Override
    public boolean isMovingLeft() {
        return uiControl.isMovingLeft();
    }

    @Override
    public boolean isMovingRight() {
        return uiControl.isMovingRight();
    }

    @Override
    public boolean isShooting() {
        return uiControl.isShooting();
    }

    @Override
    public boolean isPlayer() {
        return uiControl.isPlayer();
    }
}
