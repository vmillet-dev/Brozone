package dev.vmillet.brozone.ui.screen;

import com.badlogic.gdx.graphics.Color;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.ui.GenericScreen;

import static com.badlogic.gdx.utils.ScreenUtils.clear;

public class LoadingScreen extends GenericScreen {
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
        // MVP load before or after main menu ?
        camera.update();
        application.play();
        application.setScreen(application.getGameManager().getScreens().getGameScreen());
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
