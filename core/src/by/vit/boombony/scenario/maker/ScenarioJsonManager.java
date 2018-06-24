package by.vit.boombony.scenario.maker;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.util.ArrayList;
import java.util.List;

import by.vit.boombony.helpers.Coo;
import by.vit.boombony.scenario.models.LevelInfo;
import by.vit.boombony.scenario.models.LevelScenario;
import by.vit.boombony.scenario.models.MonsterModel;
import by.vit.boombony.scenario.models.NpcModel;
import by.vit.boombony.scenario.models.NpcArray;
import by.vit.boombony.scenario.models.ReplicaDto;

/**
 * Just for create json scenarios
 */
public final class ScenarioJsonManager {

    private static final Json JSON = new Json();
    private static final boolean PRETTY = true;

    static {
        JSON.setOutputType(JsonWriter.OutputType.json);
    }

    public static String createJsonScenario() {
        LevelScenario levelScenario = new LevelScenario();
        levelScenario.setTmxMapPath("maps/level1.tmx");
        levelScenario.setLevelInfo(createLevelInfo());

        String result;
        if (PRETTY) {
            result = JSON.prettyPrint(levelScenario);
        } else {
            result = JSON.toJson(levelScenario);
        }
        System.out.print(result);
        return result;
    }

    private static LevelInfo createLevelInfo() {
        LevelInfo levelInfo = new LevelInfo();
        levelInfo.setLevelNumber(1);
        levelInfo.setLevelName("Start journey");
        levelInfo.setLevelDescription("Start description");
        levelInfo.setStartPoint(Coo.zero());
        levelInfo.setNpcArray(createNpcInfoArray());

        return levelInfo;
    }

    private static NpcArray createNpcInfoArray() {
        NpcArray npcArray = new NpcArray();
        npcArray.setMonsters(createMonsters());
        npcArray.setNpc(createNpc());
        return npcArray;
    }

    private static List<NpcModel> createNpc() {
        List<NpcModel> models = new ArrayList<>();
        models.add(createNPC("face_Severus", "face_Severus", "face_Severus.png", new Coo(106, 147), new Coo(3, 0), new ReplicaDto()));
        models.add(createNPC("face_Jim", "face_Jim", "face_Jim.png", new Coo(106, 147), new Coo(24, 1), new ReplicaDto()));
        models.add(createNPC("ButtonRage_normal", "ButtonRage_normal", "ButtonRage_normal.png", new Coo(77, 74), new Coo(6, 0), new ReplicaDto()));

        models.add(createNPC("face_viking_house_small_3_autumn", "face_viking_house_small_3_autumn", "face_viking_house_small_3_autumn.png", new Coo(106, 147), new Coo(2, 4), new ReplicaDto()));
        models.add(createNPC("face_viking_lighthouse", "face_viking_lighthouse", "face_viking_lighthouse.png", new Coo(106, 147), new Coo(13, 6), new ReplicaDto()));
        models.add(createNPC("face_viking_makinghides_machine", "face_viking_makinghides_machine", "face_viking_makinghides_machine.png", new Coo(106, 147), new Coo(17, 14), new ReplicaDto()));
        models.add(createNPC("face_viking_mill", "face_viking_mill", "face_viking_mill.png", new Coo(106, 147), new Coo(21, 20), new ReplicaDto()));
        models.add(createNPC("face_Volkan", "face_Volkan", "face_Volkan.png", new Coo(106, 147), new Coo(10, 20), new ReplicaDto()));

        models.add(createNPC("face_Yanik_up", "face_Yanik_up", "face_Yanik_up.png", new Coo(106, 147), new Coo(16, 5), new ReplicaDto()));
        models.add(createNPC("face_Yodur", "face_Yodur", "face_Yodur.png", new Coo(106, 147), new Coo(15, 14), new ReplicaDto()));
        models.add(createNPC("face_yotun", "face_yotun", "face_yotun.png", new Coo(106, 147), new Coo(21, 3), new ReplicaDto()));
        models.add(createNPC("face_zelgadis", "face_zelgadis", "face_zelgadis.png", new Coo(106, 147), new Coo(26, 5), new ReplicaDto()));
        models.add(createNPC("face_zloboglaz", "face_zloboglaz", "face_zloboglaz.png", new Coo(106, 147), new Coo(24, 1), new ReplicaDto()));
        return models;
    }

    private static NpcModel createNPC(String name, String desc, String texture, Coo size, Coo startPos, ReplicaDto replica) {
        NpcModel dto = new NpcModel();
        dto.setName(name);
        dto.setDescription(desc);
        dto.setSize(size);
        dto.setStartPosition(startPos);
        dto.setMapTextureName(texture);
        dto.setBigTextureName(texture);
        dto.setReplicaDto(replica);
        return dto;
    }

    private static MonsterModel createMonster(String name, String desc, String texture, Coo size, Coo startPos, ReplicaDto replica) {
        MonsterModel dto = new MonsterModel();
        dto.setLevel(1);
        dto.setName(name);
        dto.setDescription(desc);
        dto.setSize(size);
        dto.setStartPosition(startPos);
        dto.setMapTextureName(texture);
        dto.setBigTextureName(texture);
        dto.setReplicaDto(replica);
        return dto;
    }

    private static List<MonsterModel> createMonsters() {
        List<MonsterModel> models = new ArrayList<>();
        models.add(createMonster("Face_witch_Helga", "Face_witch_Helga", "Face_witch_Helga.png", new Coo(106, 147), new Coo(9, 7), new ReplicaDto()));
        models.add(createMonster("face_werewolf", "face_werewolf", "face_werewolf.png", new Coo(106, 147), new Coo(12, 15), new ReplicaDto()));
        models.add(createMonster("face_white_beer", "face_white_beer", "face_white_beer.png", new Coo(106, 147), new Coo(20, 20), new ReplicaDto()));

        models.add(createMonster("face_witch_Hestra", "face_witch_Hestra", "face_witch_Hestra.png", new Coo(106, 147), new Coo(14, 15), new ReplicaDto()));
        models.add(createMonster("face_witch_Etteila", "face_witch_Etteila", "face_witch_Etteila.png", new Coo(106, 147), new Coo(4, 21), new ReplicaDto()));
        models.add(createMonster("face_Witch_Kimora", "face_Witch_Kimora", "face_Witch_Kimora.png", new Coo(106, 147), new Coo(8, 24), new ReplicaDto()));
        models.add(createMonster("Face_witch_magnet", "Face_witch_magnet", "Face_witch_magnet.png", new Coo(106, 147), new Coo(16, 27), new ReplicaDto()));
        models.add(createMonster("face_witch_martaold", "face_witch_martaold", "face_witch_martaold.png", new Coo(106, 147), new Coo(23, 29), new ReplicaDto()));
        models.add(createMonster("face_witch_Wilma", "face_witch_Wilma", "face_witch_Wilma.png", new Coo(106, 147), new Coo(15, 1), new ReplicaDto()));

        return models;
    }
}
