package dev.vmillet.brozone.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.ui.BaseScreen;
import dev.vmillet.brozone.ui.UiControl;

import java.util.ArrayList;
import java.util.List;

public class InputManager {

    List<UiControl> controls = new ArrayList<>();
    private final Vector2 lastTouchDragPosition;
    private final InputPointer flashInputPointer;


    InputManager() {
        Gdx.input.setInputProcessor(new InputHandler(this));

        flashInputPointer = new InputPointer();
        lastTouchDragPosition = new Vector2();
    }

    public void setScreen(Brozone application, BaseScreen screen) {
        controls = screen.getControls();
        application.setScreen(screen);
    }

    void maybeFlashPressed(int keyCode) {
        for (UiControl control : controls) {
            control.maybeFlashPressed(keyCode);
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

    }

    private static void setPointerPosition(InputPointer inputPointer, int screenX, int screenY) {
        int h = Gdx.graphics.getHeight();

        inputPointer.x = 1f * screenX / h;
        inputPointer.y = 1f * screenY / h;
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
