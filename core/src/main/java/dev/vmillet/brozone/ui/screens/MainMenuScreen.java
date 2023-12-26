package dev.vmillet.brozone.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.ui.BaseScreen;

/**
 * Screen class that handle main menu.
 */
public class MainMenuScreen extends BaseScreen {
    final Brozone application;
    private final Viewport viewport;
    private final OrthographicCamera camera;

    public MainMenuScreen(final Brozone application) {
        this.application = application;

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(800, 480, camera);
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
            application.setScreen(application.getGameManager().getScreenContainer().getLoadingScreen());
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
