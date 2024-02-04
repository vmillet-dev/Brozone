package dev.vmillet.brozone.input.mapping.adapter;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.mapping.ConfiguredInput;
import dev.vmillet.brozone.input.mapping.ControllerMappings;

public class MappedKeyboardAdapter implements InputProcessor {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(MappedKeyboardAdapter.class);

    ControllerMappings.MappedInputs mapping;

    public MappedKeyboardAdapter(ControllerMappings mappings) {
        this.mapping = mappings.getKeyboardMapping();
    }

    public boolean configuredKeyDown(int keycode) {
        return false;
    }

    public boolean configuredKeyUp(int keycode) {
        return false;
    }


    public boolean configuredTouchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        logger.debug("key down: " + Input.Keys.toString(keycode));

        ConfiguredInput configuredInput = mapping.getConfiguredFromKey(keycode);
        if (configuredInput != null) {
            logger.debug("input id: " + configuredInput.inputId);
        }
        return configuredInput != null && configuredKeyDown(configuredInput.inputId);
    }

    @Override
    public boolean keyUp(int keycode) {
        logger.debug("key up: " + Input.Keys.toString(keycode));
        ConfiguredInput configuredInput = mapping.getConfiguredFromKey(keycode);
        if (configuredInput != null) {
            logger.info("input id: " + configuredInput.inputId);
        }
        return configuredInput != null && configuredKeyUp(configuredInput.inputId);
    }

    @Override
    public boolean keyTyped(char character) {
        logger.debug("key typed: " + character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        logger.debug("touch down");
        return configuredTouchDown(screenX, screenY, pointer, button);
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
}
