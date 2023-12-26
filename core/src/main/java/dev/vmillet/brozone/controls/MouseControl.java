package dev.vmillet.brozone.controls;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.game.Hero;
import dev.vmillet.brozone.managers.GameManager;

public class MouseControl implements HeroControl {

    public MouseControl(Brozone application) {

    }

    @Override
    public void update(Brozone application, boolean enabled) {
        GameManager game = application.getGameManager();
        Hero hero = game.getHero();
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
    public boolean isUp() {
        return false;
    }

    @Override
    public boolean isDown() {
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
