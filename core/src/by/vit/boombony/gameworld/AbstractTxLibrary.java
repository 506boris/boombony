package by.vit.boombony.gameworld;

import by.vit.boombony.helpers.Const;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTxLibrary implements TxLibrary{
    private List<Texture> textures = new ArrayList();


    protected Texture createTexture(String file) {
        Texture texture = new Texture(Gdx.files.internal(Const.ASSERT_PATH + file));
        textures.add(texture);
        return texture;
    }


    @Override
    public void dispose() {
        for (Texture texture : textures) {
            texture.dispose();
        }
    }
}
