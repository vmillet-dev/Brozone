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

    public final UiControl moveLeftControl;
    public final UiControl moveRightControl;
    public final UiControl jumpControl;
    public final UiControl crouchControl;
    public final UiControl shootControl;

    public KeyboardActorControl(Brozone application, List<UiControl> controls) {
        logger.debug("create keyboard control");

        GameOptions gameOptions = application.getOptions();

        moveLeftControl = new UiControl(null, false, gameOptions.getKeyLeft());
        moveRightControl = new UiControl(null, false, gameOptions.getKeyRight());
        jumpControl = new UiControl(null, false, gameOptions.getKeyUp());
        crouchControl = new UiControl(null, false, gameOptions.getKeyDown());
        shootControl = new UiControl(null, false, gameOptions.getKeyShoot());

        controls.add(moveLeftControl);
        controls.add(moveRightControl);
        controls.add(jumpControl);
        controls.add(crouchControl);
        controls.add(shootControl);
    }

    @Override
    public void update(Brozone application, boolean enabled) {
        // to implement
    }

    @Override
    public boolean isMovingLeft() {
        return moveLeftControl.isOn();
    }

    @Override
    public boolean isMovingRight() {
        return moveRightControl.isOn();
    }

    @Override
    public boolean isJumping() {
        return jumpControl.isOn();
    }

    @Override
    public boolean isCrouching() {
        return crouchControl.isOn();
    }

    @Override
    public boolean isShooting() {
        return shootControl.isOn();
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
