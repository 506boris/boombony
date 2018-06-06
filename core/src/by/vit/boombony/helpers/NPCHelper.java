package by.vit.boombony.helpers;

import com.badlogic.gdx.scenes.scene2d.Stage;

import by.vit.boombony.Logger;
import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.NPC;
import by.vit.boombony.gameworld.BaseTxLibrary;
import by.vit.boombony.gameworld.WorldObjectType;

public class NPCHelper {

    public static NPC createNPC(BaseTxLibrary txLibrary, String name, Stage stage, int x, int y) {
        NPC npc = new NPC(txLibrary.txRegion(name), WorldObjectType.NEUTRAL);
        npc.addListener(new ClickListener() {
            @Override
            public void onClick() {

                Logger.log("Click on NPC");

            }
        });
        stage.addActor(npc);
        MoveHelper.moveObject(npc, x, y);
        return npc;
    }
}