package name.qd.te.screen;

import java.util.HashMap;
import java.util.Map;

import name.qd.te.constant.ScreenType;

public class ScreenManager {
    private static ScreenManager instance = new ScreenManager();

    private Map<ScreenType, GameScreen> map = new HashMap<>();

    public static ScreenManager getInstance() {
        return instance;
    }

    private ScreenManager() {
    }

    public GameScreen getScreen(ScreenType screenType) {
        if (!map.containsKey(screenType)) {
            switch (screenType) {
                case LOGO:
                    map.put(screenType, new LogoScreen());
                    break;
                case GITHUB:
                    map.put(screenType, new GithubScreen());
                    break;
                case EDITOR:
                    map.put(screenType, new EditorScreen());
                    break;
            }
        }
        return map.get(screenType);
    }

    public void closeScreen(ScreenType screenType) {
        switch (screenType) {
            case LOGO:
                map.remove(screenType).dispose();
                break;
            // 常用的screen 留著instance
            case GITHUB:
            case EDITOR:
        }
    }
}