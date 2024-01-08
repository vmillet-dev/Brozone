package dev.vmillet.brozone.input.actor;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.controls.ActorControl;

public class PlayerActorInput implements ActorInput {
    private final ActorControl uiControl;

    public PlayerActorInput(ActorControl uiControl) {
        this.uiControl = uiControl;
    }

    @Override
    public void update(Brozone game) {

    }

    @Override
    public boolean isUp() {
        return uiControl.isUp();
    }

    @Override
    public boolean isDown() {
        return uiControl.isDown();
    }

    @Override
    public boolean isLeft() {
        return uiControl.isLeft();
    }

    @Override
    public boolean isRight() {
        return uiControl.isRight();
    }

    @Override
    public boolean isShoot() {
        return uiControl.isShoot();
    }

    @Override
    public boolean isPlayer() {
        return uiControl.isPlayer();
    }
}
