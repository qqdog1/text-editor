package name.qd.te.util;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ResourceManager {
    private static ResourceManager instance = new ResourceManager();
    private Game game;
    private SpriteBatch spriteBatch;
    private AssetManager assetManager;

    public static ResourceManager getInstance() {
        return instance;
    }

    private ResourceManager() {
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setScreen(Screen screen) {
        game.setScreen(screen);
    }
}
