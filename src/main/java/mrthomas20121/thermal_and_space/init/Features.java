package mrthomas20121.thermal_and_space.init;

import mrthomas20121.thermal_and_space.ThermalAndSpace;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class Features {

    public static ResourceKey<PlacedFeature> APATITE = createKey("apatite");
    public static ResourceKey<PlacedFeature> LARGE_APATITE = createKey("large_apatite");
    public static ResourceKey<PlacedFeature> CINNABAR = createKey("cinnabar");
    public static ResourceKey<PlacedFeature> LARGE_CINNABAR = createKey("large_cinnabar");
    public static ResourceKey<PlacedFeature> LEAD = createKey("lead");
    public static ResourceKey<PlacedFeature> LARGE_LEAD = createKey("large_lead");
    public static ResourceKey<PlacedFeature> NICKEL = createKey("nickel");
    public static ResourceKey<PlacedFeature> LARGE_NICKEL = createKey("large_nickel");
    public static ResourceKey<PlacedFeature> NITER = createKey("niter");
    public static ResourceKey<PlacedFeature> LARGE_NITER = createKey("large_niter");
    public static ResourceKey<PlacedFeature> RUBY = createKey("ruby");
    public static ResourceKey<PlacedFeature> LARGE_RUBY = createKey("large_ruby");
    public static ResourceKey<PlacedFeature> SAPPHIRE = createKey("sapphire");
    public static ResourceKey<PlacedFeature> LARGE_SAPPHIRE = createKey("large_sapphire");
    public static ResourceKey<PlacedFeature> SILVER = createKey("silver");
    public static ResourceKey<PlacedFeature> LARGE_SILVER = createKey("large_silver");
    public static ResourceKey<PlacedFeature> SULFUR = createKey("sulfur");
    public static ResourceKey<PlacedFeature> LARGE_SULFUR = createKey("large_sulfur");
    public static ResourceKey<PlacedFeature> TIN = createKey("tin");
    public static ResourceKey<PlacedFeature> LARGE_TIN = createKey("large_tin");

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(ThermalAndSpace.MOD_ID, name));
    }
}
