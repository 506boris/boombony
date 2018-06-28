package by.vit.boombony.screens.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import by.vit.boombony.common.widgets.ButtonParams;
import by.vit.boombony.common.widgets.DialogParams;
import by.vit.boombony.gameobjects.DynamicWorldObject;
import by.vit.boombony.gameobjects.Hero;
import by.vit.boombony.gameobjects.NPC;
import by.vit.boombony.common.map.MoveMapHelper;
import by.vit.boombony.gameobjects.WorldObject;
import by.vit.boombony.helpers.NPCHelper;
import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.battle.BattleScreen;
import by.vit.boombony.screens.world.dialogs.StartBattleDialog;
import by.vit.boombony.texture.TxLibraryPack;
import by.vit.boombony.texture.WorldTileMapTxLibrary;

public class WorldStage extends BaseWorldStage implements WorldObjectBehavior {
    private Hero hero;
    private NPC severusNpc;
    private NPC shadowNpc;
    private NPC helgaNpc;
    private NPC vikingHouse;
    private NPC vikingLighthouse;
    private NPC vikingMakinghidesMachine;
    private NPC vikingMill;
    private NPC volkanNpc;
    private NPC werewolfNpc;
    private NPC whiteBeerNpc;
    private NPC witchEtteilaNpc;
    private NPC witchHestraNpc;
    private NPC witchKimoraNpc;
    private NPC witchMagnetNpc;
    private NPC witchMartaoldNpc;
    private NPC witchWilmaNpc;
    private NPC yanikUpNpc;
    private NPC yodurNpc;
    private NPC yotunNpc;
    private NPC zelgadisNpc;
    private NPC zloboglazNpc;
    private StartBattleDialog startBattleDialog;

    public WorldStage(WorldScreen worldScreen, WorldTileMapTxLibrary txLibrary) {
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
                startBattleDialog.setWorldObjects(initiator, target);
                startBattleDialog.setVisible(true);
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

        DialogParams params = new DialogParams();
        params.setBackgroundRegion(TxLibraryPack.get().tx("dialog_bg_top"));
        params.setBitmapFont(new BitmapFont());
        params.setTitleFontColor(Color.BLACK);

        ButtonParams buttonParams = new ButtonParams();
        buttonParams.setEnabledButtonRegion(TxLibraryPack.get().tx("button_ok_enabled"));
        buttonParams.setPressedButtonRegion(TxLibraryPack.get().tx("button_ok_pressed"));

        startBattleDialog = new StartBattleDialog(params);
        startBattleDialog.activateCloseButton();
        startBattleDialog.addButtonListener(buttonParams, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenManager screenManager = getWorldScreen().getScreenManager();
                screenManager.show(new BattleScreen(screenManager, startBattleDialog.getInitiator(), startBattleDialog.getTarget()));
            }
        });
        addActor(startBattleDialog);

        hero = new Hero(TxLibraryPack.get().tx("face_Jim"));
        addActor(hero);
        MoveMapHelper.moveObject(hero, 0, 0);

        severusNpc = NPCHelper.createNPC("face_Severus", this, 3, 0);
        severusNpc.setCollisionActionType(CollisionActionType.DIALOG);
        shadowNpc = NPCHelper.createNPC("ButtonRage_normal", this, 6, 0);
        shadowNpc.setCollisionActionType(CollisionActionType.BATTLE);
        helgaNpc = NPCHelper.createNPC("Face_witch_Helga", this, 9, 7);
        helgaNpc.setCollisionActionType(CollisionActionType.DIALOG);

        // houses
        vikingHouse = NPCHelper.createNPC("face_viking_house_small_3_autumn", this, 2, 4);
        vikingHouse.setCollisionActionType(CollisionActionType.ENTER);
        vikingLighthouse = NPCHelper.createNPC("face_viking_lighthouse", this, 13, 6);
        vikingLighthouse.setCollisionActionType(CollisionActionType.ENTER);
        vikingMakinghidesMachine = NPCHelper.createNPC("face_viking_makinghides_machine", this, 17, 14);
        vikingMakinghidesMachine.setCollisionActionType(CollisionActionType.ENTER);
        vikingMill = NPCHelper.createNPC("face_viking_mill", this, 21, 20);
        vikingMill.setCollisionActionType(CollisionActionType.ENTER);

        // dialog
        volkanNpc = NPCHelper.createNPC("face_Volkan", this, 10, 20);
        volkanNpc.setCollisionActionType(CollisionActionType.DIALOG);
        werewolfNpc = NPCHelper.createNPC("face_werewolf", this, 12, 15);
        werewolfNpc.setCollisionActionType(CollisionActionType.DIALOG);
        witchHestraNpc = NPCHelper.createNPC("face_witch_Hestra", this, 14, 15);
        witchHestraNpc.setCollisionActionType(CollisionActionType.DIALOG);
        yodurNpc = NPCHelper.createNPC("face_Yodur", this, 15, 14);
        yodurNpc.setCollisionActionType(CollisionActionType.DIALOG);

        // battle
        whiteBeerNpc = NPCHelper.createNPC("face_white_beer", this, 20, 20);
        whiteBeerNpc.setCollisionActionType(CollisionActionType.BATTLE);
        witchEtteilaNpc = NPCHelper.createNPC("face_witch_Etteila", this, 4, 21);
        witchEtteilaNpc.setCollisionActionType(CollisionActionType.BATTLE);
        witchKimoraNpc = NPCHelper.createNPC("face_Witch_Kimora", this, 8, 24);
        witchKimoraNpc.setCollisionActionType(CollisionActionType.BATTLE);
        witchMagnetNpc = NPCHelper.createNPC("Face_witch_magnet", this, 16, 27);
        witchMagnetNpc.setCollisionActionType(CollisionActionType.BATTLE);
        witchMartaoldNpc = NPCHelper.createNPC("face_witch_martaold", this, 23, 29);
        witchMartaoldNpc.setCollisionActionType(CollisionActionType.BATTLE);
        witchWilmaNpc = NPCHelper.createNPC("face_witch_Wilma", this, 15, 1);
        witchWilmaNpc.setCollisionActionType(CollisionActionType.BATTLE);
        yanikUpNpc = NPCHelper.createNPC("face_Yanik_up", this, 16, 5);
        yanikUpNpc.setCollisionActionType(CollisionActionType.BATTLE);
        yotunNpc = NPCHelper.createNPC("face_yotun", this, 21, 3);
        yotunNpc.setCollisionActionType(CollisionActionType.BATTLE);
        zelgadisNpc = NPCHelper.createNPC("face_zelgadis", this, 26, 5);
        zelgadisNpc.setCollisionActionType(CollisionActionType.BATTLE);
        zloboglazNpc = NPCHelper.createNPC("face_zloboglaz", this, 24, 1);
        zloboglazNpc.setCollisionActionType(CollisionActionType.BATTLE);


    }
}
