package dev.vmillet.brozone.manager;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameCamera;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.character.Character;
import dev.vmillet.brozone.game.ActorCreator;

/**
 * Handle many managing aspects of one game. For now, the lifecycle of this object
 * is along the app lifecycle. Maybe must be created and destroyed for each level ?
 *
 */
public class GameManager {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(GameManager.class);

    private final GameCamera gameCamera;
    private final ObjectManager objectManager;

    // MVP add assets manager
    // MVP add audio manager
    // MVP add drawing manager

    private Character character;

    public GameManager(Brozone application) {
        objectManager = new ObjectManager();
        gameCamera = new GameCamera();
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
        character = new ActorCreator().createPlayer(app, app.getOptions().controlType);

        objectManager.add(character);
    }

    public Character getHero() {
        return character;
    }
    public GameCamera getGameCamera() { return gameCamera; }

    public ObjectManager getObjectManager() {
        return objectManager;
    }
}
