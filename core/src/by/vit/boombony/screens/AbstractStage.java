package by.vit.boombony.screens;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class AbstractStage<T> extends Stage {
    protected T txLibrary;

    public AbstractStage(T txLibrary) {
        this.txLibrary = txLibrary;
        init();
    }

    public abstract void init();

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
