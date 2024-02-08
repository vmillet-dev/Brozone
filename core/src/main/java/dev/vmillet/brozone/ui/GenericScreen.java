package dev.vmillet.brozone.ui;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.GameCamera;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic class extended by all object that should implement Screen interface
 */
public abstract class GenericScreen implements Screen  {
    protected final Brozone application;
    protected final GameCamera gameCamera;


    protected GenericScreen(Brozone application) {
        this.application = application;
        this.gameCamera = application.getGameManager().getGameCamera();
    }

    public Brozone getApplication() { return application; }

}
