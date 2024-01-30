package dev.vmillet.brozone;

import dev.vmillet.brozone.input.mapping.config.CustomControllerMapping;
import dev.vmillet.brozone.input.mapping.config.CustomKeyboardMapping;

/**
 * Centralize all config needed by the app such as key binding, display settings, audio settings
 * and everything that could be modified by the user. Must be de/serialized from/in a file
 */
public class GameOptions {

    public enum ControlType {
        KEYBOARD("Keyboard"),
        CONTROLLER("Controller");

        private final String humanName;

        ControlType(String humanName) {
            this.humanName = humanName;
        }

        public String getHumanName() {
            return this.humanName;
        }
    }

    public ControlType controlType = ControlType.KEYBOARD;

    CustomControllerMapping customControllerMapping;
    CustomKeyboardMapping customKeyboardMapping;

    // Commons
    public static final int ACTION_JUMP = 0;
    public static final int ACTION_CROUCH = 1;
    public static final int ACTION_SHOOT = 2;
    public static final int ACTION_RELOAD = 3;
    public static final int ACTION_SWITCH_EQUIPMENT = 3;
    public static final int ACTION_PAUSE_GAME = 4;

    // Keyboard
    public static final int ACTION_MOVE_LEFT = 10;
    public static final int ACTION_MOVE_RIGHT = 11;
    public static final int ACTION_MOVE_UP = 12;
    public static final int ACTION_MOVE_DOWN = 13;

    // Controller
    public static final int AXIS_HORIZONTAL = 20;
    public static final int AXIS_VERTICAL = 21;

    public GameOptions() {
        customControllerMapping = new CustomControllerMapping();
        customKeyboardMapping = new CustomKeyboardMapping();
    }
    public void load() {
        // to implement
    }

    public void save() {
        // to implement
    }

    public CustomControllerMapping getCustomControllerMapping() {
        return customControllerMapping;
    }

    public CustomKeyboardMapping getCustomKeyboardMapping() {
        return customKeyboardMapping;
    }
}
