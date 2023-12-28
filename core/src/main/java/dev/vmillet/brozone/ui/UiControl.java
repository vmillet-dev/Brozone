package dev.vmillet.brozone.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.InputManager;

/**
 * Keep and update states of all user interaction on keyboard for a specific key / mouse.
 * This object is created inside a class implementing the Input interface and stored in
 * a list beside all other controls.
 */
public class UiControl {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(UiControl.class);

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
//    private Position referencePosition;
    private int offsetX;
    private int offsetY;


    public UiControl(Rectangle screenArea, boolean isWithSound, int key) {
        this.isWithSound = isWithSound;
        this.key = key;
        this.screenArea = screenArea;
    }

    // TODO handle ui control with coordinates
//    public UiControl(int width, int height, Position referencePosition, int offsetX, int offsetY, boolean isWithSound, int key) {
//        this.isWithSound = isWithSound;
//        this.key = key;
//
//        this.width = width;
//        this.height = height;
//        this.referencePosition = referencePosition;
//        this.offsetX = offsetX;
//        this.offsetY = offsetY;
//
//        computePosition();
//    }

    public UiControl(int key) {
        this.key = key;
    }

    public boolean maybeFlashPressed(int keyCode) {
        logger.debug("key pressed: " + Input.Keys.toString(keyCode));
        logger.debug("key defined in control: " + Input.Keys.toString(key));
        logger.debug("isKeyFlashed: " + isKeyFlashed);
        logger.debug("isKeyPressed: " + isKeyPressed);

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
        /* TODO uncomment these update methods when fixed
        updateArea(inputPointers, canBePressed);
        updateHover(inputPointers, inputMan, cmp);
        */

        if (isWithSound && isJustOff()) {
            inputMan.playClick(cmp);
        }
        if (warnCount > 0) {
            warnCount--;
        }
    }

    private void updateKeys(boolean canBePressed) {
        wasKeyPressed = isKeyPressed;
        if (isKeyFlashed) {
            isKeyPressed = true;
            isKeyFlashed = false;
        } else {
            isKeyPressed = canBePressed && Gdx.input.isKeyPressed(key);
        }
//        logger.debug("key updated. Key pressed: " + isKeyPressed);
    }

    // TODO maybe rewrite this method to better handle click on area
    private void updateArea(InputManager.InputPointer[] inputPointers, boolean canBePressed) {
        if (screenArea == null) {
            return;
        }
        isAreaJustUnpressed = false;
        if (isAreaFlashed) {
            isAreaPressed = true;
            isAreaFlashed = false;
        } else {
            isAreaPressed = false;
            if (canBePressed) {
                for (InputManager.InputPointer inputPointer : inputPointers) {
                    if (!screenArea.contains(inputPointer.x, inputPointer.y)) {
                        continue;
                    }
                    isAreaPressed = inputPointer.pressed;
                    isAreaJustUnpressed = !inputPointer.pressed && inputPointer.prevPressed;
                    break;
                }
            }
        }
    }

    // TODO maybe rewrite this method to better handle hover on area
    private void updateHover(
            InputManager.InputPointer[] inputPointers,
            InputManager inputMan,
            Brozone cmp
    ) {
        if (screenArea == null || isAreaPressed || inputPointers[0].pressed) {
            return;
        }
        boolean prev = doesMouseHover;
        doesMouseHover = screenArea.contains(inputPointers[0].x, inputPointers[0].y);
        if (isWithSound && doesMouseHover && !prev) {
            inputMan.playHover(cmp);
        }
    }

    // poll to perform continuous actions
    public boolean isOn() {
        return isEnabled && (isKeyPressed || isAreaPressed);
    }

    // poll to perform one-off actions
    public boolean isJustOff() {
        return isEnabled && (!isKeyPressed && wasKeyPressed || isAreaJustUnpressed);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void blur() {
        isKeyPressed = false;
        wasKeyPressed = false;
        isAreaPressed = false;
        isAreaJustUnpressed = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Rectangle getScreenArea() {
        return screenArea;
    }

    public boolean isMouseHover() {
        return doesMouseHover;
    }

    public void enableWarn() {
        warnCount = 2;
    }

//    public void computePosition() {
//        if (referencePosition == null) {
//            return;
//        }
//
//        DisplayDimensions displayDimensions = SolApplication.displayDimensions;
//
//        int x = referencePosition.getX() + offsetX - width / 2;
//        int y = referencePosition.getY() + offsetY - height / 2;
//
//        screenArea = new Rectangle(x * displayDimensions.getRatio() / displayDimensions.getWidth(), y / (float) displayDimensions.getHeight(), width * displayDimensions.getRatio() / displayDimensions.getWidth(), height / (float) displayDimensions.getHeight());
//    }
}
