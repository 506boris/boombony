package by.vit.boombony;

import com.badlogic.gdx.Gdx;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private static final Map<String, Long> MAP = Collections.synchronizedMap(new HashMap<>());

    public static void logWithMark(String textKey) {
        if (MAP.containsKey(textKey)) {
            Long preTime = MAP.get(textKey);
            Gdx.app.log("[******]", textKey + " [duration]-> " + String.valueOf(System.currentTimeMillis() - preTime));
            MAP.remove(textKey);
            return;
        }
        MAP.put(textKey, System.currentTimeMillis());
        Gdx.app.log("[******]", textKey);
    }

    public static void log(String textKey) {
        Gdx.app.log("[******]", textKey);
    }

}
