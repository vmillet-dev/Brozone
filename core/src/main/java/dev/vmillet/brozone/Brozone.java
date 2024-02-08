package dev.vmillet.brozone;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2D;
import dev.vmillet.brozone.manager.InputManager;
import dev.vmillet.brozone.manager.GameManager;
import dev.vmillet.brozone.ui.screen.MainMenuScreen;

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

	@Override
	public void create () {
		setDebugLevelMode();

		logger.debug("Creating application");
		Box2D.init();

		batch = new SpriteBatch();
		font = new BitmapFont();
		options = new GameOptions();
		gameManager = new GameManager(this);

		inputManager = new InputManager();
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
		inputManager.update(this);
		gameManager.update();
		draw();
		// MVP maybe must add a drawing manager to draw all objects only once
	}

	@Override
	public void resize (int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause () {
		super.pause();
		// MVP handle pause
	}

	@Override
	public void resume () {
		super.resume();
		// MVP handle resume
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}

	public void play() {
		logger.debug("Calling GameManager to start a game");
		// MVP handle new game
		gameManager.startGame(this);
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
