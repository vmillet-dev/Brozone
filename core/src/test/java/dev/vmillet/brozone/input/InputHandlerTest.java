package dev.vmillet.brozone.input;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class InputHandlerTest {
    private InputHandler inputHandler;
    private InputManager im;

    @BeforeEach
    void setUp() {
        Gdx.app = mock(Application.class);

        im = mock(InputManager.class);
        inputHandler = new InputHandler(im);
    }

    @Test
    void keyDown_should_call_input_manager_and_return_false() {
        // WHEN
        final boolean result = inputHandler.keyDown(42);

        // THEN
        verify(im, times(1)).maybeFlashPressed(42);
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void touchDown_should_call_input_manager_and_return_false_when_touchdown_with_integer_as_value_type() {
        // WHEN
        final boolean result = inputHandler.touchDown(  0, 1, 2, 3);

        // THEN
        verify(im, times(1)).maybeFlashPressed(0, 1);
        verify(im, never()).maybeFlashPressed(anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void touchDown_should_only_return_false_when_touchdown_with_float_as_value_type() {
        // WHEN
        final boolean result = inputHandler.touchDown(  0f, 1f, 2, 3);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());

        assertThat(result).isFalse();
    }

    @Test
    void touchUp_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.touchUp(0, 1, 2, 3);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void touchDragged_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.touchDragged(0, 1, 2);

        // THEN
        verify(im, times(1)).maybeTouchDragged(0, 1);
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void touchCancelled_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.touchCancelled(9, 8, 7 ,6);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }


    @Test
    void keyTyped_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.keyTyped('A');

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void keyUp_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.keyUp(42);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void mouseMoved_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.mouseMoved(12, 42);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void scrolled_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.scrolled(10, 20);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void tap_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.tap(10, 20, 30, 40);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void longPress_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.longPress(10, 20);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void fling_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.fling(10f, 20f, 1);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void pan_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.pan(10f, 20f, 1f, 2f);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void panStop_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.panStop(10f, 20f, 1, 2);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void zoom_should_only_return_false() {
        // WHEN
        final boolean result = inputHandler.zoom(10f, 20f);

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void pinch_should_only_return_false() {

        // WHEN
        final boolean result = inputHandler.pinch(new Vector2(), new Vector2(), new Vector2(), new Vector2());

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
        assertThat(result).isFalse();
    }

    @Test
    void pinchStop_should_only_return_false() {
        // WHEN
        inputHandler.pinchStop();

        // THEN
        verify(im, never()).maybeFlashPressed(anyInt());
        verify(im, never()).maybeFlashPressed(anyInt(), anyInt());
        verify(im, never()).maybeTouchDragged(anyInt(), anyInt());
    }

}
