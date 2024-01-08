package dev.vmillet.brozone.controls;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.Actor;
import dev.vmillet.brozone.input.InputControllerHandler;
import dev.vmillet.brozone.managers.GameManager;
import dev.vmillet.brozone.ui.UiControllerControl;

import java.util.List;

public class ControllerActorControl implements ActorControl {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(ControllerActorControl.class);

    UiControllerControl leftControl;
    UiControllerControl rightControl;
    UiControllerControl upControl;
    UiControllerControl downControl;
    UiControllerControl shootControl;
    Controller controller;


    public ControllerActorControl(Brozone application, List<UiControllerControl> controls) {
        logger.debug("create controller control");

        GameOptions options = application.getOptions();
        InputControllerHandler inputControllerHandler =
                new InputControllerHandler(
                        options.getCustomControllerMapping(),
                        application.getInputManager()
                );

        controller = Controllers.getCurrent();
        controller.addListener(inputControllerHandler);

        leftControl = new UiControllerControl(controller, GameOptions.BUTTON_FIRE);
        rightControl = new UiControllerControl(controller, GameOptions.BUTTON_FIRE);
        upControl = new UiControllerControl(controller, GameOptions.BUTTON_FIRE);
        downControl = new UiControllerControl(controller, GameOptions.BUTTON_FIRE);
        shootControl = new UiControllerControl(controller, GameOptions.BUTTON_FIRE);

        controls.add(leftControl);
        controls.add(rightControl);
        controls.add(upControl);
        controls.add(downControl);
        controls.add(shootControl);
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
        return upControl.isOn();
    }

    @Override
    public boolean isCrouching() {
        return downControl.isOn();
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
