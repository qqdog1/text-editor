package name.qd.te.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import name.qd.te.constant.ScreenType;
import name.qd.te.util.MaterialCreator;
import name.qd.te.util.ResourceManager;

public class AddRepoScreen extends GameScreen {
    private ResourceManager resourceManager = ResourceManager.getInstance();

    private BitmapFont bitmapFont;
    private TextArea inputTextArea;
    private TextButton nextButton;
    private TextButton cancelButton;

    private final int STATUS_ACCOUNT = 0;
    private final int STATUS_REPO = 1;
    private final int STATUS_TOKEN = 2;
    private int status = STATUS_ACCOUNT;

    public AddRepoScreen() {
        bitmapFont = MaterialCreator.getDefaultFont(1 * SCALE_RATE);
        bitmapFont.setColor(Color.BLACK);

        initButton();
        initTable();
    }

    private void initButton() {
        cancelButton = MaterialCreator.createTextButton("Cancel", bitmapFont);
        cancelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toNextScreen(ScreenType.GITHUBREPO);
            }
        });
        nextButton = MaterialCreator.createTextButton("Next", bitmapFont);
        nextButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                switch (status) {
                    case STATUS_ACCOUNT:
                        status = STATUS_REPO;
                        // get account's repos

                        break;
                    case STATUS_REPO:
                        status = STATUS_TOKEN;
                        // add repos

                        break;
                    case STATUS_TOKEN:
                        break;
                }
            }
        });
    }

    private void initTable() {
        Table table = new Table();
        table.top().center();
        table.setWidth(WIDTH);
        table.setHeight(HEIGHT);
        table.setDebug(true);

        table.bottom().left();
        table.setHeight(nextButton.getHeight() * 2);
        table.setDebug(true);
        table.add(cancelButton).width(WIDTH / 2).height(nextButton.getHeight() * 2);
        table.add(nextButton).width((WIDTH / 2)).height(nextButton.getHeight() * 2);
        stage.addActor(table);
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
        switch (status) {
            case STATUS_ACCOUNT:
                bitmapFont.draw(spriteBatch, "input github account: ", 3 * SCALE_RATE, HEIGHT * 2 / 3 + bitmapFont.getLineHeight());

                break;
            case STATUS_REPO:
                bitmapFont.draw(spriteBatch, "choose a repo: ", 3 * SCALE_RATE, HEIGHT * 2 / 3 + bitmapFont.getLineHeight());

                break;
            case STATUS_TOKEN:
                bitmapFont.draw(spriteBatch, "input personal access token : ", 3 * SCALE_RATE, HEIGHT * 2 / 3 + bitmapFont.getLineHeight());

                break;
        }
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
