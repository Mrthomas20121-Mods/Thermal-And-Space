package mrthomas20121.thermal_and_space.init;

import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public enum AstraStone {

    GLACIO(false, new TagMatchTest(SpaceTags.glacio_ore_replaceables)),
    MARS(true, new TagMatchTest(SpaceTags.mars_ore_replaceables)),
    MERCURY(false, new TagMatchTest(SpaceTags.mercury_ore_replaceables)),
    MOON(true, new TagMatchTest(SpaceTags.moon_ore_replaceables)),
    VENUS(true, new TagMatchTest(SpaceTags.venus_ore_replaceables));

    private final boolean isSand;
    private TagMatchTest tag;

    AstraStone(boolean isSand, TagMatchTest tag) {
        this.isSand = isSand;
        this.tag = tag;
    }

    public boolean isSand() {
        return isSand;
    }

    public TagMatchTest getTag() {
        return tag;
    }
}
