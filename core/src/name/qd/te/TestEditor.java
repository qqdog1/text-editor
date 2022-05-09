package name.qd.te;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import name.qd.te.constant.ScreenType;
import name.qd.te.screen.ScreenManager;
import name.qd.te.util.ResourceManager;

public class TestEditor extends Game {
	private SpriteBatch batch;
	private AssetManager assetManager;

	private ResourceManager resourceManager = ResourceManager.getInstance();

	@Override
	public void create () {
		batch = new SpriteBatch();

		init();

		ScreenManager screenManager = ScreenManager.getInstance();
		resourceManager.setScreen(screenManager.getScreen(ScreenType.LOGO));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		assetManager.dispose();
	}

	private void init() {
		initAsset();

		resourceManager.setGame(this);
		resourceManager.setAssetManager(assetManager);
		resourceManager.setSpriteBatch(batch);
	}

	private void initAsset() {
		assetManager = new AssetManager();

		assetManager.load("pic/plus.png", Texture.class);
		assetManager.load("pic/bg_color.png", Texture.class);
		assetManager.load("pic/bg2.png", Texture.class);
		assetManager.load("pic/next.png", Texture.class);
		assetManager.load("pic/cancel.png", Texture.class);

		assetManager.finishLoading();
	}
}
