package by.vit.boombony.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

import by.vit.boombony.helpers.Const;
import by.vit.boombony.texture.AbstractTxLibrary;

public abstract class BaseTxLibrary extends AbstractTxLibrary {

    private Map<String, TextureRegion> textureRegions = new HashMap<>();

    protected TextureRegion createTextureRegion(String textureName, int x, int y, int width, int height) {
        TextureRegion tr = new TextureRegion(createTexture(textureName), x, y, width, height);
        textureRegions.put(textureName, tr);
        return tr;
    }

    protected TextureRegion createTextureRegion(String textureName, int width, int height) {
        TextureRegion tr = new TextureRegion(createTexture(textureName), 0, 0, width, height);
        textureRegions.put(textureName, tr);
        return tr;
    }

    protected TextureRegion createTextureRegion(String prefix, String textureName, int x, int y, int width, int height) {
        TextureRegion tr = new TextureRegion(createTexture(prefix, textureName), x, y, width, height);
        textureRegions.put(textureName, tr);
        return tr;
    }

    protected TextureRegion createTextureRegion(String prefix, String textureName, int width, int height) {
        TextureRegion tr = new TextureRegion(createTexture(prefix, textureName), 0, 0, width, height);
        textureRegions.put(textureName, tr);
        return tr;
    }

    protected void createTextureRegionToCell(String textureName, int x, int y, int width, int height) {

        if (width > Const.TILE_SIZE || height > Const.TILE_SIZE) {
            TextureRegion tr;
            if (width > height) {
                int newHeight = Double.valueOf(height / (((double) width / Const.TILE_SIZE))).intValue();
                tr = new TextureRegion(createTexture(textureName, Const.TILE_SIZE, newHeight));
            } else {
                int newWidth = Double.valueOf(width / (((double) height / Const.TILE_SIZE))).intValue();
                tr = new TextureRegion(createTexture(textureName, newWidth, Const.TILE_SIZE));
            }
            textureRegions.put(textureName, tr);
        } else {
            createTextureRegion(textureName, x, y, width, height);
        }
    }

    private Texture createTexture(String textureName, int width, int height) {

        int newX = width < height ? (height - width) / 2 : 0;
        int newY = height < width ? (width - height) / 2 : 0;

        Pixmap pixmapOld = new Pixmap(Gdx.files.internal(Const.ASSERT_PATH + textureName));
        Pixmap pixmapNew = new Pixmap(Const.TILE_SIZE, Const.TILE_SIZE, pixmapOld.getFormat());
        pixmapNew.drawPixmap(pixmapOld,
                0, 0, pixmapOld.getWidth(), pixmapOld.getHeight(),
                newX, newY, width, height
        );
        return new Texture(pixmapNew);
    }

    protected TextureRegion createTextureRegion(String textureName) {
        return createTextureRegion(textureName, 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
    }

    protected TextureRegion createTextureRegion(String prefix, String textureName) {
        return createTextureRegion(prefix, textureName, 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
    }

    protected Texture createTexture(String file) {
        return new Texture(Gdx.files.internal(Const.ASSERT_PATH + file));
    }

    protected Texture createTexture(String prefix, String file) {
        return new Texture(Gdx.files.internal(Const.ASSERT_PATH + prefix + file));
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
