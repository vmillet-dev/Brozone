package dev.vmillet.brozone.game;

import com.badlogic.gdx.physics.box2d.World;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameOptions;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.control.ControllerActorControl;
import dev.vmillet.brozone.control.KeyboardActorControl;
import dev.vmillet.brozone.game.character.Character;
import dev.vmillet.brozone.game.character.CharacterBuilder;
import dev.vmillet.brozone.input.ActorInput;
import dev.vmillet.brozone.input.NpcActorInput;
import dev.vmillet.brozone.input.PlayerActorInput;
import dev.vmillet.brozone.manager.GameManager;

/**
 * Build an actor with specific properties and attach input to get npc or player characters
 */
public class ActorCreator {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(ActorCreator.class);
    public Character createPlayer(Brozone app, GameOptions.ControlType playerControlType){
        logger.debug("Create player");
        // MVP add spawn position
        World world = app.getGameManager().getObjectManager().getWorld();

        final ActorInput actorInput = new PlayerActorInput(
                playerControlType == GameOptions.ControlType.KEYBOARD ?
                        new KeyboardActorControl(app) :
                        new ControllerActorControl(app)
        );
        return configureAndCreateHero(world, actorInput);
        // MVP add hero to the world
    }

    private Character configureAndCreateHero(World world, ActorInput actorInput) {
        // MVP equip items
        return CharacterBuilder.build(world, actorInput);
    }
}
