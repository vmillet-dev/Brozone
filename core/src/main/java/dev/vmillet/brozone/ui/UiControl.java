package dev.vmillet.brozone.ui;

import com.badlogic.gdx.math.Rectangle;
import dev.vmillet.brozone.input.InputManager;

import javax.swing.text.Position;

public class UiControl {
    private final int key;
    private Rectangle screenArea;
    private boolean isWithSound;
    private String displayName;
    private boolean isEnabled = true;
    private boolean isKeyPressed;
    private boolean wasKeyPressed;
    private boolean isKeyFlashed;
    private boolean isAreaPressed;
    private boolean isAreaFlashed;
    private boolean isAreaJustUnpressed;
    private boolean doesMouseHover;
    private int warnCount;

    private int width;
    private int height;
    private Position referencePosition;
    private int offsetX;
    private int offsetY;

    public UiControl(int key) {
        this.key = key;
    }

    public boolean maybeFlashPressed(int keyCode) {
        if (!isEnabled) {
            return false;
        }
        if (key == keyCode) {
            isKeyFlashed = true;
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

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
