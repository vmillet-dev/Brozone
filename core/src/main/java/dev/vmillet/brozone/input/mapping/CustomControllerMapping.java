package dev.vmillet.brozone.input.mapping;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerMapping;
import dev.vmillet.brozone.input.mapping.controller.ConfiguredInput;
import dev.vmillet.brozone.input.mapping.controller.ControllerMappings;

import static dev.vmillet.brozone.GameOptions.ACTION_PAUSE_GAME;
import static dev.vmillet.brozone.GameOptions.ACTION_RELOAD;
import static dev.vmillet.brozone.GameOptions.ACTION_SHOOT;
import static dev.vmillet.brozone.GameOptions.ACTION_SWITCH_EQUIPMENT;
import static dev.vmillet.brozone.GameOptions.AXIS_VERTICAL;
import static dev.vmillet.brozone.GameOptions.AXIS_HORIZONTAL;
import static dev.vmillet.brozone.GameOptions.ACTION_CROUCH;
import static dev.vmillet.brozone.GameOptions.ACTION_JUMP;


public class CustomControllerMapping extends ControllerMappings {


    public CustomControllerMapping() {
        super();

        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, ACTION_JUMP));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, ACTION_CROUCH));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, ACTION_SHOOT));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, ACTION_RELOAD));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, ACTION_SWITCH_EQUIPMENT));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.button, ACTION_PAUSE_GAME));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.axisAnalog, AXIS_HORIZONTAL));


        commitConfig();
    }

    @Override
    public boolean getDefaultMapping(MappedInputs defaultMapping, Controller controller) {
        ControllerMapping controllerMapping = controller.getMapping();

        defaultMapping.putMapping(new MappedInput(AXIS_HORIZONTAL, new ControllerAxis(controllerMapping.axisLeftX)));
        defaultMapping.putMapping(new MappedInput(AXIS_VERTICAL, new ControllerAxis(controllerMapping.axisLeftY)));
        defaultMapping.putMapping(new MappedInput(ACTION_SHOOT, new ControllerButton(controllerMapping.buttonR1)));
        defaultMapping.putMapping(new MappedInput(ACTION_JUMP, new ControllerButton(controllerMapping.buttonA)));
        defaultMapping.putMapping(new MappedInput(ACTION_CROUCH, new ControllerButton(controllerMapping.buttonB)));
        defaultMapping.putMapping(new MappedInput(ACTION_RELOAD, new ControllerButton(controllerMapping.buttonX)));
        defaultMapping.putMapping(new MappedInput(ACTION_SWITCH_EQUIPMENT, new ControllerButton(controllerMapping.buttonY)));
        defaultMapping.putMapping(new MappedInput(ACTION_PAUSE_GAME, new ControllerButton(controllerMapping.buttonStart)));

        return true;
    }
}
