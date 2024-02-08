package dev.vmillet.brozone.ui.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.ui.GenericScreen;

/**
 * Screen class that handle main menu.
 */
public class MainMenuScreen extends GenericScreen {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(MainMenuScreen.class);

    public MainMenuScreen(final Brozone application) {
        super(application);
        logger.debug("creating MainMenu screen");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        gameCamera.getCamera().update();
        application.batch.setProjectionMatrix(gameCamera.getCamera().combined);

        application.batch.begin();
        application.font.draw(application.batch, "Welcome to Drop!!! ", 100, 150);
        application.font.draw(application.batch, "Tap anywhere to begin!", 100, 100);
        application.batch.end();

        if (Gdx.input.isTouched()) {
            application.setScreen(new LoadingScreen(application));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        gameCamera.getViewport().update(width, height);
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
