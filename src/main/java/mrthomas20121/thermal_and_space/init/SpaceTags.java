package mrthomas20121.thermal_and_space.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SpaceTags {

    public static TagKey<Block> glacio_ore_replaceables = create("ad_astra:glacio_ore_replaceables");
    public static TagKey<Block> mars_ore_replaceables = create("ad_astra:mars_ore_replaceables");
    public static TagKey<Block> mercury_ore_replaceables = create("ad_astra:mercury_ore_replaceables");
    public static TagKey<Block> moon_ore_replaceables = create("ad_astra:moon_ore_replaceables");
    public static TagKey<Block> venus_ore_replaceables = create("ad_astra:venus_ore_replaceables");

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(name));
    }
}
