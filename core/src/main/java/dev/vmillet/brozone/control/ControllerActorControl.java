package dev.vmillet.brozone.control;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.handler.InputControllerHandler;
import dev.vmillet.brozone.ui.UiControl;

import java.util.ArrayList;
import java.util.List;

public class ControllerActorControl implements ActorControl {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(ControllerActorControl.class);

    UiControl leftControl;
    UiControl rightControl;
    UiControl jumpControl;
    UiControl crouchControl;
    UiControl shootControl;
    Controller controller;


    public ControllerActorControl(Brozone application) {
        logger.debug("create controller control");

        GameOptions options = application.getOptions();
        InputControllerHandler inputControllerHandler =
                new InputControllerHandler(
                        options.getCustomControllerMapping(),
                        application.getInputManager()
                );

        controller = Controllers.getCurrent();
        controller.addListener(inputControllerHandler);

        leftControl = new UiControl(GameOptions.AXIS_HORIZONTAL, true);
        rightControl = new UiControl(GameOptions.AXIS_HORIZONTAL, false);
        jumpControl = new UiControl(GameOptions.ACTION_JUMP);
        crouchControl = new UiControl(GameOptions.ACTION_CROUCH);
        shootControl = new UiControl(GameOptions.ACTION_PAUSE_GAME);

        List<UiControl> controls = new ArrayList<>();
        controls.add(leftControl);
        controls.add(rightControl);
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
        return leftControl.isOn();
    }

    @Override
    public boolean isMovingRight() {
        return rightControl.isOn() ;
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
