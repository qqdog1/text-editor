package name.qd.te.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import name.qd.te.constant.ScreenType;
import name.qd.te.util.ResourceManager;

public abstract class GameScreen implements Screen {
    public static final float SCALE_RATE = 1f;
    public static final float WIDTH = 360 * SCALE_RATE;
    public static final float HEIGHT = 640 * SCALE_RATE;
//    public static final float SCREEN_WIDTH = WIDTH / Constant.PIXEL_PER_METER;
//    public static final float SCREEN_HEIGHT = HEIGHT / Constant.PIXEL_PER_METER;

    protected final SpriteBatch spriteBatch;
    protected final AssetManager assetManager;
    protected final Stage stage;

    private final OrthographicCamera camera;
    private final Viewport viewport;

    protected GameScreen() {
        spriteBatch = ResourceManager.getInstance().getSpriteBatch();
        assetManager = ResourceManager.getInstance().getAssetManager();

        camera = new OrthographicCamera();
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        stage = new Stage(viewport, spriteBatch);

        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void render(float delta) {
        handleInput();

        camera.update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    abstract void handleInput();

    abstract ScreenType currentScreen();

    void toNextScreen(ScreenType screenType) {
        ScreenManager.getInstance().closeScreen(currentScreen());
        ResourceManager.getInstance().setScreen(ScreenManager.getInstance().getScreen(screenType));
    }

    void quickLog(String title, Object ... objects) {
        StringBuilder sb = new StringBuilder();
        for(Object obj : objects) {
            sb.append(obj).append(":");
        }
        Gdx.app.log(title, sb.toString());
    }
}
