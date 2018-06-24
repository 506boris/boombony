package by.vit.boombony.scenario.maker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MapLoader {
    private static MapLoader INSTANCE;
    private static final String MAP_EXT = ".map";
    private Gson gson;

    private MapLoader() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public static MapLoader get() {
        if (INSTANCE == null) {
            INSTANCE = new MapLoader();
        }
        return INSTANCE;
    }

    public GameMap load(String level) {

        String jsonMap = GdxFileLoader.read(level + MAP_EXT);
        GameMap gameMap = gson.fromJson(jsonMap, GameMap.class);

        return gameMap;
    }
}
