package mrthomas20121.thermal_and_space.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class SpaceTags {

    public static TagKey<Block> glacio_ore_replaceables = create("ad_astra:glacio_ore_replaceables");
    public static TagKey<Block> mars_ore_replaceables = create("ad_astra:mars_ore_replaceables");
    public static TagKey<Block> mercury_ore_replaceables = create("ad_astra:mercury_ore_replaceables");
    public static TagKey<Block> moon_ore_replaceables = create("ad_astra:moon_ore_replaceables");
    public static TagKey<Block> venus_ore_replaceables = create("ad_astra:venus_ore_replaceables");

    public static TagKey<Biome> ad_adstra_biomes = biome("ad_astra:stone_biomes");

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(name));
    }

    private static TagKey<Biome> biome(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(name));
    }
}
