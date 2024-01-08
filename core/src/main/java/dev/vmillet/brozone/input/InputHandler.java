package dev.vmillet.brozone.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.managers.InputManager;

public class InputHandler implements InputProcessor, GestureDetector.GestureListener {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(InputHandler.class);

    private final InputManager inputManager;

    public InputHandler(InputManager inputMan) {
        inputManager = inputMan;
    }

    @Override
    public boolean keyDown(int keycode) {
        logger.debug("key down: " + Input.Keys.toString(keycode));
        inputManager.maybeFlashPressed(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        logger.debug("key up: " + Input.Keys.toString(keycode));
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        logger.debug("touch down");
        inputManager.maybeFlashPressed(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        logger.debug("touch up");
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        logger.debug("touch cancelled");
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        inputManager.maybeTouchDragged(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        logger.debug("scrolled");
        return false;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        logger.debug("touch down");
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        logger.debug("tap");
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        logger.debug("long press");
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        logger.debug("fling");
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        logger.debug("pan");
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        logger.debug("pan stop");
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        logger.debug("zoom");
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        logger.debug("pinch");
        return false;
    }

    @Override
    public void pinchStop() {
        logger.debug("pinch stop");
    }
}
