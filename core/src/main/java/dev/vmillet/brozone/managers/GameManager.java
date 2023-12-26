package dev.vmillet.brozone.managers;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.game.Hero;
import dev.vmillet.brozone.game.PlayerCreator;
import dev.vmillet.brozone.ui.ScreenContainer;

/**
 * A class that contains all managers needed by the game
 *
 */
public class GameManager {
    private final ScreenContainer screenContainer;

    private Hero hero;

    public GameManager(Brozone application) {
        screenContainer = new ScreenContainer(application);
    }

    public void startGame() {

        createGame();
    }

    private void createGame() {
        hero = new PlayerCreator().createPLayer(this);
    }

    public Hero getHero() {
        return hero;
    }
    public ScreenContainer getScreenContainer() {
        return screenContainer;
    }
}
