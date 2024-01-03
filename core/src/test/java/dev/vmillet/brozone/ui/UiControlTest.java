package dev.vmillet.brozone.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import dev.vmillet.brozone.Brozone;
import dev.vmillet.brozone.input.InputManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class UiControlTest {
    private UiControl uiControl;

    @BeforeEach
    void setUp() {
        Gdx.app = mock(Application.class);

        final Rectangle rect = new Rectangle(0, 0, 100, 50);

        uiControl = new UiControl(rect, true, 42);
    }

    @Test
    void should_be_true_if_matching_key_is_pressed() {
        // WHEN
        final boolean result = uiControl.maybeFlashPressed(42);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    void should_be_false_if_matching_key_is_pressed_but_control_is_disable() {
        // GIVEN
        uiControl.setEnabled(false);

        // WHEN
        final boolean result = uiControl.maybeFlashPressed(42);

        // THEN
        assertThat(result).isFalse();
    }

    @Test
    void should_be_false_if_wrong_key_is_pressed() {
        // WHEN
        final boolean result = uiControl.maybeFlashPressed(0);

        // THEN
        assertThat(result).isFalse();
    }

    @Test
    void should_be_true_if_input_pointer_is_inside_screen_area() {
        // GIVEN
        final InputManager.InputPointer pointer = new InputManager.InputPointer();
        pointer.x = 10;
        pointer.y = 10;

        // WHEN
        final boolean result = uiControl.maybeFlashPressed(pointer);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    void should_be_false_if_input_pointer_is_inside_screen_area_but_control_is_disable() {
        // GIVEN
        final InputManager.InputPointer pointer = new InputManager.InputPointer();
        pointer.x = 10;
        pointer.y = 10;

        uiControl.setEnabled(false);

        // WHEN
        final boolean result = uiControl.maybeFlashPressed(pointer);

        // THEN
        assertThat(result).isFalse();
    }

    @Test
    void should_be_false_if_input_pointer_is_outside_screen_area() {
        // GIVEN
        final InputManager.InputPointer pointer = new InputManager.InputPointer();
        pointer.x = 600;
        pointer.y = 20;

        // WHEN
        final boolean result = uiControl.maybeFlashPressed(pointer);

        // THEN
        assertThat(result).isFalse();
    }

    @Test
    void should_be_false_if_no_screen_area_is_defined() {
        // GIVEN
        final InputManager.InputPointer pointer = new InputManager.InputPointer();

        uiControl = new UiControl(null, true, 0);

        // WHEN
        final boolean result = uiControl.maybeFlashPressed(pointer);

        // THEN
        assertThat(result).isFalse();
    }

    @Test
    void should_update_if_key_was_flashed() {
        // GIVEN
        final Brozone app = mock(Brozone.class);
        final InputManager inputManager = mock(InputManager.class);
        boolean canBePressed = true;

        // WHEN
        uiControl.update(null, canBePressed, inputManager, app);

        // THEN
        assertThat(canBePressed).isFalse();
    }

    @Test
    void should_update_if_key_is_currently_pressed() {
        // GIVEN
        final Brozone app = mock(Brozone.class);
        final InputManager inputManager = mock(InputManager.class);
        boolean canBePressed = true;

        // WHEN
        uiControl.update(null, canBePressed, inputManager, app);

        // THEN
        assertThat(canBePressed).isFalse();
    }

    @Test
    void should_update_on_disabled_control() {
        // GIVEN
        final Brozone app = mock(Brozone.class);
        final InputManager inputManager = mock(InputManager.class);
        boolean canBePressed = true;

        uiControl.setEnabled(false);

        // WHEN
        uiControl.update(null, canBePressed, inputManager, app);

        // THEN
        assertThat(canBePressed).isFalse();
    }

}
