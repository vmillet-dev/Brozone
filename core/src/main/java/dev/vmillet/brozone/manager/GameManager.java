package dev.vmillet.brozone.manager;

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

    // MVP add assets manager
    // MVP add audio manager
    // MVP add drawing manager

    private final ScreenContainer screenContainer;
    private Actor actor;

    public GameManager(Brozone application) {
        objectManager = new ObjectManager();
        screenContainer = new ScreenContainer(application);
    }

    public void update() {
        objectManager.update(this);
    }

    public void startGame(Brozone brozone) {
        createGame(brozone);
        logger.debug("start game !");
    }

    private void createGame(Brozone app) {
        logger.debug("create game!");
        app.getInputManager().resetControls();
        actor = new ActorCreator().createPlayer(app, app.getOptions().controlType);

        objectManager.add(actor);
    }

    public Actor getHero() {
        return actor;
    }
    public ScreenContainer getScreens() {
        return screenContainer;
    }
}
