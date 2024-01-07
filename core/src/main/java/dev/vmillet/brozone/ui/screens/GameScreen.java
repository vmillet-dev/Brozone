package dev.vmillet.brozone.ui.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.controls.ControllerControl;
import dev.vmillet.brozone.controls.HeroControl;
import dev.vmillet.brozone.controls.KeyboardControl;
import dev.vmillet.brozone.ui.BaseScreen;

public class GameScreen extends BaseScreen {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(GameScreen.class);

    private HeroControl heroControl;

    public GameScreen(final Brozone application) {
        super(application);
        logger.debug("creating game screen");

        GameOptions options = application.getOptions();

        switch (options.controlType) {
            case CONTROLLER:
                heroControl = new ControllerControl(application, controllerControls);
                break;
            case KEYBOARD:
            default:
                heroControl = new KeyboardControl(application, keyboardControls);
                break;
        }

        // TODO add a level manager somehow

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
