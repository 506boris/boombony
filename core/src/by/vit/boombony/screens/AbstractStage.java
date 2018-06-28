package by.vit.boombony.screens;

import com.badlogic.gdx.scenes.scene2d.Stage;

import by.vit.boombony.gameworld.Initializable;

public abstract class AbstractStage extends Stage implements Initializable {

    public AbstractStage() {
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
