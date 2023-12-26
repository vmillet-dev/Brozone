package dev.vmillet.brozone.ui.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.ui.BaseScreen;

import static com.badlogic.gdx.utils.ScreenUtils.clear;

public class LoadingScreen extends BaseScreen {

    final Brozone application;

    private final Viewport viewport;
    private final OrthographicCamera camera;

    public LoadingScreen(Brozone application) {
        this.application = application;

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(800, 480, camera);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clear(Color.DARK_GRAY);

        camera.update();
        application.play();
        application.setScreen(application.getGameManager().getScreenContainer().getGameScreen());
        dispose();
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
