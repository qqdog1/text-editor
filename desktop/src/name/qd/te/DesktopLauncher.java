package name.qd.te;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import name.qd.te.TestEditor;
import name.qd.te.screen.GameScreen;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowSizeLimits((int) GameScreen.WIDTH, (int) GameScreen.HEIGHT,
				2 * (int) GameScreen.WIDTH, 2 * (int) GameScreen.HEIGHT);
		config.setTitle("text-editor");
		new Lwjgl3Application(new TestEditor(), config);
	}
}
