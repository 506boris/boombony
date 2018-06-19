package by.vit.boombony.screens.world.dialogs;

import by.vit.boombony.common.widgets.CommonDialog;
import by.vit.boombony.common.widgets.DialogParams;
import by.vit.boombony.gameobjects.WorldObject;

public class StartBattleDialog extends CommonDialog {
    private WorldObject initiator;
    private WorldObject target;

    public StartBattleDialog(DialogParams params) {
        super(params);
    }

    public void setWorldObjects(WorldObject initiator, WorldObject target) {
        this.initiator = initiator;
        this.target = target;
    }

    public WorldObject getInitiator() {
        return initiator;
    }

    public WorldObject getTarget() {
        return target;
    }
}
