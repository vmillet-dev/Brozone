package dev.vmillet.brozone;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.vmillet.brozone.managers.InputManager;
import dev.vmillet.brozone.managers.GameManager;

import static dev.vmillet.brozone.GdxLogger.setDebugLevelMode;

/**
 * Main class called by each target application
 */
public class Brozone extends Game {
	private static final GdxLogger logger = GdxLoggerFactory.getLogger(Brozone.class);

	public SpriteBatch batch;
	public BitmapFont font;

	private InputManager inputManager;
	private GameManager gameManager;
	private GameOptions options;
	private boolean isMobile;

	/**
	 * Method called once when the application is created.
	 */
	@Override
	public void create () {
		setDebugLevelMode();

		logger.debug("Creating application");

		batch = new SpriteBatch();
		font = new BitmapFont();
		options = new GameOptions();
		gameManager = new GameManager(this);

		inputManager = new InputManager();
		inputManager.setScreen(gameManager.getScreens().getMainMenuScreen());
	}

	/**
	 * 	Method called by the game loop from the application every time rendering should be performed.
	 * 	Game logic updates are usually also performed in this method.
	 */
	@Override
	public void render () {
		super.render();
		inputManager.update(this);
		gameManager.update();
		// MVP maybe must add a drawing manager to draw all objects only once
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
		// MVP handle pause
	}

	/**
	 * 	This method is called on Android, when the application resumes from a paused state, and on desktop when unminimized.
	 */
	@Override
	public void resume () {
		super.resume();
		// MVP handle resume
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
		logger.debug("Calling GameManager to start a game");
		// MVP handle new game
		gameManager.startGame();
	}

	public void finishGame() {
		// MVP handle when game finished
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
