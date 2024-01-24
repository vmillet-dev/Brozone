package dev.vmillet.brozone;


import com.badlogic.gdx.Input;

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

        public ControlType controlType = ControlType.CONTROLLER;

    CustomControllerMapping customControllerMapping;

    // MVP handle AZERTY / QWERTY keyboard
    // MVP remove this hardcoded init
    private String keyLeftName = "Q";
    private String keyRightName = "D";
    private String keyJumpName = "Z";
    private String keyCrouchName = "S";
    private String keyShootName = "Space";

    public static final int BUTTON_JUMP = 0;
    public static final int BUTTON_CROUCH = 1;
    public static final int BUTTON_SHOOT = 2;
    public static final int AXIS_HORIZONTAL = 3;
    public static final int AXIS_VERTICAL = 4;
    public static final int BUTTON_START = 5;
    public static final int BUTTON_CANCEL = 6;

    public GameOptions() {
        customControllerMapping = new CustomControllerMapping();
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


    public int getKeyLeft() {
        return Input.Keys.valueOf(keyLeftName);
    }

    public int getKeyRight() {
        return Input.Keys.valueOf(keyRightName);
    }

    public int getKeyUp() {
        return Input.Keys.valueOf(keyJumpName);
    }

    public int getKeyDown() {
        return Input.Keys.valueOf(keyCrouchName);
    }

    public int getKeyShoot() {
        return Input.Keys.valueOf(keyShootName);
    }

    public void setKeyLeftName(String keyLeftName) {
        this.keyLeftName = keyLeftName;
    }

    public void setKeyRightName(String keyRightName) {
        this.keyRightName = keyRightName;
    }

    public void setKeyJumpName(String keyJumpName) {
        this.keyJumpName = keyJumpName;
    }

    public void setKeyCrouchName(String keyCrouchName) {
        this.keyCrouchName = keyCrouchName;
    }

    public void setKeyShootName(String keyShootName) {
        this.keyShootName = keyShootName;
    }
}
