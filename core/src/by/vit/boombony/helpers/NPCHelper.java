package by.vit.boombony.helpers;

import by.vit.boombony.Logger;
import by.vit.boombony.common.map.MoveMapHelper;
import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.NPC;
import by.vit.boombony.gameworld.BaseTxLibrary;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.screens.world.WorldStage;

public class NPCHelper {

    public static NPC createNPC(BaseTxLibrary txLibrary, String name, WorldStage stage, int x, int y) {
        NPC npc = new NPC(txLibrary.txRegion(name), WorldObjectType.NEUTRAL);
        npc.addListener(new ClickListener() {
            @Override
            public void onClick() {

                Logger.log("Click on NPC");

            }
        });
        stage.addActor(npc);
        MoveMapHelper.moveObject(npc, x, y);
        npc.setWorldObjectBehavior(stage);
        return npc;
    }
}
