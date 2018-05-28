package by.vit.boombony.gameworld.path;

import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.ScenarioHelper;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Main {
    private static final String PREFIX = "g:/gdxlib/boombony/project/android/assets/";

    public static void main(String[] args) {
        TiledMap tiledMap = new TmxMapLoader().load(PREFIX + ScenarioHelper.getScenario0().getTmxMapPath());

        SearchPathUtil.get().search((TiledMapTileLayer) tiledMap.getLayers().get(WorldLayerType.OBJECTS.getName()),
                new Coo(0, 3), new Coo(9, 3));
    }
}
