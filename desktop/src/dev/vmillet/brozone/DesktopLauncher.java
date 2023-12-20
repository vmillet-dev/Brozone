package dev.vmillet.brozone;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import dev.vmillet.brozone.factory.GdxGameFactory;

public class DesktopLauncher {
	public static void main (String[] arg) {
		GdxGameFactory factory = new GdxGameFactory();
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("JavaGameGdx");
		new Lwjgl3Application(new Game(factory), config);
	}
}
