package dev.vmillet.brozone.controls;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.Actor;
import dev.vmillet.brozone.managers.GameManager;
import dev.vmillet.brozone.ui.UiControl;

import java.util.List;

public class KeyboardActorControl implements ActorControl {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(KeyboardActorControl.class);

    public final UiControl leftControl;
    public final UiControl rightControl;
    public final UiControl upControl;
    public final UiControl downControl;
    public final UiControl shootControl;

    public KeyboardActorControl(Brozone application, List<UiControl> controls) {
        logger.debug("create keyboard control");

        GameOptions gameOptions = application.getOptions();

        leftControl = new UiControl(null, false, gameOptions.getKeyLeft());
        rightControl = new UiControl(null, false, gameOptions.getKeyRight());
        upControl = new UiControl(null, false, gameOptions.getKeyUp());
        downControl = new UiControl(null, false, gameOptions.getKeyDown());
        shootControl = new UiControl(null, false, gameOptions.getKeyShoot());

        controls.add(leftControl);
        controls.add(rightControl);
        controls.add(upControl);
        controls.add(downControl);
        controls.add(shootControl);
    }

    @Override
    public void update(Brozone application, boolean enabled) {
        GameManager game = application.getGameManager();
        Actor actor = game.getHero();

        boolean showButtons = application.isMobile();
    }

    @Override
    public boolean isLeft() {
        return leftControl.isOn();
    }

    @Override
    public boolean isRight() {
        return rightControl.isOn();
    }

    @Override
    public boolean isUp() {
        return upControl.isOn();
    }

    @Override
    public boolean isDown() {
        return downControl.isOn();
    }

    @Override
    public boolean isShoot() {
        return shootControl.isOn();
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
