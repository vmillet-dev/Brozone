package dev.vmillet.brozone.utilsTest;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.ApplicationListener;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.mockito.Mockito.mock;

public class GdxTestRunner implements BeforeAllCallback, ApplicationListener  {
    private HeadlessApplication application;

    @Override
    public void beforeAll(ExtensionContext context) {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        application = new HeadlessApplication(this, config);
        Gdx.gl20 = mock(GL20.class);
        Gdx.gl = Gdx.gl20;
    }

    @Override
    public void create() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void render() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}

    public Application getApplication() {
        return application;
    }
}