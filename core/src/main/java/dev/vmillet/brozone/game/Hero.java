package dev.vmillet.brozone.game;

import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.input.inputactor.Input;
import dev.vmillet.brozone.managers.GameManager;

public class Hero implements GameObject {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(Hero.class);

    private final Input input;

    Hero(Input input) {
        this.input = input;
    }
    // TODO add properties like life, xp, guns

    @Override
    public void update(GameManager gameManager) {
        if (input.isLeft()) {
            logger.info("player turn left");
        }
        if (input.isRight()) {
            logger.info("player turn right");
        }
        if (input.isUp()) {
            logger.info("player jump");
        }
        if (input.isDown()) {
            logger.info("player crougth");
        }
    }
}
