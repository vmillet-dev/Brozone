package dev.vmillet.brozone.managers;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.Actor;
import dev.vmillet.brozone.game.ActorCreator;
import dev.vmillet.brozone.ui.ScreenContainer;

/**
 * Handle many managing aspects of one game. For now, the lifecycle of this object
 * is along the app lifecycle. Maybe must be created and destroyed for each level ?
 *
 */
public class GameManager {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(GameManager.class);

    private final ObjectManager objectManager;

    // TODO add assets manager
    // TODO add audio manager
    // TODO add drawing manager

    private final ScreenContainer screenContainer;
    private Actor actor;

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
        actor = new ActorCreator().createPlayer(this);
        objectManager.add(actor);
    }

    public Actor getHero() {
        return actor;
    }
    public ScreenContainer getScreens() {
        return screenContainer;
    }
}
