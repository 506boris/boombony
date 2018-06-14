package by.vit.boombony.screens.world;

import by.vit.boombony.Logger;
import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.DynamicWorldObject;
import by.vit.boombony.gameobjects.Hero;
import by.vit.boombony.gameobjects.NPC;
import by.vit.boombony.common.map.MoveMapHelper;
import by.vit.boombony.gameobjects.WorldObject;
import by.vit.boombony.helpers.NPCHelper;

public class WorldStage extends BaseWorldStage implements WorldObjectBehavior {
    private Hero hero;
    private NPC oldDukeNpc;
    private NPC shadowNpc;
    private NPC helgaNpc;

    public WorldStage(WorldScreen worldScreen, WorldTxLibrary txLibrary) {
        super(worldScreen, txLibrary);
    }

    @Override
    public DynamicWorldObject getHero() {
        return hero;
    }

    @Override
    public void collision(WorldObject initiator, WorldObject target) {

        CollisionActionType collisionActionType = target.getCollisionActionType();
        switch (collisionActionType) {
            case DIALOG:
                getWorldScreen().getHudStage().getCommonDialog().setVisible(true);
                break;
            case BATTLE:
                // show battle screen
                break;
            case ENTER:
            case PICK_UP:
            case NONE:
                // temporarily do nothing
        }
    }

    @Override
    public void init() {
        super.init();

        hero = new Hero(txLibrary.txRegion("maps/face_Jim.png"));
        hero.addListener(new ClickListener() {
            @Override
            public void onClick() {

                Logger.log("Click on hero");

            }
        });
        addActor(hero);
        MoveMapHelper.moveObject(hero, 0, 0);

        oldDukeNpc = NPCHelper.createNPC(txLibrary, "maps/old_duke.png", this, 3, 0);
        oldDukeNpc.setCollisionActionType(CollisionActionType.DIALOG);
        shadowNpc = NPCHelper.createNPC(txLibrary, "maps/ButtonRage_normal.png", this, 6, 0);
        shadowNpc.setCollisionActionType(CollisionActionType.BATTLE);
        helgaNpc = NPCHelper.createNPC(txLibrary, "maps/Face_witch_Helga.png", this, 9, 7);
        helgaNpc.setCollisionActionType(CollisionActionType.DIALOG);
    }
}
