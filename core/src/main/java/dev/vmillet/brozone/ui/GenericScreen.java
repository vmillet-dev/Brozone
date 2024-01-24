package dev.vmillet.brozone.ui;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import dev.vmillet.brozone.Brozone;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic class extended by all object that should implement Screen interface
 */
public abstract class GenericScreen implements Screen  {
    protected final Brozone application;
    protected final Viewport viewport;
    protected final OrthographicCamera camera;

    protected List<UiControl> screenControl = new ArrayList<>();

    protected GenericScreen(Brozone application) {
        this.application = application;

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(800, 480, camera);
    }

    public Brozone getApplication() { return application; }

}
