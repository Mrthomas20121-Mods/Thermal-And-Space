package mrthomas20121.thermal_and_space.init;

import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.MaterialColor;

public enum AstraStone {

    GLACIO(false, MaterialColor.ICE, new TagMatchTest(SpaceTags.glacio_ore_replaceables)),
    MARS(true, MaterialColor.TERRACOTTA_RED, new TagMatchTest(SpaceTags.mars_ore_replaceables)),
    MERCURY(false, MaterialColor.TERRACOTTA_PURPLE, new TagMatchTest(SpaceTags.mercury_ore_replaceables)),
    MOON(true, MaterialColor.TERRACOTTA_LIGHT_GRAY, new TagMatchTest(SpaceTags.moon_ore_replaceables)),
    VENUS(true, MaterialColor.TERRACOTTA_ORANGE, new TagMatchTest(SpaceTags.venus_ore_replaceables));

    private final boolean isSand;
    private MaterialColor color;
    private TagMatchTest tag;

    AstraStone(boolean isSand, MaterialColor color, TagMatchTest tag) {
        this.isSand = isSand;
        this.color = color;
        this.tag = tag;
    }

    public MaterialColor getColor() {
        return color;
    }

    public boolean isSand() {
        return isSand;
    }

    public TagMatchTest getTag() {
        return tag;
    }
}
