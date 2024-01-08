package dev.vmillet.brozone.ui.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.controls.ControllerActorControl;
import dev.vmillet.brozone.controls.ActorControl;
import dev.vmillet.brozone.controls.KeyboardActorControl;
import dev.vmillet.brozone.ui.BaseScreen;

public class GameScreen extends BaseScreen {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(GameScreen.class);

    private ActorControl actorControl;

    public GameScreen(final Brozone application) {
        super(application);
        logger.debug("creating game screen");

        GameOptions options = application.getOptions();

        switch (options.controlType) {
            case CONTROLLER:
                actorControl = new ControllerActorControl(application, controllerControls);
                break;
            case KEYBOARD:
            default:
                actorControl = new KeyboardActorControl(application, keyboardControls);
                break;
        }

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

    public ActorControl getHeroControl() {
        return actorControl;
    }
}
