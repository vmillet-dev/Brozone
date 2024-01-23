package dev.vmillet.brozone.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.managers.InputManager;

/**
 * Keep and update states of all user interaction on keyboard for a specific key / mouse.
 * This object is created inside a class implementing the Input interface and stored in
 * a list beside all other controls.
 */
public class UiControl {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(UiControl.class);

    private final int inputId;
    private Rectangle screenArea;
    private boolean isEnabled = true;
    private boolean isInputPressed;
    private boolean wasInputPressed;
    private boolean isInputFlashed;
    private boolean isAreaPressed;
    private boolean isAreaFlashed;
    private boolean isAreaJustUnpressed;
    private boolean isNegativeValue;


    public UiControl(Rectangle screenArea,int inputId) {
        this.inputId = inputId;
        this.screenArea = screenArea;
    }

    public UiControl(int inputId) {
        this.inputId = inputId;
    }

    public UiControl(int axisId, boolean isNegativeValue) {
        this.inputId = axisId;
        this.isNegativeValue = isNegativeValue;


    }

    public void axisMoved(int axisId, float value) {
        if (axisId == this.inputId && value < 0.0 == isNegativeValue) {
            isInputFlashed = true;
        }

    }

    public void buttonControllerPressed(int buttonId) {
        if (buttonId == this.inputId) {
            isInputFlashed = true;
        }
    }

    public void buttonControllerReleased(int buttonId) {
        if (buttonId == this.inputId) {
            isInputFlashed = false;
        }
    }

    public boolean maybeFlashPressed(int keyCode) {
        logger.debug("key pressed: " + Input.Keys.toString(keyCode));
        logger.debug("key defined in control: " + Input.Keys.toString(inputId));
        logger.debug("isKeyFlashed: " + isInputFlashed);
        logger.debug("isKeyPressed: " + isInputPressed);

        if (!isEnabled) {
            return false;
        }
        if (inputId == keyCode) {
            isInputFlashed = true;
            return true;
        }

        return false;
    }

    public boolean maybeFlashPressed(InputManager.InputPointer inputPointer) {
        if (!isEnabled) {
            return false;
        }
        boolean pressed = screenArea != null && screenArea.contains(inputPointer.x, inputPointer.y);
        if (pressed) {
            isAreaFlashed = true;
        }
        return pressed;
    }

    public void update(
            InputManager.InputPointer[] inputPointers,
            boolean canBePressed,
            InputManager inputMan,
            Brozone cmp
    ) {
        if (!isEnabled) {
            canBePressed = false;
        }

        updateKeys(canBePressed);
    }

    private void updateKeys(boolean canBePressed) {
        wasInputPressed = isInputPressed;
        if (isInputFlashed) {
            isInputPressed = true;
            isInputFlashed = false;
        } else {
            isInputPressed = canBePressed && Gdx.input.isKeyPressed(inputId);
        }
    }

    // poll to perform continuous actions
    public boolean isOn() {
        return isEnabled && (isInputPressed || isAreaPressed);
    }
}
