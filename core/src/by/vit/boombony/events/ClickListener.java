package by.vit.boombony.events;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public abstract class ClickListener extends InputListener {
    private boolean wasClick = false;

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        this.wasClick = true;
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        if (wasClick) {
            onClick();
        }
    }

    public abstract void onClick();
}
