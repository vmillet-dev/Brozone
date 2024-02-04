package dev.vmillet.brozone.ui;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.ui.screen.GameScreen;
import dev.vmillet.brozone.ui.screen.LoadingScreen;
import dev.vmillet.brozone.ui.screen.MainMenuScreen;

/**
 * Create and add a reference to all screens of the app
 */
public class ScreenContainer {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(ScreenContainer.class);

    private final MainMenuScreen mainMenuScreen;
    private final LoadingScreen loadingScreen;
    private final GameScreen gameScreen;

    public ScreenContainer(Brozone application) {
        logger.debug("Start allocate all screens in this container");

        mainMenuScreen = new MainMenuScreen(application);
        loadingScreen = new LoadingScreen(application);
        gameScreen = new GameScreen(application);
    }

    public MainMenuScreen getMainMenuScreen() {
        return mainMenuScreen;
    }

    public LoadingScreen getLoadingScreen() {
        return loadingScreen;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }
}
