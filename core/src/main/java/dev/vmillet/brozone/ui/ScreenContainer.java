package dev.vmillet.brozone.ui;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.ui.screens.GameScreen;
import dev.vmillet.brozone.ui.screens.LoadingScreen;
import dev.vmillet.brozone.ui.screens.MainMenuScreen;

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
