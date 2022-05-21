package name.qd.te.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import name.qd.te.constant.ScreenType;
import name.qd.te.util.MaterialCreator;

public class LogoScreen extends GameScreen {
    private Animation animation;
    private Texture echohole;
    private float stateTime;

    private float scaleWidth;
    private float scaleHeight;
    private float x;
    private float y;

    public LogoScreen() {
        // 因為圖片一格是256 * 256
        animation = MaterialCreator.createAnimation(new Texture("pic/logo.png"),256, 256, 5, 0.3f);
        echohole = new Texture("pic/echohole.png");

        scaleWidth = 256 * SCALE_RATE;
        scaleHeight = 256 * SCALE_RATE;
        x = (WIDTH - scaleWidth) / 2;
        y = HEIGHT / 2 - scaleHeight / 3;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stateTime += delta;

        if(stateTime >= 5) {
            toNextScreen(ScreenType.GITHUBREPO);
        }

        stage.draw();

        spriteBatch.begin();
        spriteBatch.draw((TextureRegion)animation.getKeyFrame(stateTime), x, y, scaleWidth, scaleHeight);
        if(animation.isAnimationFinished(stateTime)) {
            spriteBatch.draw(echohole, (WIDTH - echohole.getWidth() * SCALE_RATE) / 2, y - echohole.getHeight() * SCALE_RATE, echohole.getWidth() * SCALE_RATE, echohole.getHeight() * SCALE_RATE);
        }
        spriteBatch.end();
    }

    protected void handleInput() {
        if(Gdx.input.justTouched() && stateTime >= 2) {
            toNextScreen(ScreenType.GITHUBREPO);
        }
    }

    @Override
    protected ScreenType currentScreen() {
        return ScreenType.LOGO;
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
        Gdx.app.log("Disposed", "LogoScreen");
    }
}
