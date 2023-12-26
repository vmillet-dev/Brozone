package dev.vmillet.brozone.ui;

import com.badlogic.gdx.Screen;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseScreen implements Screen  {
    protected List<UiControl> controls = new ArrayList<>();

    public List<UiControl> getControls() {
        return controls;
    }
}
