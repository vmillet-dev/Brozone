package dev.vmillet.brozone.input.mapping;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerMapping;
import dev.vmillet.brozone.input.mapping.controller.ConfiguredInput;
import dev.vmillet.brozone.input.mapping.controller.ControllerMappings;

import static dev.vmillet.brozone.GameOptions.ACTION_CROUCH;
import static dev.vmillet.brozone.GameOptions.ACTION_JUMP;
import static dev.vmillet.brozone.GameOptions.ACTION_MOVE_DOWN;
import static dev.vmillet.brozone.GameOptions.ACTION_MOVE_LEFT;
import static dev.vmillet.brozone.GameOptions.ACTION_MOVE_RIGHT;
import static dev.vmillet.brozone.GameOptions.ACTION_MOVE_UP;
import static dev.vmillet.brozone.GameOptions.ACTION_PAUSE_GAME;
import static dev.vmillet.brozone.GameOptions.ACTION_RELOAD;
import static dev.vmillet.brozone.GameOptions.ACTION_SHOOT;
import static dev.vmillet.brozone.GameOptions.ACTION_SWITCH_EQUIPMENT;
import static dev.vmillet.brozone.GameOptions.AXIS_HORIZONTAL;
import static dev.vmillet.brozone.GameOptions.AXIS_VERTICAL;

public class CustomKeyboardMapping extends ControllerMappings {
    public CustomKeyboardMapping() {
        super();

        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_MOVE_LEFT));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_MOVE_RIGHT));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_MOVE_DOWN));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_MOVE_UP));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_JUMP));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_CROUCH));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_SHOOT));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_RELOAD));
        addConfiguredInput(new ConfiguredInput(ConfiguredInput.Type.key, ACTION_SWITCH_EQUIPMENT));



        addConfiguredInput(new ConfiguredInput(ACTION_MOVE_LEFT, Input.Keys.A));
        addConfiguredInput(new ConfiguredInput(ACTION_MOVE_RIGHT, Input.Keys.D));
        addConfiguredInput(new ConfiguredInput(ACTION_MOVE_DOWN, Input.Keys.S));
        addConfiguredInput(new ConfiguredInput(ACTION_MOVE_UP, Input.Keys.W));
        addConfiguredInput(new ConfiguredInput(ACTION_JUMP, Input.Keys.SPACE));
        addConfiguredInput(new ConfiguredInput(ACTION_CROUCH, Input.Keys.ALT_LEFT));
        addConfiguredInput(new ConfiguredInput(ACTION_SHOOT, Input.Keys.ENTER));
        addConfiguredInput(new ConfiguredInput(ACTION_RELOAD, Input.Keys.R));
        addConfiguredInput(new ConfiguredInput(ACTION_SWITCH_EQUIPMENT, Input.Keys.TAB));

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
