package dev.vmillet.brozone.input.inputactor;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.controls.HeroControl;

public class PlayerInput implements Input {
    private final HeroControl uiControl;

    public PlayerInput(HeroControl uiControl) {
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
