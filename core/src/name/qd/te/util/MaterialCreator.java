package name.qd.te.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class MaterialCreator {

    public static TextButton createTextButton(Texture btnOff, Texture btnOn, String text) {
        TextureAtlas atlas = new TextureAtlas();
        atlas.addRegion("off", btnOff, 0, 0, btnOff.getWidth(), btnOff.getHeight());
        atlas.addRegion("on", btnOn, 0, 0, btnOn.getWidth(), btnOn.getHeight());

        Skin skin = new Skin(atlas);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = skin.getDrawable("off");
        style.down = skin.getDrawable("on");
        style.checked = skin.getDrawable("on");
        style.font = new BitmapFont();

        return new TextButton(text, style);
    }

    public static TextButton createTextButton(String text, BitmapFont font) {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle(null, null, null, font);
        return new TextButton(text, textButtonStyle);
    }

    public static TextButton createTextButton(Texture texture, String text) {
        return createTextButton(texture, texture, text);
    }

    public static ImageButton createImageButton(Texture texture) {
        return createImageButton(texture, texture);
    }

    public static ImageButton createImageButton(Texture btnOff, Texture btnOn) {
        TextureAtlas atlas = new TextureAtlas();
        atlas.addRegion("off", btnOff, 0, 0, btnOff.getWidth(), btnOff.getHeight());
        atlas.addRegion("on", btnOn, 0, 0, btnOn.getWidth(), btnOn.getHeight());

        Skin skin = new Skin(atlas);

        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = skin.getDrawable("off");
        style.down = skin.getDrawable("on");
        style.checked = skin.getDrawable("on");

        return new ImageButton(style);
    }

    public static Label.LabelStyle getDefaultLabelStyle(Color color, float scale) {
        BitmapFont font = getDefaultFont(scale);
        return new Label.LabelStyle(font, color);
    }

    public static Label.LabelStyle getDefaultLabelStyle(Color color, BitmapFont bitmapFont) {
        return new Label.LabelStyle(bitmapFont, color);
    }

    public static BitmapFont getDefaultFont(float scale) {
        BitmapFont font = new BitmapFont(Gdx.files.internal("font/font.fnt"), Gdx.files.internal("font/font.png"), false);
        font.getData().setScale(scale);
        return font;
    }

    public static TextArea createTextArea(BitmapFont font, Color fontColor, Color backgroundColor) {
        Pixmap pixmap = new Pixmap(1,1, Pixmap.Format.RGB565);
        pixmap.setColor(backgroundColor);
        pixmap.fill();
        TextureRegionDrawable textureRegionDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle(font, fontColor, null, null, textureRegionDrawable);
        return new TextArea("", textFieldStyle);
    }

    public static Animation<TextureRegion> createAnimation(Texture texture, int width, int height, int frames, float duration) {
        return createAnimation(texture, 0, 0, width, height, frames, duration);
    }

    public static Animation<TextureRegion> createAnimation(Texture texture, int width, int height, int frames, float duration, Animation.PlayMode playMode) {
        return createAnimation(texture, 0, 0, width, height, frames, duration, playMode);
    }

    public static Animation<TextureRegion> createAnimation(Texture texture, int x, int y, int width, int height, int frames, float duration) {
        return createAnimation(texture, x, y, width, height, frames, duration, Animation.PlayMode.NORMAL);
    }

    public static Animation<TextureRegion> createAnimation(Texture texture, int x, int y, int width, int height, int frames, float duration, Animation.PlayMode playMode) {
        Array<TextureRegion> array = new Array<>();
        for(int i = 0 ; i < frames ; i++) {
            array.add(new TextureRegion(texture, x + (width * i), y, width, height));
        }
        return new Animation(duration, array, playMode);
    }

    public static Animation<Sprite> createRotationAnimation(Texture texture, float angle, int frames, float duration, Animation.PlayMode playMode) {
        Array<Sprite> array = new Array<>();
        float singleAngle = angle / (frames - 1);
        float startAngle = -((frames / 2) * singleAngle);
        if(frames % 2 == 0) {
            startAngle -= singleAngle / 2f;
        }
        for(int i = 0 ; i < frames ; i++) {
            Sprite sprite = new Sprite(texture);
            sprite.rotate(startAngle + i * singleAngle);
            array.add(sprite);
        }
        return new Animation(duration, array, playMode);
    }
}
