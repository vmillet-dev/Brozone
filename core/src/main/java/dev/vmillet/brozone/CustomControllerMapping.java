package dev.vmillet.brozone;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerMapping;
import dev.vmillet.brozone.input.mapping.controller.ConfiguredInput;
import dev.vmillet.brozone.input.mapping.controller.ControllerMappings;

import static dev.vmillet.brozone.GameOptions.AXIS_VERTICAL;
import static dev.vmillet.brozone.GameOptions.AXIS_HORIZONTAL;
import static dev.vmillet.brozone.GameOptions.BUTTON_CANCEL;
import static dev.vmillet.brozone.GameOptions.BUTTON_CROUCH;
import static dev.vmillet.brozone.GameOptions.BUTTON_JUMP;
import static dev.vmillet.brozone.GameOptions.BUTTON_SHOOT;
import static dev.vmillet.brozone.GameOptions.BUTTON_START;

public class CustomControllerMapping extends ControllerMappings {

    public CustomControllerMapping() {
        super();

        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, BUTTON_JUMP));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, BUTTON_CROUCH));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, BUTTON_SHOOT));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, BUTTON_START));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, BUTTON_CANCEL));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.axisAnalog, AXIS_HORIZONTAL));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.axisAnalog, AXIS_VERTICAL));

        commitConfig();
    }

    @Override
    public boolean getDefaultMapping(MappedInputs defaultMapping, Controller controller) {
        ControllerMapping controllerMapping = controller.getMapping();

        defaultMapping.putMapping(new MappedInput(AXIS_HORIZONTAL, new ControllerAxis(controllerMapping.axisLeftX)));
        defaultMapping.putMapping(new MappedInput(AXIS_VERTICAL, new ControllerAxis(controllerMapping.axisLeftY)));
        defaultMapping.putMapping(new MappedInput(BUTTON_SHOOT, new ControllerButton(controllerMapping.buttonR1)));
        defaultMapping.putMapping(new MappedInput(BUTTON_JUMP, new ControllerButton(controllerMapping.buttonA)));
        defaultMapping.putMapping(new MappedInput(BUTTON_CROUCH, new ControllerButton(controllerMapping.buttonB)));
        defaultMapping.putMapping(new MappedInput(BUTTON_START, new ControllerButton(controllerMapping.buttonStart)));
        defaultMapping.putMapping(new MappedInput(BUTTON_CANCEL, new ControllerButton(controllerMapping.buttonBack)));

        return true;
    }
}
