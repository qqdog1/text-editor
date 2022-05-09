package name.qd.te.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import name.qd.te.constant.ScreenType;
import name.qd.te.util.MaterialCreator;
import name.qd.te.util.ResourceManager;

public class GithubScreen extends GameScreen {
    private ResourceManager resourceManager = ResourceManager.getInstance();

    private Table table;
    private BitmapFont bitmapFont;
    private ImageButton plusButton;
    private ImageButton cancelButton;
    private ImageButton nextButton;

    private static int STATUS_MAIN = 0;
    private static int STATUS_PLUS_CLICKED = 1;
    private static int STATUS_INPUT_ACCOUNT = 2;
    private static int STATUS_INPUT_REPO = 3;
    private int status = STATUS_MAIN;

    public GithubScreen() {
        bitmapFont = MaterialCreator.getDefaultFont(1 * SCALE_RATE);
        bitmapFont.setColor(Color.BLACK);

        initButton();

        table = new Table();
        table.top().right();
        table.setWidth(WIDTH);
        table.setHeight(HEIGHT);
        table.setDebug(true);

        float plusButtonWidth = WIDTH / 8;
        table.add(plusButton).width(plusButtonWidth).height(plusButtonWidth);
        stage.addActor(table);
    }

    private void initButton() {
        plusButton = MaterialCreator.createImageButton(assetManager.get("pic/plus.png", Texture.class));
        plusButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (status == STATUS_MAIN) {
                    status = STATUS_PLUS_CLICKED;
                }
            }
        });

        cancelButton = MaterialCreator.createImageButton(assetManager.get("pic/cancel.png", Texture.class));
        cancelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                status = STATUS_MAIN;
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
        bitmapFont.draw(spriteBatch, "Github Repos", 3 * SCALE_RATE, HEIGHT - 3 * SCALE_RATE);
        if (status == STATUS_PLUS_CLICKED) {
            spriteBatch.draw(assetManager.get("pic/bg2.png", Texture.class), 0, 0, WIDTH, HEIGHT - 3 * SCALE_RATE - 2 * bitmapFont.getLineHeight());
            bitmapFont.draw(spriteBatch, "Add new Github repo", 3 * SCALE_RATE, HEIGHT - 3 * SCALE_RATE - bitmapFont.getLineHeight());
        }
        spriteBatch.end();
        stage.draw();
    }

    @Override
    public ScreenType currentScreen() {
        return ScreenType.GITHUB;
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
