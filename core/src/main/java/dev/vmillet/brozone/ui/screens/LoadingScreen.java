package dev.vmillet.brozone.ui.screens;

import com.badlogic.gdx.graphics.Color;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.ui.BaseScreen;

import static com.badlogic.gdx.utils.ScreenUtils.clear;

public class LoadingScreen extends BaseScreen {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(LoadingScreen.class);

    public LoadingScreen(Brozone application) {
        super(application);
        logger.debug("creating loading screen");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clear(Color.DARK_GRAY);
        // TODO load before or after main menu ?
        camera.update();
        application.play();
        application.getInputManager().setScreen(application.getGameManager().getScreens().getGameScreen());
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
