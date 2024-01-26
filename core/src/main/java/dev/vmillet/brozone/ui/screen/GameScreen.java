package dev.vmillet.brozone.ui.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.ui.GenericScreen;

public class GameScreen extends GenericScreen {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(GameScreen.class);

    public GameScreen(final Brozone application) {
        super(application);
        logger.debug("creating game screen");

        // MVP add a level manager somehow

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
