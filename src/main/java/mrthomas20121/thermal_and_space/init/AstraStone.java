package mrthomas20121.thermal_and_space.init;

import net.minecraft.world.level.material.MaterialColor;

public enum AstraStone {

    GLACIO(false, MaterialColor.ICE),
    MARS(true, MaterialColor.TERRACOTTA_RED),
    MERCURY(false, MaterialColor.TERRACOTTA_PURPLE),
    MOON(true, MaterialColor.TERRACOTTA_LIGHT_GRAY),
    VENUS(true, MaterialColor.TERRACOTTA_ORANGE);

    private final boolean isSand;
    private MaterialColor color;

    AstraStone(boolean isSand, MaterialColor color) {
        this.isSand = isSand;
        this.color = color;
    }

    public MaterialColor getColor() {
        return color;
    }

    public boolean isSand() {
        return isSand;
    }
}
