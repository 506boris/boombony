package by.vit.boombony.screens.world;

import by.vit.boombony.Logger;
import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.DynamicWorldObject;
import by.vit.boombony.gameobjects.Hero;
import by.vit.boombony.gameobjects.Person;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.MoveHelper;

public class WorldStage extends BaseWorldStage {
    private Hero hero;
    private Person oldDukePerson;
    private Person shadowPerson;
    private Person helgaPerson;

    public WorldStage(WorldScreen worldScreen, WorldTxLibrary txLibrary) {
        super(worldScreen, txLibrary);
    }

    @Override
    public DynamicWorldObject getHero() {
        return hero;
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
        MoveHelper.moveObject(hero, 0, 0);

        oldDukePerson = new Person(txLibrary.txRegion("maps/old_duke.png"), WorldObjectType.NEUTRAL);
        oldDukePerson.addListener(new ClickListener() {
            @Override
            public void onClick() {

                Logger.log("Click on old Duke");

            }
        });
        addActor(oldDukePerson);
        MoveHelper.moveObject(oldDukePerson, 3, 0);

        shadowPerson = new Person(txLibrary.txRegion("maps/ButtonRage_normal.png"), WorldObjectType.NEUTRAL);
        shadowPerson.addListener(new ClickListener() {
            @Override
            public void onClick() {

                Logger.log("Click on old shadowPerson");

            }
        });
        addActor(shadowPerson);
        MoveHelper.moveObject(shadowPerson, 6, 0);

        helgaPerson = new Person(txLibrary.txRegion("maps/Face_witch_Helga.png"), WorldObjectType.NEUTRAL);
        helgaPerson.addListener(new ClickListener() {
            @Override
            public void onClick() {

                Logger.log("Click on old shadowPerson");

            }
        });
        addActor(helgaPerson);
        MoveHelper.moveObject(helgaPerson, 9, 7);
    }
}
