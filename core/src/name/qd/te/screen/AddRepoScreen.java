package name.qd.te.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import name.qd.te.constant.ScreenType;
import name.qd.te.util.MaterialCreator;
import name.qd.te.util.ResourceManager;

public class AddRepoScreen extends GameScreen {
    private ResourceManager resourceManager = ResourceManager.getInstance();

    private Table table;
    private BitmapFont bitmapFont;
    private TextArea inputTextArea;
    private ImageButton cancelButton;
    private ImageButton nextButton;

    public AddRepoScreen() {
        bitmapFont = MaterialCreator.getDefaultFont(1 * SCALE_RATE);
        bitmapFont.setColor(Color.BLACK);

        initButton();

        table = new Table();
        table.setDebug(true);
    }

    private void initButton() {
        cancelButton = MaterialCreator.createImageButton(assetManager.get("pic/cancel.png", Texture.class));
        cancelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toNextScreen(ScreenType.SHOWREPO);
            }
        });
        nextButton = MaterialCreator.createImageButton(assetManager.get("pic/next.png", Texture.class));
        nextButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
    }

    @Override
    void handleInput() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(assetManager.get("pic/bg_color.png", Texture.class), 0, 0, WIDTH, HEIGHT);
        bitmapFont.draw(spriteBatch, "Add Repos", 3 * SCALE_RATE, HEIGHT - 3 * SCALE_RATE);
        spriteBatch.end();
        stage.draw();
    }

    @Override
    ScreenType currentScreen() {
        return ScreenType.ADDREPO;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
