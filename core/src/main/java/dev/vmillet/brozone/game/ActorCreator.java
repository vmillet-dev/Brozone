package dev.vmillet.brozone.game;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.controls.ControllerActorControl;
import dev.vmillet.brozone.controls.KeyboardActorControl;
import dev.vmillet.brozone.input.actor.ActorInput;
import dev.vmillet.brozone.input.actor.NpcActorInput;
import dev.vmillet.brozone.input.actor.PlayerActorInput;
import dev.vmillet.brozone.managers.GameManager;

/**
 * Build an actor with specific properties and attach input to get npc or player characters
 */
public class ActorCreator {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(ActorCreator.class);
    public Actor createPlayer(Brozone app, GameOptions.ControlType playerControlType){
        logger.debug("Create player");
        // MVP add spawn position
        final ActorInput actorInput = new PlayerActorInput(
                playerControlType == GameOptions.ControlType.KEYBOARD ?
                        new KeyboardActorControl(app) :
                        new ControllerActorControl(app)
        );
        return configureAndCreateHero(actorInput);
        // MVP add hero to the world
    }

    public Actor createPlayer(GameManager gameManager){
        logger.debug("Create player");
        // MVP add spawn position
        return configureAndCreateHero(new NpcActorInput());
        // MVP add hero to the world
    }

    private Actor configureAndCreateHero(ActorInput actorInput) {
        // MVP equip items
        return new Actor(actorInput);
    }
}
