package by.vit.boombony.gameworld;

public class WorldState {
    private ActType currentAct = ActType.HERO;

    // передаем ход следующему актеру
    public ActType nextAct() {
        int actLength = ActType.values().length;
        int nextActOrdinal = currentAct.ordinal() + 1;
        if(nextActOrdinal > actLength - 1) {
            nextActOrdinal = 0;
        }
        currentAct = ActType.values()[nextActOrdinal];
        return currentAct;
    }







    private static WorldState worldState;
    private WorldState() {}
    public static WorldState get() {
        if (worldState == null) {
            worldState = new WorldState();
        }
        return worldState;
    }
}
