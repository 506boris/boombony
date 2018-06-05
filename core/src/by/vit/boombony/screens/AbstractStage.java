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

    public void render(float delta) {
        super.act(delta);
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
