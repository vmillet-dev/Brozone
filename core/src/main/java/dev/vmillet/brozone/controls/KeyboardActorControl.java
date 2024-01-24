package dev.vmillet.brozone.controls;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.ui.UiControl;

import java.util.ArrayList;
import java.util.List;

public class KeyboardActorControl implements ActorControl {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(KeyboardActorControl.class);

    public final UiControl moveLeftControl;
    public final UiControl moveRightControl;
    public final UiControl jumpControl;
    public final UiControl crouchControl;
    public final UiControl shootControl;

    public KeyboardActorControl(Brozone application) {
        logger.debug("create keyboard control");

        GameOptions gameOptions = application.getOptions();

        moveLeftControl = new UiControl(gameOptions.getKeyLeft());
        moveRightControl = new UiControl(gameOptions.getKeyRight());
        jumpControl = new UiControl(gameOptions.getKeyUp());
        crouchControl = new UiControl(gameOptions.getKeyDown());
        shootControl = new UiControl(gameOptions.getKeyShoot());

        List<UiControl> controls = new ArrayList<>();
        controls.add(moveLeftControl);
        controls.add(moveRightControl);
        controls.add(jumpControl);
        controls.add(crouchControl);
        controls.add(shootControl);
        application.getInputManager().addControls(controls);
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
