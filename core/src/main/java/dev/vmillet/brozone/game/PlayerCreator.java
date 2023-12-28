package dev.vmillet.brozone.game;

import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.inputactor.Input;
import dev.vmillet.brozone.input.inputactor.NpcInput;
import dev.vmillet.brozone.input.inputactor.PlayerInput;
import dev.vmillet.brozone.managers.GameManager;

/**
 * Build an actor with specific properties and attach input to get npc or player characters
 */
public class PlayerCreator {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(PlayerCreator.class);
    public Hero createPlayer(GameManager gameManager){
        logger.debug("Create player");
        // TODO add spawn position
        Hero hero = configureAndCreateHero(gameManager);
        // TODO add hero to the world
        return hero;
    }

    private Hero configureAndCreateHero(GameManager gameManager) {
        Input input = createInput(gameManager);
        // TODO equip items
        return new Hero(input);
    }

    private Input createInput(GameManager gameManager) {
        logger.debug("get the right input controller depending if npc or player");
        // TODO add a way to create npc
        if (false) {
            return new NpcInput();
        } else {
            return new PlayerInput(gameManager.getScreens().getGameScreen().getHeroControl());
        }
    }

    // TODO to implement
    private void addAndEquipItems() {
        logger.debug("add some stuffs to the character");
    }
}
