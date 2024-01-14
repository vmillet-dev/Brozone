package dev.vmillet.brozone.ui;

import com.badlogic.gdx.controllers.Controller;

public class UiControllerControl {
    private final int  buttonId;
    private boolean buttonPressed = false;

    public UiControllerControl(Controller controller, int buttonId) {
        this.buttonId = buttonId;
    }

    public void update() {

    }

    public boolean isOn() {
        return buttonPressed;
    }

    public void buttonControllerPressed(int buttonId) {
        if (this.buttonId == buttonId) {
            buttonPressed = true;
        }
    }

    public void buttonControllerReleased(int buttonId) {
        if (this.buttonId == buttonId) {
            buttonPressed = false;
        }
    }
}
