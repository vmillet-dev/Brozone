package dev.vmillet.brozone.input.mapping.handler;

import com.badlogic.gdx.Input;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.mapping.ControllerMappings;
import dev.vmillet.brozone.input.mapping.adapter.MappedKeyboardAdapter;
import dev.vmillet.brozone.manager.InputManager;

public class InputKeyboardHandler extends MappedKeyboardAdapter {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(InputKeyboardHandler.class);

    private final InputManager inputManager;

    public InputKeyboardHandler(ControllerMappings mappings, InputManager inputMan) {
        super(mappings);
        inputManager = inputMan;
    }

    @Override
    public boolean configuredKeyDown(int keycode) {
        logger.debug("key down: " + Input.Keys.toString(keycode));
        inputManager.maybeFlashPressed(keycode);
        return false;
    }

    @Override
    public boolean configuredTouchDown(int screenX, int screenY, int pointer, int button) {
        logger.debug("touch down");
        inputManager.maybeFlashPressed(screenX, screenY);
        return false;
    }


    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        inputManager.maybeTouchDragged(screenX, screenY);
        return false;
    }
}
