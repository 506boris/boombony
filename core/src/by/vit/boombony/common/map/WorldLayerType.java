package by.vit.boombony.common.map;

public enum WorldLayerType {
    GROUND("ground"),
    OBJECTS("objects"),
    CURSOR("cursor");

    private String name;

    WorldLayerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
