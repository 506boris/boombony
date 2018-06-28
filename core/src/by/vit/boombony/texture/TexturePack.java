package by.vit.boombony.texture;

public enum TexturePack {
    BATTLE,
    GLOBAL,
    MENU,
    WORLD;

    public String packName() {
        return this.name().toLowerCase();
    }
}
