package dev.vmillet.brozone.input.mapping.config;

import com.badlogic.gdx.Input;
import dev.vmillet.brozone.input.mapping.ConfiguredInput;
import dev.vmillet.brozone.input.mapping.ControllerMappings;

import static dev.vmillet.brozone.GameOptions.ACTION_CROUCH;
import static dev.vmillet.brozone.GameOptions.ACTION_JUMP;
import static dev.vmillet.brozone.GameOptions.ACTION_MOVE_DOWN;
import static dev.vmillet.brozone.GameOptions.ACTION_MOVE_LEFT;
import static dev.vmillet.brozone.GameOptions.ACTION_MOVE_RIGHT;
import static dev.vmillet.brozone.GameOptions.ACTION_MOVE_UP;
import static dev.vmillet.brozone.GameOptions.ACTION_RELOAD;
import static dev.vmillet.brozone.GameOptions.ACTION_SHOOT;
import static dev.vmillet.brozone.GameOptions.ACTION_SWITCH_EQUIPMENT;

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

        commitConfig();
    }

    @Override
    public boolean getDefaultMapping(MappedInputs defaultMapping) {

        defaultMapping.putMapping(new MappedInput(ACTION_MOVE_LEFT, new ControllerKey(Input.Keys.A)));
        defaultMapping.putMapping(new MappedInput(ACTION_MOVE_RIGHT, new ControllerKey(Input.Keys.D)));
        defaultMapping.putMapping(new MappedInput(ACTION_MOVE_DOWN, new ControllerKey(Input.Keys.S)));
        defaultMapping.putMapping(new MappedInput(ACTION_MOVE_UP, new ControllerKey(Input.Keys.W)));
        defaultMapping.putMapping(new MappedInput(ACTION_JUMP, new ControllerKey(Input.Keys.SPACE)));
        defaultMapping.putMapping(new MappedInput(ACTION_CROUCH, new ControllerKey(Input.Keys.CONTROL_LEFT)));
        defaultMapping.putMapping(new MappedInput(ACTION_SHOOT, new ControllerKey(Input.Keys.ENTER)));
        defaultMapping.putMapping(new MappedInput(ACTION_RELOAD, new ControllerKey(Input.Keys.R)));
        defaultMapping.putMapping(new MappedInput(ACTION_SWITCH_EQUIPMENT, new ControllerKey(Input.Keys.TAB)));

        return true;
    }
}
