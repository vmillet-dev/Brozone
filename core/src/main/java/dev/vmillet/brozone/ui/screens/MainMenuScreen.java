package dev.vmillet.brozone.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.InputManager;
import dev.vmillet.brozone.ui.BaseScreen;

/**
 * Screen class that handle main menu.
 */
public class MainMenuScreen extends BaseScreen {
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

        camera.update();
        application.batch.setProjectionMatrix(camera.combined);

        application.batch.begin();
        application.font.draw(application.batch, "Welcome to Drop!!! ", 100, 150);
        application.font.draw(application.batch, "Tap anywhere to begin!", 100, 100);
        application.batch.end();

        if (Gdx.input.isTouched()) {
            InputManager inputManager = application.getInputManager();
            inputManager.setScreen(application.getGameManager().getScreens().getLoadingScreen());
            dispose();
        }
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
