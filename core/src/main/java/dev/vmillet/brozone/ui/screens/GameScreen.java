package dev.vmillet.brozone.ui.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.controls.ControllerControl;
import dev.vmillet.brozone.controls.HeroControl;
import dev.vmillet.brozone.controls.KeyboardControl;
import dev.vmillet.brozone.ui.BaseScreen;

public class GameScreen extends BaseScreen {
    final Brozone application;
    private final Viewport viewport;
    private final OrthographicCamera camera;

    private HeroControl heroControl;

    public GameScreen(final Brozone application) {
        this.application = application;

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(800, 480, camera);

        GameOptions options = application.getOptions();

        switch (options.controlType) {
            case CONTROLLER:
                heroControl = new ControllerControl(application);
                break;
            case KEYBOARD:
            default:
                heroControl = new KeyboardControl(application, controls);
                break;
        }

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

    public HeroControl getHeroControl() {
        return heroControl;
    }
}
