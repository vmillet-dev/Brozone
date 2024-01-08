package dev.vmillet.brozone.game;

import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.actor.ActorInput;
import dev.vmillet.brozone.managers.GameManager;

/**
 *
 */
public class Actor implements GameObject {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(Actor.class);

    private final ActorInput actorInput;

    Actor(ActorInput actorInput) {
        this.actorInput = actorInput;
    }
    // TODO add properties like life, xp, guns
    // TODO Add drawable and handling physics with Box2D plugin

    @Override
    public void update(GameManager gameManager) {
        if (actorInput.isLeft()) {
            logger.info("player turn left");
        }
        if (actorInput.isRight()) {
            logger.info("player turn right");
        }
        if (actorInput.isUp()) {
            logger.info("player jump");
        }
        if (actorInput.isDown()) {
            logger.info("player crougth");
        }
    }
}
