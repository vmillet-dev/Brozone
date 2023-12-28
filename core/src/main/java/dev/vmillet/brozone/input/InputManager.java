package dev.vmillet.brozone.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.ui.BaseScreen;
import dev.vmillet.brozone.ui.UiControl;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(InputManager.class);
    private static final int POINTER_COUNT = 4;


    List<UiControl> controls = new ArrayList<>();
    private final Vector2 lastTouchDragPosition;
    private final InputPointer flashInputPointer;
    private final InputPointer[] inputPointers;
    private boolean mouseOnUi;
    private final Vector2 mousePos;

    public InputManager() {
        logger.debug("creating input manager");
        Gdx.input.setInputProcessor(new InputHandler(this));

        flashInputPointer = new InputPointer();
        lastTouchDragPosition = new Vector2();
        mousePos = new Vector2();
        inputPointers = new InputPointer[POINTER_COUNT];
        for (int i = 0; i < POINTER_COUNT; i++) {
            inputPointers[i] = new InputPointer();
        }
    }

    public void update(Brozone application) {
        updatePointers();

        boolean consumed = false;
        for (UiControl control : controls) {
            control.update(inputPointers, !consumed, this, application);
            if (control.isOn() || control.isJustOff()) {
                consumed = true;
            }
            Rectangle area = control.getScreenArea();
            if (area != null && area.contains(mousePos)) {
                mouseOnUi = true;
            }
        }
    }

    public void setScreen(BaseScreen screen) {
        logger.debug("set screen: " + screen.getClass().getName());

        controls = screen.getControls();
        logger.debug("number of controls: " + controls.size());

        screen.getApplication().setScreen(screen);
    }

    void maybeFlashPressed(int keyCode) {
        for (UiControl control : controls) {
            if(control.maybeFlashPressed(keyCode)) {
                return;
            }
        }
    }

    void maybeFlashPressed(int x, int y) {
        lastTouchDragPosition.set(x, y);
        setPointerPosition(flashInputPointer, x, y);
        for (UiControl control : controls) {
            if (control.maybeFlashPressed(flashInputPointer)) {
                return;
            }
        }
    }

    void maybeTouchDragged(int x, int y) {
        // TODO to implement
    }

    public void playClick(Brozone application) {
        // TODO to implement
    }

    public void playHover(Brozone application) {
        // TODO to implement
    }

    private static void setPointerPosition(InputPointer inputPointer, int screenX, int screenY) {
        int h = Gdx.graphics.getHeight();

        inputPointer.x = 1f * screenX / h;
        inputPointer.y = 1f * screenY / h;
    }

    private void updatePointers() {
        for (int i = 0; i < POINTER_COUNT; i++) {
            InputPointer inputPointer = inputPointers[i];
            int screenX = Gdx.input.getX(i);
            int screenY = Gdx.input.getY(i);
            setPointerPosition(inputPointer, screenX, screenY);
            inputPointer.prevPressed = inputPointer.pressed;
            inputPointer.pressed = Gdx.input.isTouched(i);
        }
    }

    public static class InputPointer {
        public float x;
        public float y;
        public boolean pressed;
        public boolean prevPressed;

        public boolean isJustPressed() {
            return pressed && !prevPressed;
        }

        public boolean isJustUnPressed() {
            return !pressed && prevPressed;
        }
    }
}
