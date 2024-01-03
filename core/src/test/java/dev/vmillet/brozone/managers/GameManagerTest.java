package dev.vmillet.brozone.managers;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.game.Hero;
import dev.vmillet.brozone.game.PlayerCreator;
import dev.vmillet.brozone.input.inputactor.Input;
import dev.vmillet.brozone.ui.ScreenContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class GameManagerTest {
    private GameManager gameManager;
    private ObjectManager objectManager;

    @BeforeEach
    void setUp() {
        Gdx.app = mock(Application.class);

        final Brozone app = mock(Brozone.class);

        try (var objectManagerMocked = mockConstruction(ObjectManager.class); var _sc = mockConstruction(ScreenContainer.class)) {
            gameManager = new GameManager(app);

            this.objectManager = objectManagerMocked.constructed().get(0);
        }

    }
    @Test
    void should_update() {
        // WHEN
        gameManager.update();

        // THEN
        verify(objectManager, times(1)).update(gameManager);

    }

    @Test
    void should_start_a_game() {
        // GIVEN
        final Hero hero = new Hero(mock(Input.class));

        try (var m_ = mockConstruction(PlayerCreator.class, (mock, _c) -> when(mock.createPlayer(any())).thenReturn(hero))) {
            // WHEN
            gameManager.startGame();

            // THEN
            verify(objectManager, times(1)).add(hero);
        }
    }
}
