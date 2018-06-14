package by.vit.boombony.screens.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import by.vit.boombony.Logger;
import by.vit.boombony.common.widgets.CommonDialog;
import by.vit.boombony.common.widgets.DialogParams;
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
    private CommonDialog commonDialog;

    public WorldStage(WorldScreen worldScreen, WorldTxLibrary txLibrary) {
        super(worldScreen, txLibrary);
    }

    @Override
    public DynamicWorldObject getHero() {
        return hero;
    }

    @Override
    public void collision(WorldObject initiator, WorldObject target) {
        commonDialog.setVisible(true);
    }

    @Override
    public void init() {
        super.init();

        DialogParams params = new DialogParams();
        params.setBackgroundRegion(txLibrary.dialogBackground);
        params.setEnabledOkButtonRegion(txLibrary.dialogOkEnabled);
        params.setPressedOkButtonRegion(txLibrary.dialogOkPressed);
        params.setBitmapFont(new BitmapFont());
        params.setTitleFontColor(Color.BLACK);

        commonDialog = new CommonDialog(params);
        commonDialog.init();
        addActor(commonDialog);

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
        shadowNpc = NPCHelper.createNPC(txLibrary, "maps/ButtonRage_normal.png", this, 6, 0);
        helgaNpc = NPCHelper.createNPC(txLibrary, "maps/Face_witch_Helga.png", this, 9, 7);
    }
}
