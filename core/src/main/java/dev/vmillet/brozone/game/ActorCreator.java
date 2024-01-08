package dev.vmillet.brozone.game;

import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.actor.ActorInput;
import dev.vmillet.brozone.input.actor.NpcActorInput;
import dev.vmillet.brozone.input.actor.PlayerActorInput;
import dev.vmillet.brozone.managers.GameManager;

/**
 * Build an actor with specific properties and attach input to get npc or player characters
 */
public class ActorCreator {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(ActorCreator.class);
    public Actor createPlayer(GameManager gameManager){
        logger.debug("Create player");
        // TODO add spawn position
        Actor actor = configureAndCreateHero(gameManager);
        // TODO add hero to the world
        return actor;
    }

    private Actor configureAndCreateHero(GameManager gameManager) {
        ActorInput actorInput = createInput(gameManager);
        // TODO equip items
        return new Actor(actorInput);
    }

    private ActorInput createInput(GameManager gameManager) {
        logger.debug("get the right input controller depending if npc or player");
        // TODO add a way to create npc
        if (false) {
            return new NpcActorInput();
        } else {
            return new PlayerActorInput(gameManager.getScreens().getGameScreen().getHeroControl());
        }
    }

    // TODO to implement
    private void addAndEquipItems() {
        logger.debug("add some stuffs to the character");
    }
}
