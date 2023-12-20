package dev.vmillet.brozone;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.vmillet.brozone.factory.GdxGameFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {
    private Game game;

    @Mock
    private GdxGameFactory factory;

    private Application application;

    @BeforeEach
    void setUp() {
        Gdx.gl20 = mock(GL20.class);
        Gdx.gl = Gdx.gl20;

        game = new Game(factory);

        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        application = new HeadlessApplication(game, config);

        when(factory.getSpriteBatch()).thenReturn(mock(SpriteBatch.class));
    }

    @Test
    void justAnExample() {
        // WHEN
        game.create();

        // THEN
        assertTrue(true);
    }

    @AfterEach
    void cleanUp() {
        application.exit();
        application = null;
    }
}
