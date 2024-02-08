package dev.vmillet.brozone.game.character;

import com.badlogic.gdx.physics.box2d.Body;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.GameObject;
import dev.vmillet.brozone.input.ActorInput;
import dev.vmillet.brozone.manager.GameManager;

/**
 *
 */
public class Character implements GameObject {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(Character.class);

    private final ActorInput actorInput;
    private final Body body;

    public Character(ActorInput actorInput, Body body) {
        this.actorInput = actorInput;
        this.body = body;
    }
    // MVP add properties like life, xp, guns
    // MVP Add drawable and handling physics with Box2D plugin

    @Override
    public void update(GameManager gameManager) {
        if (actorInput.isMovingLeft()) {
            logger.info("player move left");
        }
        if (actorInput.isMovingRight()) {
            logger.info("player move right");
        }
        if (actorInput.isJumping()) {
            logger.info("player jump");
        }
        if (actorInput.isCrouching()) {
            logger.info("player crouch");
        }
        if (actorInput.isShooting()) {
            logger.info("player shooting");
        }
    }
}
