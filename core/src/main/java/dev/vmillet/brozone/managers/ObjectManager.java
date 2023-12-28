package dev.vmillet.brozone.managers;

import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(ObjectManager.class);

    private final List<GameObject> objects;

    public ObjectManager() {
       objects = new ArrayList<>();
    }

    public void update(GameManager gameManager) {
        for (GameObject object : objects) {
            object.update(gameManager);
        }
    }

    public void add(GameObject object) {
        final String[] name = object.getClass().getName().split("\\.");
        logger.debug("add object to ObjectManager: " + name[name.length - 1]);
        objects.add(object);
    }
}
