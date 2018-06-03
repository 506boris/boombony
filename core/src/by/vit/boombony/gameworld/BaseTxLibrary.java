package by.vit.boombony.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

import by.vit.boombony.helpers.Const;

public abstract class BaseTxLibrary extends AbstractTxLibrary {

    private Map<String, TextureRegion> textureRegions = new HashMap<>();

    protected void createTextureRegion(String textureName, int x, int y, int width, int height) {
        TextureRegion tr = new TextureRegion(createTexture(textureName), x, y, width, height);
        textureRegions.put(textureName, tr);
    }

    protected void createTextureRegion(String textureName) {
        createTextureRegion(textureName, 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
    }

    protected Texture createTexture(String file) {
        return new Texture(Gdx.files.internal(Const.ASSERT_PATH + file));
    }

    public TextureRegion txRegion(String textureName) {
        return textureRegions.get(textureName);
    }

    @Override
    public void dispose() {
        for (TextureRegion tr : textureRegions.values()) {
            tr.getTexture().dispose();
            textureRegions.remove(tr);
        }
    }
}
