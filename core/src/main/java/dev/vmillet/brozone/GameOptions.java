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

        private String humanName; // String used in the options menu.

        ControlType(String humanName) {
            this.humanName = humanName;
        }

        public String getHumanName() {
            return this.humanName;
        }
    }

    public ControlType controlType = ControlType.KEYBOARD;

    // TODO handle AZERTY / QWERTY keyboard
    // TODO remove this hardcoded init
    private String keyLeftName = "Q";
    private String keyRightName = "D";
    private String keyUpName = "Z";
    private String keyDownName = "S";
    private String keyShootName = "Space";

    public GameOptions() {}
    public void load() {
        // TODO load config saved by the user, maybe serialized ?
    }

    public void save() {
        // TODO save config, maybe serialized ?
    }


    public int getKeyLeft() {
        return Input.Keys.valueOf(keyLeftName);
    }

    public int getKeyRight() {
        return Input.Keys.valueOf(keyRightName);
    }

    public int getKeyUp() {
        return Input.Keys.valueOf(keyUpName);
    }

    public int getKeyDown() {
        return Input.Keys.valueOf(keyDownName);
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

    public void setKeyUpName(String keyUpName) {
        this.keyUpName = keyUpName;
    }

    public void setKeyDownName(String keyDownName) {
        this.keyDownName = keyDownName;
    }

    public void setKeyShootName(String keyShootName) {
        this.keyShootName = keyShootName;
    }
}
