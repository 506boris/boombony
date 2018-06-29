package by.vit.boombony.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;
import java.util.Map;

public class TxLibraryPack {
    private static final String ATLAS_EXT = ".atlas";
    private static TxLibraryPack pack;
    private Map<TexturePack, TextureAtlas> atlasMap = new HashMap<>();

    private TxLibraryPack() {
    }

    private static TxLibraryPack get() {
        if (pack == null) {
            pack = new TxLibraryPack();
        }
        return pack;
    }

    public static TextureAtlas.AtlasRegion tx(String name) {
        for (TextureAtlas textureAtlas : get().atlasMap.values()) {
            TextureAtlas.AtlasRegion atlasRegion = textureAtlas.findRegion(name);
            if (atlasRegion != null) {
                return atlasRegion;
            }
        }
        return null;
    }

    public static Sprite sprite(String name) {
        for (TextureAtlas textureAtlas : get().atlasMap.values()) {
            TextureAtlas.AtlasRegion atlasRegion = textureAtlas.findRegion(name);
            if (atlasRegion != null) {
                return textureAtlas.createSprite(name);
            }
        }
        return null;
    }

    public static void loadTx(TexturePack... texturePacks) {
        for (TexturePack texturePack : texturePacks) {
            dispose(texturePack);
            get().atlasMap.put(texturePack, new TextureAtlas(Gdx.files.internal(texturePack.packName() + ATLAS_EXT)));
        }
    }

    public static void dispose(TexturePack... texturePacks) {
        for (TexturePack texturePack : texturePacks) {
            TextureAtlas textureAtlas = get().atlasMap.get(texturePack);
            if (textureAtlas != null) {
                textureAtlas.dispose();
                get().atlasMap.remove(texturePack);
            }
        }
    }
}
