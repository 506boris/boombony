package by.vit.boombony.maps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Runner {
    public static void main(String [] args) {
        Runner r = new Runner();
        r.load();
//        r.save();
    }


    public void load() {
        GameMap gameMap = MapLoader.get().load("2");
        System.out.println(gameMap);
    }

    public void save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String filename = "1.map";
        GameMap gameMap = new GameMap();
        gameMap.setCells(GameMap.init(6, 6));
        String json = gson.toJson(gameMap);
        System.out.println(json);

        FileLoader.write(filename, json);
    }

}
