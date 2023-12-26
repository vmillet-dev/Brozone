package dev.vmillet.brozone.controls;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.game.Hero;
import dev.vmillet.brozone.managers.GameManager;
import dev.vmillet.brozone.ui.UiControl;

import java.util.List;

public class KeyboardControl implements HeroControl {

    public final UiControl leftControl;
    public final UiControl rightControl;
    public final UiControl upControl;
    public final UiControl downControl;
    public final UiControl shootControl;

    public KeyboardControl(Brozone application, List<UiControl> controls) {
        GameOptions gameOptions = application.getOptions();

        leftControl = new UiControl(gameOptions.getKeyLeft());
        rightControl = new UiControl(gameOptions.getKeyRight());
        upControl = new UiControl(gameOptions.getKeyUp());
        downControl = new UiControl(gameOptions.getKeyDown());
        shootControl = new UiControl(gameOptions.getKeyShoot());

        controls.add(leftControl);
        controls.add(rightControl);
        controls.add(upControl);
        controls.add(downControl);
        controls.add(shootControl);
    }

    @Override
    public void update(Brozone application, boolean enabled) {
        GameManager game = application.getGameManager();
        Hero hero = game.getHero();

        boolean showButtons = application.isMobile();
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
