package dev.vmillet.brozone;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameCamera {
    private final Viewport viewport;
    private final OrthographicCamera camera;


    public GameCamera() {
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(800, 480, camera);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }
}
