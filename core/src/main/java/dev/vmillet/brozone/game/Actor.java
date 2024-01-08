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
    // MVP add properties like life, xp, guns
    // MVP Add drawable and handling physics with Box2D plugin

    @Override
    public void update(GameManager gameManager) {
        if (actorInput.isMovingLeft()) {
            logger.info("player turn left");
        }
        if (actorInput.isMovingRight()) {
            logger.info("player turn right");
        }
        if (actorInput.isJumping()) {
            logger.info("player jump");
        }
        if (actorInput.isCrouching()) {
            logger.info("player crougth");
        }
    }
}
