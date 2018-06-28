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

    public static TxLibraryPack get() {
        if (pack == null) {
            pack = new TxLibraryPack();
        }
        return pack;
    }

    public TextureAtlas.AtlasRegion tx(String name) {
        for (TextureAtlas textureAtlas : atlasMap.values()) {
            TextureAtlas.AtlasRegion atlasRegion = textureAtlas.findRegion(name);
            if (atlasRegion != null) {
                return atlasRegion;
            }
        }
        return null;
    }

    public Sprite sprite(String name) {
        for (TextureAtlas textureAtlas : atlasMap.values()) {
            TextureAtlas.AtlasRegion atlasRegion = textureAtlas.findRegion(name);
            if (atlasRegion != null) {
                return textureAtlas.createSprite(name);
            }
        }
        return null;
    }

    public void loadTx(TexturePack texturePack) {
        dispose(texturePack);
        atlasMap.put(texturePack, new TextureAtlas(Gdx.files.internal(texturePack.packName() + ATLAS_EXT)));
    }

    public void dispose(TexturePack texturePack) {
        TextureAtlas textureAtlas = this.atlasMap.get(texturePack);
        if (textureAtlas != null) {
            textureAtlas.dispose();
            this.atlasMap.remove(texturePack);
        }
    }
}
