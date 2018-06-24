package by.vit.boombony.scenario.models;

import java.util.List;

public class NpcArray {
    private List<MonsterModel> monsters;
    private List<NpcModel> npc;

    public List<MonsterModel> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterModel> monsters) {
        this.monsters = monsters;
    }

    public List<NpcModel> getNpc() {
        return npc;
    }

    public void setNpc(List<NpcModel> npc) {
        this.npc = npc;
    }
}
