package dev.vmillet.brozone.manager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import dev.vmillet.brozone.GdxLogger;
import dev.vmillet.brozone.GdxLoggerFactory;
import dev.vmillet.brozone.game.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to keep a reference of all objects that
 * must be updated whether about position or about graphic render. It must be done
 * once for each frame to calculate the state of all entities in the world
 */
public class ObjectManager {
    private static final GdxLogger logger = GdxLoggerFactory.getLogger(ObjectManager.class);

    private final List<GameObject> objects;
    World world;
    Box2DDebugRenderer debugRenderer;

    public ObjectManager() {
       objects = new ArrayList<>();
       world = new World(new Vector2(0, -10), true);
       debugRenderer = new Box2DDebugRenderer();
    }

    public void update(GameManager gameManager) {
        debugRenderer.render(world, gameManager.getGameCamera().getCamera().combined);

        for (GameObject object : objects) {
            object.update(gameManager);
        }
    }

    public void add(GameObject object) {
        final String[] name = object.getClass().getName().split("\\.");
        logger.debug("add object to ObjectManager: " + name[name.length - 1]);
        objects.add(object);
    }

    public World getWorld() {
        return world;
    }
}
