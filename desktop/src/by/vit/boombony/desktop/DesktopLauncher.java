package by.vit.boombony.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import java.io.File;
import java.io.IOException;

import by.vit.boombony.BoombonyGame;
import by.vit.boombony.texture.TexturePack;

public class DesktopLauncher {
    private static final String INPUT_IMAGES = "\\images\\";
    private static final String OUTPUT_PACK = "\\android\\assets";
    private static String BASE_PATH;

    static {
        try {
            BASE_PATH = new File("../../").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) throws Exception {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1528;
        config.height = 768;

        TexturePacker.Settings settings = new TexturePacker.Settings();

        for (TexturePack textureNamePack : TexturePack.values()) {
            initPack(settings, textureNamePack.packName());
        }

        new LwjglApplication(new BoombonyGame(), config);
    }

    private static void initPack(TexturePacker.Settings settings, String name) {
        TexturePacker.process(settings, BASE_PATH + INPUT_IMAGES + name, BASE_PATH + OUTPUT_PACK, name);

    }
}
