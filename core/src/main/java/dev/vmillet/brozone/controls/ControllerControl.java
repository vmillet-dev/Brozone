package dev.vmillet.brozone.controls;

import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.Hero;
import dev.vmillet.brozone.managers.GameManager;

public class ControllerControl implements HeroControl {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(KeyboardControl.class);


    public ControllerControl(Brozone application) {
        logger.debug("create controller control");
    }

    @Override
    public void update(Brozone application, boolean enabled) {
        GameManager game = application.getGameManager();
        Hero hero = game.getHero();
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public boolean isUp() {
        return false;
    }

    @Override
    public boolean isDown() {
        return false;
    }

    @Override
    public boolean isShoot() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
