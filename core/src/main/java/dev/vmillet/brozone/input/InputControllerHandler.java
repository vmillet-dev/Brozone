package dev.vmillet.brozone.input;

import com.badlogic.gdx.controllers.Controller;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.mapping.controller.ControllerMappings;
import dev.vmillet.brozone.input.mapping.controller.MappedControllerAdapter;
import dev.vmillet.brozone.managers.InputManager;

public class InputControllerHandler extends MappedControllerAdapter {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(InputControllerHandler.class);

    private final InputManager inputManager;

    public InputControllerHandler(ControllerMappings mappings, InputManager inputManager) {
        super(mappings);
        this.inputManager = inputManager;
    }

    @Override
    public boolean configuredButtonDown(Controller controller, int buttonId) {
        logger.debug("button pressed: " + buttonId);
        inputManager.buttonControllerPressed(buttonId);
        return false;
    }

    @Override
    public boolean configuredButtonUp(Controller controller, int buttonId) {
        logger.debug("button released: " + buttonId);
        inputManager.buttonControllerReleased(buttonId);
        return false;
    }

    @Override
    public boolean configuredAxisMoved(Controller controller, int axisId, float value) {
        logger.debug("axis id: " + axisId);
        inputManager.axisMoved(axisId, value);
        return false;
    }

}
