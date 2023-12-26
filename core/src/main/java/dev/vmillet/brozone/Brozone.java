package dev.vmillet.brozone;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.vmillet.brozone.input.InputManager;
import dev.vmillet.brozone.managers.GameManager;
import jakarta.inject.Inject;

public class Brozone extends Game {
	public SpriteBatch batch;
	public BitmapFont font;

	@Inject
	protected InputManager inputManager;
	private GameManager gameManager;
	private GameOptions options;
	private boolean isMobile;

	/**
	 * Method called once when the application is created.
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		gameManager = new GameManager(this);
		options = new GameOptions();
		inputManager.setScreen(this, gameManager.getScreenContainer().getMainMenuScreen());
	}

	/**
	 * 	Method called by the game loop from the application every time rendering should be performed.
	 * 	Game logic updates are usually also performed in this method.
	 */
	@Override
	public void render () {
		super.render();
	}

	/**
	 * This method is called every time the game screen is re-sized and the game is not in the paused state. It is also called once just after the create() method.
	 * The parameters are the new width and height the screen has been resized to in pixels.
	 *
	 * @param width the new width in pixels
	 * @param height the new height in pixels
	 */
	@Override
	public void resize (int width, int height) {
		super.resize(width, height);
	}

	/**
	 * On Android this method is called when the Home button is pressed or an incoming call is received. On desktop this is called when the window is minimized and just before dispose() when exiting the application.
	 * A good place to save the game state.
	 */
	@Override
	public void pause () {
		super.pause();
	}

	/**
	 * 	This method is called on Android, when the application resumes from a paused state, and on desktop when unminimized.
	 */
	@Override
	public void resume () {
		super.resume();
	}


	/**
	 * 	Called when the application is destroyed. It is preceded by a call to pause().
	 */
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}

	public void play() {
		gameManager.startGame();
	}

	public InputManager getInputManager() {
		return inputManager;
	}
	public GameManager getGameManager() {
		return gameManager;
	}
	public GameOptions getOptions() { return options; }
	public boolean isMobile() {
		return isMobile;
	}
}
