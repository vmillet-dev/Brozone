package dev.vmillet.brozone.managers;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.Hero;
import dev.vmillet.brozone.game.PlayerCreator;
import dev.vmillet.brozone.ui.ScreenContainer;

/**
 * A class that contains all managers needed by the game
 *
 */
public class GameManager {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(GameManager.class);

    private final ObjectManager objectManager;

    // TODO add assets manager
    // TODO add audio manager
    // TODO add drawing manager

    private final ScreenContainer screenContainer;
    private Hero hero;

    public GameManager(Brozone application) {
        objectManager = new ObjectManager();
        screenContainer = new ScreenContainer(application);
    }

    public void update() {
        objectManager.update(this);
    }

    public void startGame() {
        createGame();
        logger.debug("start game !");
    }

    private void createGame() {
        logger.debug("create game!");
        hero = new PlayerCreator().createPLayer(this);
        objectManager.add(hero);
    }

    public Hero getHero() {
        return hero;
    }
    public ScreenContainer getScreens() {
        return screenContainer;
    }
}
