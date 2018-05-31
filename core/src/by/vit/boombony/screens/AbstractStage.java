package by.vit.boombony.screens;

import com.badlogic.gdx.scenes.scene2d.Stage;

import by.vit.boombony.gameworld.Initializable;
import by.vit.boombony.gameworld.TxLibrary;

public abstract class AbstractStage<T extends TxLibrary> extends Stage implements Initializable {
    protected T txLibrary;

    public AbstractStage(T txLibrary) {
        this.txLibrary = txLibrary;
    }

    public void loadTx() {
        this.txLibrary.load();
    }

    public void update(float delta) {
        super.act(delta);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return super.touchUp(screenX, screenY, pointer, button);
    }

//    public Actor findActor(int x, int y, boolean touchable) {
//        for (Actor actor : getActors()) {
//            if (actor.hit(x, y, touchable) != null) {
//                return actor;
//            }
//        }
//        return null;
//    }
}
